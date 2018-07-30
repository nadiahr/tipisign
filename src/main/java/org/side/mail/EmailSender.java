package org.side.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailSender.
 */
@Component
public class EmailSender {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

	/** The java mail sender. */
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-Web-Admin
	 * 
	 *         Class Name: EmailSender.java
	 * 
	 *         this method Send plain text.
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param text
	 *            the text
	 * @throws MessagingException
	 *             the messaging exception
	 * @throws UnsupportedEncodingException 
	 */
	public void sendPlainText(String to, String subject, String text) throws MessagingException, UnsupportedEncodingException {
		sendM(to, subject, text, false);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-Web-Admin
	 * 
	 *         Class Name: EmailSender.java
	 * 
	 *         this method Send html.
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param htmlBody
	 *            the html body
	 * @throws MessagingException
	 *             the messaging exception
	 * @throws UnsupportedEncodingException 
	 */
	public void sendHtml(String to, String subject, String htmlBody) throws MessagingException, UnsupportedEncodingException {
		sendM(to, subject, htmlBody, true);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-Web-Admin
	 * 
	 *         Class Name: EmailSender.java
	 * 
	 *         this method Send M.
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param text
	 *            the text
	 * @param isHtml
	 *            the is html
	 * @throws MessagingException
	 *             the messaging exception
	 * @throws UnsupportedEncodingException
	 */
	private void sendM(String to, String subject, String text, Boolean isHtml)
			throws MessagingException, UnsupportedEncodingException {

		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		//mail.setFrom(new InternetAddress("segma55@outlook.com"));
		mail.setFrom(new InternetAddress("tipisign@hrdatabank.com"));
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, isHtml);
		javaMailSender.send(mail);
		LOGGER.info("Send email '{}' to: {}", subject, to);
		// return new EmailStatus(to, subject, text).success();
		//
		// System.out.println("---"+e.getMessage());
		// LOGGER.error(String.format("Problem with sending email to: {}, error
		// message:{}", to, e.getMessage()));
		// return new EmailStatus(to, subject, text).error(e.getMessage());

	}
}
