/**
 * 
 */
package org.side.jsonentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

// TODO: Auto-generated Javadoc
/**
 * The Class Attachment.
 *
 * @author Nadia
 */
@JsonRootName(value = "attachments")
public class Attachment {

	/** The fallback. */
	private String fallback;

	/** The callback id. */
	private String callback_id;

	/** The text. */
	private String text;

	/** The color. */
	private String color;

	/** The attachment type. */
	private String attachment_type;

	/** The actions. */
	// @JsonProperty(value = "actions")
	private List<Action> actions;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: Attachment.java
	 * 
	 *         Gets the fallback.
	 * @return the fallback
	 */
	public String getFallback() {
		return fallback;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Sets the fallback.
	 * @param fallback
	 *            the new fallback
	 */
	public void setFallback(String fallback) {
		this.fallback = fallback;
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
	 *         Class Name: Attachment.java
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
	 *         Class Name: Attachment.java
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
	 *         Class Name: Attachment.java
	 * 
	 *         Gets the color.
	 * @return the color
	 */
	public String getColor() {
		return color;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Sets the color.
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Gets the attachment type.
	 * @return the attachment type
	 */
	public String getAttachment_type() {
		return attachment_type;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Sets the attachment type.
	 * @param attachment_type
	 *            the new attachment type
	 */
	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Gets the actions.
	 * @return the actions
	 */
	public List<Action> getActions() {
		return actions;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Sets the actions.
	 * @param actions
	 *            the new actions
	 */
	public void setActions(Action... actions) {
		this.actions = new ArrayList<>();
		Collections.addAll(this.actions, actions);
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
	 *         Class Name: Attachment.java
	 * 
	 *         Gets the callback id.
	 * @return the callback id
	 */
	public String getCallback_id() {
		return callback_id;
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
	 *         Class Name: Attachment.java
	 * 
	 *         Sets the callback id.
	 * @param callback_id
	 *            the new callback id
	 */
	public void setCallback_id(String callback_id) {
		this.callback_id = callback_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassPojo [fallback = " + fallback + ", text = " + text + ", color = " + color + ", attachment_type = "
				+ attachment_type + ", actions = " + actions + ", callback_id = " + callback_id + "]";
	}
}
