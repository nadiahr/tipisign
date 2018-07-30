package org.side.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jose4j.lang.JoseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.side.dao.LogRequestRepository;
import org.side.dao.NotificationRepository;
import org.side.dao.RequestRepository;
import org.side.dao.UserInformationRepository;
import org.side.dao.UserRoleRepository;
import org.side.entites.LogRequest;
import org.side.entites.Notification;
import org.side.entites.Request;
import org.side.entites.UserInformation;
import org.side.jsonentity.Action;
import org.side.jsonentity.Attachment;
import org.side.jsonentity.Confirm;
import org.side.jsonentity.Message;
import org.side.mail.EmailHtmlSender;
import org.side.security.UserService;
import org.side.security.auth.JwtAuthenticationToken;
import org.side.security.auth.ajax.AjaxLoginProcessingFilter;
import org.side.security.auth.jwt.extractor.TokenExtractor;
import org.side.security.auth.jwt.verifier.TokenVerifier;
import org.side.security.config.JwtSettings;
import org.side.security.config.WebSecurityConfig;
import org.side.security.excepctions.EmailExistsException;
import org.side.security.excepctions.InvalidJwtToken;
import org.side.security.model.UserContext;
import org.side.security.model.token.JwtToken;
import org.side.security.model.token.JwtTokenFactory;
import org.side.security.model.token.RawAccessJwtToken;
import org.side.security.model.token.RefreshToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Subscription;

/**
 * The Class RequestRepositoryRest.
 */
@RestController
@CrossOrigin
public class RequestRepositoryRest {

	/** The user repository. */
	@Autowired
	UserInformationRepository userInformationRepository;

	/** The request repository. */
	@Autowired
	RequestRepository requestRepository;

	/** The Log request repository. */
	@Autowired
	LogRequestRepository LogRequestRepository;

	/** The User role repository. */
	@Autowired
	UserRoleRepository UserRoleRepository;

	/** The json result. */
	String jsonResult;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	EmailHtmlSender emailHtmlSender;

	/**
	 * this method to get request by id.
	 *
	 * @author nadia
	 * @param id
	 *            the id
	 * @return the request
	 */
//	@RequestMapping(value = "/requests/{id}", method = RequestMethod.GET)
//	public Request getRequest(@PathVariable int id) {
//		return requestRepository.findOne(id);
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Delete.
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public boolean delete(@PathVariable int id) {
//		requestRepository.delete(id);
//		return true;
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the requests.
	 * @return the requests
	 */
//	@RequestMapping(value = "/request", method = RequestMethod.GET)
//	public List<Request> getRequests() {
//		return requestRepository.findAll();
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param R
	 *            the r
	 * @return the request
	 * @throws JSONException
	 *             the JSON exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
//	 */
//	@RequestMapping(value = "/requests", method = RequestMethod.POST)
//public Request save(@RequestBody Request R) throws JSONException, IOException {
//	Logger logger = LoggerFactory.getLogger(AjaxLoginProcessingFilter.class);
//		System.out.println("idrequest :" + R.getIdRequest());
//		System.out.println("titleRequest :" + R.getTitleRequest());
//		System.out.println("toUser :" + R.getUserInformation().getIdUser());
//		sendAlertViaSlack(R.getUserInformation().getAccountName(), R.getDetailsRequest());
//		sendButtonViaSlack();
//
//		Request request = requestRepository.save(R);
//
//		try {

			// String json;
			//
			// String filepath = "resources/" + "data.json";
			// File file = new File(filepath);
			// if (!file.exists()) {
			// System.out.println("pai nai");
			// file.createNewFile();
//			// }
//			ObjectMapper mapper = new ObjectMapper();
//			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//			writer.writeValue(new File("c:/users/user/pfe/tipi-sign/JsonFiles/data.json"), request);
//			// json =
//			mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
//			// Files.write(new File("data.json").toPath(), Arrays.asList(json),
//			// StandardOpenOption.APPEND);
//			System.out.println("**********************************");
//
//		}
//
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		// mapper.writerWithDefaultPrettyPrinter().writeValue(new
		// File("result.json"), R);
		// System.out.println("**************************");
		// System.out.println(jsonInString);
		// System.out.println("**************************");
		//return request;
		// JSONParser parser = new JSONParser();

		// convert from JSON string to JSONObject
		// org.json.simple.JSONObject newJObject = (org.json.simple.JSONObject)
		// parser.parse(toString());
		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// String jsonString = request.getParameter("json");
		// HttpEntity<String> entity = new HttpEntity<String>(jsonString,
		// headers);
		// System.out.println(entity);
		// return jsonString;

	//}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @return the request
	 */
	public String approved;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param id
	 *            the id
	 * @param c
	 *            the c
	 * @return the request
	 */
//	@RequestMapping(value = "/requests/{id}", method = RequestMethod.PUT)
//	public Request save(@PathVariable int id, @RequestBody Request c) {
//		c.getIdrequest();
//		// c.setStatus(approved);
//		return requestRepository.save(c);
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the user.
	 * @param id
	 *            the id
	 * @return the user
	 */
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//
//	public UserInformation getUser(@PathVariable long id) {
//		return userInformationRepository.findOne(id);
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the users.
	 * @return the users
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserInformation> getUsers() {
		return userInformationRepository.findAll();
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param R
	 *            the r
	 * @return the user information
	 * @throws EmailExistsException
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
//	@RequestMapping(value = "/users", method = RequestMethod.POST)
//	public UserInformation save(@RequestBody UserInformation R) throws EmailExistsException, UnsupportedEncodingException, MessagingException {
//		
//		UserInformation userInformation=registerNewUserAccount(R);
//		emailHtmlSender.send(userInformation.getEmail(), "ayya wayya ",
//				"http://localhost:4300/request/"+userInformation.getIdUser());
//		// return userInformationRepository.save(R);
//		return userInformation;
//			
//		
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Login.
	 * @param userInformation
	 *            the user information
	 * @return the user information
	 */
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public UserInformation login(@RequestBody UserInformation userInformation) {
//		return userInformationRepository.checkLogin(userInformation.getAccountName(), userInformation.getPassword());
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param id
	 *            the id
	 * @param c
	 *            the c
	 * @return the user information
//	 */
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
//	public UserInformation save(@PathVariable int id, @RequestBody UserInformation c) {
//
//		c.setIdUser(id);
//		System.out.println("account name" + c.getAccountName());
//		return userInformationRepository.save(c);
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Chercher.
	 * @param motcle
	 *            the motcle
	 * @param numPage
	 *            the num page
	 * @param size
	 *            the size
	 * @return the page
	 */
//	@RequestMapping(value = "/chercher", method = RequestMethod.GET)
//	public Page<Request> chercher(@RequestParam(name = "motcle", defaultValue = "") String motcle,
//			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
//			@RequestParam(name = "size", defaultValue = "5") int size) {
//		System.out.println("motcle = " + motcle);
//		System.out.println("numpage = " + numPage);
//		System.out.println("size = " + size);
//		return requestRepository.chercher("%" + motcle + "%", new PageRequest(numPage, size));
//
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the log request.
	 * @param id
	 *            the id
	 * @return the log request
	 */
	@RequestMapping(value = "/logRequest/{id}", method = RequestMethod.GET)
	public LogRequest getLogRequest(@PathVariable int id) {
		return LogRequestRepository.findOne(id);

	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the log requests.
	 * @return the log requests
	 */
	@RequestMapping(value = "/logRequests", method = RequestMethod.GET)
	public List<LogRequest> getLogRequests() {
		return LogRequestRepository.findAll();
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param R
	 *            the r
	 * @return the log request
	 */
	@RequestMapping(value = "/logRequests", method = RequestMethod.POST)
	public LogRequest save(@RequestBody LogRequest R) {
		return LogRequestRepository.save(R);

	}

	@RequestMapping(value = "/notifications", method = RequestMethod.POST)
	public Notification save(@RequestBody Notification N) {
		return notificationRepository.save(N);

	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Save.
	 * @param id
	 *            the id
	 * @param c
	 *            the c
	 * @return the log request
	 */
	@RequestMapping(value = "/logRequest/{id}", method = RequestMethod.PUT)
	public LogRequest save(@PathVariable int id, @RequestBody LogRequest c) {

		c.setIdLogRequest(id);

		return LogRequestRepository.save(c);

	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Gets the.
	 * @param token
	 *            the token
	 * @return the user context
	 */
//	@RequestMapping(value = "/api/me", method = RequestMethod.GET)
//	public @ResponseBody UserContext get(JwtAuthenticationToken token) {
//		return (UserContext) token.getPrincipal();
//	}

	/** The token factory. */
	@Autowired
	private JwtTokenFactory tokenFactory;

	/** The jwt settings. */
	@Autowired
	private JwtSettings jwtSettings;

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The token verifier. */
	@Autowired
	private TokenVerifier tokenVerifier;

	/** The token extractor. */
	@Autowired
	@Qualifier("jwtHeaderTokenExtractor")
	private TokenExtractor tokenExtractor;

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Refresh token.
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the jwt token
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception
	 */
//	@RequestMapping(value = "/api/auth/token", method = RequestMethod.GET, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	public @ResponseBody JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.AUTHENTICATION_HEADER_NAME));
//
//		RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
//		RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey())
//				.orElseThrow(() -> new InvalidJwtToken());
//
//		String jti = refreshToken.getJti();
//		if (!tokenVerifier.verify(jti)) {
//			throw new InvalidJwtToken();
//		}
//
//		String subject = refreshToken.getSubject();
//		UserInformation user = userService.getByUsername(subject)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));
//
//		if (user.getRoles() == null)
//			throw new InsufficientAuthenticationException("User has no roles assigned");
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
//				.collect(Collectors.toList());
//
//		UserContext userContext = UserContext.create(user.getAccountName(), authorities);
//
//		return tokenFactory.createAccessJwtToken(userContext);
//	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author user
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         Webhook.
	 * @return the map
	 * @throws JSONException
	 *             the JSON exception
	 * @throws IOException
	 *             SignaemailHtmlSender.send(R.getEmail(), "ayya wayya ",
				"http://localhost:4300/request/"+R.getIdUser());
		ls that an I/O exception has occurred.
	 * @throws ParseException
	 *             the parse exception
	 */

	@RequestMapping(value = "/webhook", method = RequestMethod.GET)
	public org.json.simple.JSONObject webhook() throws JSONException, IOException, ParseException {
		Logger logger = LoggerFactory.getLogger(AjaxLoginProcessingFilter.class);

		Map<String, Object> json = new HashMap<>();

		// JSONObject jsonResult = new JSONObject(obj);
		// JSONObject attachments = jsonResult.getJSONObject("attachments");
		// "text": "Choose a game to play",
		// "fallback": "You are unable to choose a game",
		// "callback_id": "wopr_game",
		// "color": "#3AA3E3",
		// "attachment_type": "default",
		// "actions"
		// {
		// "name": "game",
		// "text": "Chess",
		// "type": "button",
		// "value": "chess"
		// },
		// String text = jsonResult.getString("text");
		// String fallback = jsonResult.getString("fallback");
		// String callback_id = jsonResult.getString("callback_id");
		// String color = jsonResult.getString("color");
		// String attachmentType = jsonResult.getString("attachment_type");
		// JSONObject actions = attachments.getJSONObject("actions");
		// String name = actions.getString("name");
		// String text1 = actions.getString("text");
		// String value = actions.getString("value");
		// // String imageUrl = createUri("/static/buttons/1040.jpg");
		// String userId = jsonResult.getString("userId");
		// String customerMessage = jsonResult.getString("text");
		// String timestamp = jsonResult.getString("timestamp");
		// System.out.println("userId = " + userId);
		// U7aef88d7705932b2cdb53b316f32652d
		sendButtonViaSlack();
		// logger.info("slack :" + customerMessage);
		JSONParser parser = new JSONParser();

		// convert from JSON string to JSONObject
		org.json.simple.JSONObject newJObject = (org.json.simple.JSONObject) parser.parse(jsonResult);
		System.out.println(newJObject);
		return newJObject;
		// return (Map<String, Object>) new JSONObject(json);

	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         this method Send alert via slack.
	 * @param username
	 *            the username
	 * @param timestamp
	 *            the timestamp
	 * @throws JSONException
	 *             the JSON exception
	 */

	private void sendAlertViaSlack(String username, String timestamp) throws JSONException {
		String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String input = "Notification to :  " + username + " a new request for you \n Title : " + timestamp + "";

		// String input = "Notification to :"+ userId + "a new request for you
		// "\ n details:"+ timestamp +" ;
		JSONObject jsonSlack = new JSONObject();
		jsonSlack.put("text", input);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonSlack.toString(), headers);
		restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         this method Recuperer json.
	 * @param R
	 *            the r
	 * @throws JSONException
	 *             the JSON exception
	 * @throws JsonProcessingException
	 *             the json processing exception
	 */
	@RequestMapping(value = "/recupererJson", method = RequestMethod.POST)
	private void recupererJson(@RequestBody Request R) throws JSONException, JsonProcessingException {
		Message jsonMessage = new Message();

		requestRepository.save(R);

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.setSerializationInclusion(Include.NON_NULL).writerWithDefaultPrettyPrinter()
				.writeValueAsString(jsonMessage);
		jsonResult = jsonInString;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		System.out.println(entity);

	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         this method Send button via slack.
	 * @throws JSONException
	 *             the JSON exception
	 * @throws JsonProcessingException
	 *             the json processing exception
	 */
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	private void sendButtonViaSlack() throws JSONException, JsonProcessingException {
		String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		Message slackMessage = new Message();
		// slackMessage.setText("Would you like to play a game?");
		Attachment attachment = new Attachment();
		attachment.setText("do you want to ");
		// attachment.setFallback("You are unable to choose a game");
		attachment.setCallback_id("wopr_game");
		attachment.setColor("#3AA3E3");
		attachment.setAttachment_type("default");
		Action action = new Action();
		action.setName("game");
		action.setText("Approve");
		action.setType("button");
		action.setValue("Approve");
		// Action action1 = new Action();
		// action1.setName("game");
		// action1.setText("Thermonuclear War");
		// action1.setType("button");
		// action1.setValue("war");
		Action action2 = new Action();
		action2.setName("game");
		action2.setText("disapprove");
		action2.setStyle("danger");
		action2.setType("button");
		action2.setValue("maze");
		
		Confirm confirm = new Confirm();
		confirm.setTitle("Are you sure");
		// confirm.setText("Wouldn't you prefer a good game of chess");
		confirm.setOk_text("Yes");
		confirm.setDismiss_text("No");
		action2.setConfirm(confirm);
		attachment.setActions(action, action2);
		slackMessage.setAttachments(Collections.singletonList(attachment));
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.setSerializationInclusion(Include.NON_NULL).writerWithDefaultPrettyPrinter()
				.writeValueAsString(slackMessage);
		jsonResult = jsonInString;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString, headers);
		restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: RequestRepositoryRest.java
	 * 
	 *         this method Process.
	 * @param payload
	 *            the payload
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/process", method = RequestMethod.POST, consumes = "application/json")
	public void process(@RequestBody Map<String, Object> payload) throws Exception {
		// requestRepository.save(entity) ;
		System.out.println(payload);

	}

	/*
	 * public void sendPushMessage() throws GeneralSecurityException, IOException,
	 * ExecutionException, InterruptedException {
	 * 
	 * Notification notification = null; PushService pushService; notification = new
	 * Notification(
	 * "https://fcm.googleapis.com/fcm/send/eLrI7FdZIdg:APA91bF-Gf9V4FtiQLo9PIVWr9NnDCeGUAfoIPw7FSTBwesxmg"
	 * + "-cxWczGL3dRT6N7vCfxjeFAjZGk5shWJfn8u" +
	 * "8PILVdcmxCHfLmsZHPhqEkW7dJiZQ02oE56" + "cl5wZw_np97DEufYzh7\"",
	 * "BGBI7uiW2dmak0eysqNetqJqnO8d0T5" + "rd4Ic2SOYYC6lvPVvm3jKcKq76gAZdn" +
	 * "EgXCv9GLSWYLBSBRi4ysPquNs=", "gYzc6XpkOAQqrBVy8py0Tg==", "");
	 * 
	 * pushService = new PushService();
	 * 
	 * pushService.send(notification); }
	 */

	/*
	 * public void sendPushMessagee(Subscription sub, byte[] payload) {
	 * 
	 * // Figure out if we should use GCM for this notification somehow // boolean
	 * useGcm = shouldUseGcm(sub); Notification notification; PushService
	 * pushService;
	 * 
	 * // if (useGcm) { // Create a notification with the endpoint, userPublicKey
	 * from the // subscription and a custom payload notification = new
	 * Notification(
	 * "https://fcm.googleapis.com/fcm/send/eLrI7FdZIdg:APA91bF-Gf9V4FtiQLo9PIVWr9NnDCeGUAfoIPw7FSTBwesxmg"
	 * + "-cxWczGL3dRT6N7vCfxjeFAjZGk5shWJfn8u" +
	 * "8PILVdcmxCHfLmsZHPhqEkW7dJiZQ02oE56" + "cl5wZw_np97DEufYzh7\"",
	 * "BGBI7uiW2dmak0eysqNetqJqnO8d0T5" + "rd4Ic2SOYYC6lvPVvm3jKcKq76gAZdn" +
	 * "EgXCv9GLSWYLBSBRi4ysPquNs=", "gYzc6XpkOAQqrBVy8py0Tg==", "");
	 * 
	 * // Instantiate the push service, no need to use an API key for Push API
	 * pushService = new PushService(); // } else { // Or create a GcmNotification,
	 * in case of Google Cloud Messaging // notification = new Notification( //
	 * "https://fcm.googleapis.com/fcm/send/eLrI7FdZIdg:APA91bF-Gf9V4FtiQLo9PIVWr9NnDCeGUAfoIPw7FSTBwesxmg"
	 * // + "-cxWczGL3dRT6N7vCfxjeFAjZGk5shWJfn8u" + //
	 * "8PILVdcmxCHfLmsZHPhqEkW7dJiZQ02oE56" // + "cl5wZw_np97DEufYzh7\"", //
	 * "BGBI7uiW2dmak0eysqNetqJqnO8d0T5" + "rd4Ic2SOYYC6lvPVvm3jKcKq76gAZdn" // +
	 * "EgXCv9GLSWYLBSBRi4ysPquNs=", // "gYzc6XpkOAQqrBVy8py0Tg==", "" // );
	 * 
	 * // Instantiate the push service with a GCM API key
	 * 
	 * // Send the notification pushService.send(notification); }
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserInformation registerNewUserAccount(UserInformation user) throws EmailExistsException {
		if (emailExist(user.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress:" + user.getEmail());
		}
		UserInformation newUser = new UserInformation();
		newUser.setAccountName(user.getAccountName());
		
		
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		newUser.setPassword(hashedPassword);

		newUser.setEmail(user.getEmail());

		return userInformationRepository.saveAndFlush(newUser);
	}

	private boolean emailExist(final String email) {
		return userInformationRepository.findByEmail(email) != null;
	}
}
