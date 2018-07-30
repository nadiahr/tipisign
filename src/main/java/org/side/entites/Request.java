package org.side.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 */
@Entity
public class Request implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id request. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRequest;
	
	/** The title request. */
	private String titleRequest;
	
	/** The hidden. */
	private boolean hidden = false;
	
	/** The status. */
	private String status = "pending";
	
	/** The created at. */
	private Timestamp createdAt;
	
	/** The updated at. */
	private Timestamp updatedAt;
	
	/** The detail request. */
	private String detailRequest;
	
	/** The visibility. */
	private long visibility;

	/** The comments. */
	@OneToMany(mappedBy = "request")
	private Collection<Comment> comments;

	/** The from and to users. */
	@OneToMany(mappedBy = "request" )
	private Collection<UserToUserRequest> fromAndToUsers;

	/**
	 * Instantiates a new request.
	 */
	public Request() {
	}

	/**
	 * Instantiates a new request.
	 *
	 * @param idRequest the id request
	 * @param hidden the hidden
	 * @param visibility the visibility
	 */
	public Request(long idRequest, boolean hidden, long visibility) {
		this.idRequest = idRequest;
		this.hidden = hidden;
		this.visibility = visibility;
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

	/**
	 * Gets the title request.
	 *
	 * @return the title request
	 */
	public String getTitleRequest() {
		return titleRequest;
	}

	/**
	 * Sets the title request.
	 *
	 * @param titleRequest the new title request
	 */
	public void setTitleRequest(String titleRequest) {
		this.titleRequest = titleRequest;
	}

	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the updated at.
	 *
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Checks if is hidden.
	 *
	 * @return true, if is hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the hidden.
	 *
	 * @param hidden the new hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the detail request.
	 *
	 * @return the detail request
	 */
	public String getDetailRequest() {
		return detailRequest;
	}

	/**
	 * Sets the detail request.
	 *
	 * @param detailRequest the new detail request
	 */
	public void setDetailRequest(String detailRequest) {
		this.detailRequest = detailRequest;
	}

	/**
	 * Gets the visibility.
	 *
	 * @return the visibility
	 */
	public long getVisibility() {
		return visibility;
	}

	/**
	 * Sets the visibility.
	 *
	 * @param visibility the new visibility
	 */
	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public Collection<Comment> getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * Gets the from and to users.
	 *
	 * @return the from and to users
	 */
	@JsonIgnore
	public Collection<UserToUserRequest> getFromAndToUsers() {
		return fromAndToUsers;
	}

	/**
	 * Sets the from and to users.
	 *
	 * @param fromAndToUsers the new from and to users
	 */
	@JsonSetter
	public void setFromAndToUsers(Collection<UserToUserRequest> fromAndToUsers) {
		this.fromAndToUsers = fromAndToUsers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [idRequest=" + idRequest + ", titleRequest=" + titleRequest + ", hidden=" + hidden + ", status="
				+ status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", detailRequest=" + detailRequest
				+ ", visibility=" + visibility + ", comments=" + comments + ", fromAndToUsers=" + fromAndToUsers + "]";
	}

}