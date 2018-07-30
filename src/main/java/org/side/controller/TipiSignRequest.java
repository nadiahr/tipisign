package org.side.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;
import org.side.dao.LogRequestRepository;
import org.side.dao.RequestRepository;
import org.side.dao.UserInformationRepository;
import org.side.dao.UserToUserRequestRepository;
import org.side.entites.LogRequest;
import org.side.entites.Request;
import org.side.entites.UserInformation;
import org.side.entites.UserToUserRequest;
import org.side.entites.UserToUserRequestPK;
import org.side.jsonentity.Action;
import org.side.jsonentity.Attachment;
import org.side.jsonentity.Confirm;
import org.side.jsonentity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class TipiSignRequest.
 */
@Service
public class TipiSignRequest {
	
	/** The request repository. */
	@Autowired
	RequestRepository requestRepository;

	/** The user to user request repository. */
	@Autowired
	UserToUserRequestRepository userToUserRequestRepository;

	/** The user information repository. */
	@Autowired
	UserInformationRepository userInformationRepository;
	
	/** The log request repository. */
	@Autowired
	LogRequestRepository logRequestRepository ; 

	/**
	 * Save request and user.
	 *
	 * @param R the r
	 * @param userFrom the user from
	 * @param userTo the user to
	 */
	public void saveRequestAndUser(Request R, UserInformation userFrom, UserInformation userTo   )   {
		requestRepository.saveAndFlush(R);
		UserToUserRequest U = new UserToUserRequest();
		LogRequest L = new LogRequest() ; 
		U.setRequest(R);
		U.setUserFrom(userFrom);
		U.setUserTo(userTo);
		L.setIdRequest(R.getIdRequest());
		L.setDetail(R.getDetailRequest());
		L.setCreatedAt(R.getCreatedAt());
		L.setFromUser(U.getUserFrom().getAccountName());
		L.setStatusRequest(R.getStatus());
		L.setTitle(R.getTitleRequest());
		L.setToUser(U.getUserTo().getAccountName());
		U.setOldIdRequest(R.getIdRequest());
		U.setUserToUserRequestPK(new UserToUserRequestPK(userFrom.getIdUser(), userTo.getIdUser(), R.getIdRequest()));
		try {
			sendAlertViaSlack(userTo.getAccountName(), userFrom.getAccountName(),R.getTitleRequest());
		} catch (JSONException e1) {
			
			e1.printStackTrace();
		}
		userToUserRequestRepository.saveAndFlush(U);
		logRequestRepository.save(L);
	
		try {
			sendButtonViaSlack();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Pass request and user.
	 *
	 * @param R the r
	 * @param userFrom the user from
	 * @param userTo the user to
	 * @param oldIdRequest the old id request
	 */
	public void passRequestAndUser(Request R, UserInformation userFrom, UserInformation userTo ,long  oldIdRequest  )   {
		requestRepository.saveAndFlush(R);
		UserToUserRequest U = new UserToUserRequest();
		LogRequest L = new LogRequest() ; 
		
		L.setIdRequest(oldIdRequest);
		L.setDetail(R.getDetailRequest());
		L.setCreatedAt(R.getCreatedAt());
		L.setFromUser(userFrom.getAccountName());
		L.setStatusRequest(R.getStatus());
		L.setTitle(R.getTitleRequest());
		L.setToUser(userTo.getAccountName());
		
		U.setRequest(R);
		
        U.setUserFrom(userFrom);
		U.setUserTo(userTo);
		
		U.setOldIdRequest(oldIdRequest);
		U.setUserToUserRequestPK(new UserToUserRequestPK(userFrom.getIdUser(), userTo.getIdUser(), R.getIdRequest()));
		try {
			sendAlertViaSlack(userTo.getAccountName(),userFrom.getAccountName() ,R.getTitleRequest());
		} catch (JSONException e1) {
			
			e1.printStackTrace();
		}
		userToUserRequestRepository.saveAndFlush(U);
		logRequestRepository.save(L);
		try {
			sendButtonViaSlack();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Send button via slack.
	 *
	 * @throws JSONException the JSON exception
	 * @throws JsonProcessingException the json processing exception
	 */
	private void sendButtonViaSlack() throws JSONException, JsonProcessingException {
		String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		Message slackMessage = new Message();
		Attachment attachment = new Attachment();
		attachment.setText("do you want to ");
		attachment.setCallback_id("wopr_game");
		attachment.setColor("#3AA3E3");
		attachment.setAttachment_type("default");
		Action action = new Action();
		action.setName("game");
		action.setText("Approve");
		action.setType("button");
		action.setValue("Approve");
		Action action2 = new Action();
		action2.setName("game");
		action2.setText("disapprove");
		action2.setStyle("danger");
		action2.setType("button");
		action2.setValue("maze");
		
		Confirm confirm = new Confirm();
		confirm.setTitle("Are you sure");
		confirm.setOk_text("Yes");
		confirm.setDismiss_text("No");
		action2.setConfirm(confirm);
		attachment.setActions(action, action2);
		slackMessage.setAttachments(Collections.singletonList(attachment));
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.setSerializationInclusion(Include.NON_NULL).writerWithDefaultPrettyPrinter()
				.writeValueAsString(slackMessage);
		String jsonResult = jsonInString;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}


	/**
	 * Send alert via slack.
	 *
	 * @param username the username
	 * @param timestamp the timestamp
	 * @throws JSONException the JSON exception
	 */
	private void sendAlertViaSlack(String username, String From , String timestamp) throws JSONException {
		String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String input = "Notification to :  " + username + " a new request for you  from "+From+"\n Title : " + timestamp + "";
		JSONObject jsonSlack = new JSONObject();
		jsonSlack.put("text", input);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonSlack.toString(), headers);
		restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}

	

}
