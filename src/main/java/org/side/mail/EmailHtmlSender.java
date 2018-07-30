package org.side.mail;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailHtmlSender.
 */
@Component
public class EmailHtmlSender {

	/** The email sender. */
	@Autowired
	private EmailSender emailSender;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-Web-Admin
	 * 
	 * Class Name: EmailHtmlSender.java
	 * 
	 * this method Send.
	 * @param to the to
	 * @param subject the subject
	 * @param body the body
	 * @throws MessagingException the messaging exception
	 * @throws UnsupportedEncodingException 
	 */
	public void send(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException {
		emailSender.sendHtml(to, subject, body);
	}

}
