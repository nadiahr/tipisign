package org.side.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.side.dao.UserInformationRepository;
import org.side.entites.UserInformation;
import org.side.mail.EmailHtmlSender;
import org.side.security.excepctions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class TipiSignUserInfo.
 */
@RestController
@CrossOrigin(origins = "**")
public class TipiSignUserInfo {

	/** The user information repository. */
	@Autowired
	UserInformationRepository userInformationRepository;

	/** The email html sender. */
	@Autowired
	EmailHtmlSender emailHtmlSender;

	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Save user information.
	 *
	 * @param u the u
	 * @return the user information
	 * @throws EmailExistsException the email exists exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws MessagingException the messaging exception
	 */
	public UserInformation saveUserInformation(UserInformation u)
			throws EmailExistsException, UnsupportedEncodingException, MessagingException {
		UserInformation userInformation = registerNewUserAccount(u);
		String accountName = u.getAccountName();
		u.setAccountName(accountName.toLowerCase());
		emailHtmlSender.send(userInformation.getEmail(), "tipiSign register ",
				"successful registration on tipiSign http://tipisign.com:8080");
		return userInformationRepository.saveAndFlush(u);
	}

	/**
	 * Register new user account.
	 *
	 * @param user the user
	 * @return the user information
	 * @throws EmailExistsException the email exists exception
	 */
	public UserInformation registerNewUserAccount(UserInformation user) throws EmailExistsException {
		if (emailExist(user.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress:" + user.getEmail());
		}
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		return userInformationRepository.saveAndFlush(user);
	}

	/**
	 * Email exist.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	private boolean emailExist(final String email) {
		return userInformationRepository.findByEmail(email) != null;
	}
	
	/**
	 * Send invitation.
	 *
	 * @param email the email
	 * @throws EmailExistsException the email exists exception
	 */
	@RequestMapping(value = "/sendInvite", method = RequestMethod.POST)
	public void sendInvitation(@RequestBody String email) throws EmailExistsException {
		System.out.println("email"+email);
		if (emailExist( email)) {
			throw new EmailExistsException("There is an account with that email adress:" +  email);
		} else {
			try {
				emailHtmlSender.send( email, "tipiSign invitation ",
						"Join us on TipiSign ” http://tipisign.com:8080");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

