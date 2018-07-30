package org.side.entites;

import java.io.Serializable;
import javax.persistence.Embeddable;

// TODO: Auto-generated Javadoc
/**
 * The Class UserToUserRequestPK.
 */
@Embeddable
public class UserToUserRequestPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id user from. */
	private String idUserFrom;
	
	/** The id user to. */
	private String idUserTo;
	
	/** The id request. */
	private long idRequest;

	
	/**
	 * Instantiates a new user to user request PK.
	 */
	public UserToUserRequestPK() {
	}

	/**
	 * Instantiates a new user to user request PK.
	 *
	 * @param idUserFrom the id user from
	 * @param idUserTo the id user to
	 * @param idRequest the id request
	 */
	public UserToUserRequestPK(String idUserFrom, String idUserTo, long idRequest) {
		this.idUserFrom = idUserFrom;
		this.idUserTo = idUserTo;
		this.idRequest = idRequest;
	}

	/**
	 * Gets the id user from.
	 *
	 * @return the id user from
	 */
	public String getIdUserFrom() {
		return idUserFrom;
	}

	/**
	 * Sets the id user from.
	 *
	 * @param idUserFrom the new id user from
	 */
	public void setIdUserFrom(String idUserFrom) {
		this.idUserFrom = idUserFrom;
	}

	/**
	 * Gets the id user to.
	 *
	 * @return the id user to
	 */
	public String getIdUserTo() {
		return idUserTo;
	}

	/**
	 * Sets the id user to.
	 *
	 * @param idUserTo the new id user to
	 */
	public void setIdUserTo(String idUserTo) {
		this.idUserTo = idUserTo;
	}

	/**
	 * Gets the id request.
	 *
	 * @return the id request
	 */
	public long getIdRequest() {
		return idRequest;
	}

	/**
	 * Sets the id request.
	 *
	 * @param idRequest the new id request
	 */
	public void setIdRequest(long idRequest) {
		this.idRequest = idRequest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idRequest ^ (idRequest >>> 32));
		result = prime * result + ((idUserFrom == null) ? 0 : idUserFrom.hashCode());
		result = prime * result + ((idUserTo == null) ? 0 : idUserTo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserToUserRequestPK other = (UserToUserRequestPK) obj;
		if (idRequest != other.idRequest)
			return false;
		if (idUserFrom == null) {
			if (other.idUserFrom != null)
				return false;
		} else if (!idUserFrom.equals(other.idUserFrom))
			return false;
		if (idUserTo == null) {
			if (other.idUserTo != null)
				return false;
		} else if (!idUserTo.equals(other.idUserTo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserToUserRequestPK [idUserFrom=" + idUserFrom + ", idUserTo=" + idUserTo + ", idRequest=" + idRequest
				+ "]";
	}

}