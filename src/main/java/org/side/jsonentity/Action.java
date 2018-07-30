/**
 * 
 */
package org.side.jsonentity;

// TODO: Auto-generated Javadoc
/**
 * The Class Action.
 *
 * @author Nadia
 */
public class Action {

	/** The text. */
	private String text;

	/** The name. */
	private String name;

	/** The style. */
	private String style;

	/** The value. */
	private String value;

	/** The type. */
	private String type;

	/** The confirm. */
	private Confirm confirm;
	private String url;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Nadia
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: tipi-sign
	 * 
	 *         Class Name: Action.java
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
	 *         Class Name: Action.java
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
	 *         Class Name: Action.java
	 * 
	 *         Gets the name.
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 *         Class Name: Action.java
	 * 
	 *         Sets the name.
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 *         Class Name: Action.java
	 * 
	 *         Gets the value.
	 * @return the value
	 */
	public String getValue() {
		return value;
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
	 *         Class Name: Action.java
	 * 
	 *         Sets the value.
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
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
	 *         Class Name: Action.java
	 * 
	 *         Gets the type.
	 * @return the type
	 */
	public String getType() {
		return type;
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
	 *         Class Name: Action.java
	 * 
	 *         Sets the type.
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
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
	 *         Class Name: Action.java
	 * 
	 *         Gets the style.
	 * @return the style
	 */
	public String getStyle() {
		return style;
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
	 *         Class Name: Action.java
	 * 
	 *         Sets the style.
	 * @param style
	 *            the new style
	 */
	public void setStyle(String style) {
		this.style = style;
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
	 *         Class Name: Action.java
	 * 
	 *         Gets the confirm.
	 * @return the confirm
	 */
	public Confirm getConfirm() {
		return confirm;
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
	 *         Class Name: Action.java
	 * 
	 *         Sets the confirm.
	 * @param confirm
	 *            the new confirm
	 */
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Action [text=" + text + ", name=" + name + ", style=" + style + ", value=" + value + ", type=" + type
				+ ", confirm=" + confirm + " ,url = " + url + "]";
	}

}
