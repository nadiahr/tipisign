package org.side.entites;


// TODO: Auto-generated Javadoc
/**
 * The Enum Role.
 */
public enum Role {
	
	/** The admin. */
	ADMIN, 
 /** The Simple user. */
 Simple_User;

	/**
	 * Authority.
	 *
	 * @return the string
	 */
	public String authority() {
		return "ROLE_" + this.name();
	}
}
