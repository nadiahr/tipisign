package org.side.security.auth.ajax;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * Model intended to be used for AJAX based authentication.
 * 
 * @author nadia
 *
 * 
 */

public class LoginRequest {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new login request.
	 *
	 * @param username the username
	 * @param password the password
	 */
	@JsonCreator
	public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
