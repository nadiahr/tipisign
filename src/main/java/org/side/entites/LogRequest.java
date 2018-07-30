package org.side.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class LogRequest.
 */
@Entity
public class LogRequest implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id log request. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idLogRequest;
	
	/** The title. */
	private String title;
	
	/** The detail. */
	private String detail;
	
	/** The created at. */
	private Timestamp createdAt;
	
	/** The id request. */
	private long idRequest;
	
	/** The status request. */
	private String statusRequest;
	
	/** The from user. */
	private String fromUser;
	
	/** The to user. */
	private String toUser;
	
	/**
	 * Instantiates a new log request.
	 */
	public LogRequest() {
		super();
	}

	/**
	 * Gets the id log request.
	 *
	 * @return the id log request
	 */
	public long getIdLogRequest() {
		return idLogRequest;
	}

	/**
	 * Sets the id log request.
	 *
	 * @param idLogRequest the new id log request
	 */
	public void setIdLogRequest(long idLogRequest) {
		this.idLogRequest = idLogRequest;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the detail.
	 *
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * Sets the detail.
	 *
	 * @param detail the new detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
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
	 * Gets the status request.
	 *
	 * @return the status request
	 */
	public String getStatusRequest() {
		return statusRequest;
	}

	/**
	 * Sets the status request.
	 *
	 * @param statusRequest the new status request
	 */
	public void setStatusRequest(String statusRequest) {
		this.statusRequest = statusRequest;
	}

	/**
	 * Gets the from user.
	 *
	 * @return the from user
	 */
	public String getFromUser() {
		return fromUser;
	}

	/**
	 * Sets the from user.
	 *
	 * @param fromUser the new from user
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * Gets the to user.
	 *
	 * @return the to user
	 */
	public String getToUser() {
		return toUser;
	}

	/**
	 * Sets the to user.
	 *
	 * @param toUser the new to user
	 */
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
}