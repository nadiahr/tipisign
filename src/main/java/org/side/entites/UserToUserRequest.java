package org.side.entites;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class UserToUserRequest.
 */
@Entity
public class UserToUserRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user to user request PK. */
	private UserToUserRequestPK userToUserRequestPK;
	
	/** The request. */
	private Request request;
	
	/** The user from. */
	private UserInformation userFrom;
	
	/** The user to. */
	private UserInformation userTo;
	
	/** The old id request. */
	private long oldIdRequest ;

	/**
	 * Gets the old id request.
	 *
	 * @return the old id request
	 */
	public long getOldIdRequest() {
		return oldIdRequest;
	}

	/**
	 * Sets the old id request.
	 *
	 * @param oldIdRequest the new old id request
	 */
	public void setOldIdRequest(long oldIdRequest) {
		this.oldIdRequest = oldIdRequest;
	}

	/**
	 * Instantiates a new user to user request.
	 */
	public UserToUserRequest() {
		super();
	}

	/**
	 * Gets the user to user request PK.
	 *
	 * @return the user to user request PK
	 */
	@EmbeddedId
	public UserToUserRequestPK getUserToUserRequestPK() {
		return userToUserRequestPK;
	}

	/**
	 * Sets the user to user request PK.
	 *
	 * @param userToUserRequestPK the new user to user request PK
	 */
	public void setUserToUserRequestPK(UserToUserRequestPK userToUserRequestPK) {
		this.userToUserRequestPK = userToUserRequestPK;
	}

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	@ManyToOne
	@JoinColumn(name = "idRequest", referencedColumnName = "idRequest",insertable = false , updatable = false)
	public Request getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the new request
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * Gets the user from.
	 *
	 * @return the user from
	 */
	@ManyToOne
	@JoinColumn(name = "idUserFrom", referencedColumnName = "idUser", insertable = false , updatable = false)
	public UserInformation getUserFrom() {
		return userFrom;
	}

	/**
	 * Sets the user from.
	 *
	 * @param userFrom the new user from
	 */
	public void setUserFrom(UserInformation userFrom) {
		this.userFrom = userFrom;
	}

	/**
	 * Gets the user to.
	 *
	 * @return the user to
	 */
	@ManyToOne
	@JoinColumn(name = "idUserTo", referencedColumnName = "idUser", insertable = false , updatable = false)
	public UserInformation getUserTo() {
		return userTo;
	}

	/**
	 * Sets the user to.
	 *
	 * @param userTo the new user to
	 */
	public void setUserTo(UserInformation userTo) {
		this.userTo = userTo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserToUserRequest [userToUserRequestPK=" + userToUserRequestPK + ", request=" + request + ", userFrom="
				+ userFrom + ", userTo=" + userTo + "]";
	}

}