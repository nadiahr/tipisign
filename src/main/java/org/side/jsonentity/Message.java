/**
 * 
 */
package org.side.jsonentity;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 *
 * @author Nadia
 */
public class Message {

	/** The text. */
	private String text;

	/** The attachments. */
	private List<Attachment> attachments;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: Message.java
	 * 
	 *         Gets the text.
	 * @return the text
	 */
	public String getText() {
		return text;
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
	 *         Class Name: Message.java
	 * 
	 *         Sets the text.
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
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
	 *         Class Name: Message.java
	 * 
	 *         Gets the attachments.
	 * @return the attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
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
	 *         Class Name: Message.java
	 * 
	 *         Sets the attachments.
	 * @param attachments
	 *            the new attachments
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [text = " + text + ", attachments = " + attachments + "]";
	}
}
