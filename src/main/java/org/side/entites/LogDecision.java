package org.side.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class LogDecision.
 */
@Entity
public class LogDecision implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id decision. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDecision;
	
	/** The created at. */
	private Timestamp createdAt;
	
	/** The status. */
	private String status;
	
	/** The id request. */
	private long idRequest;
	
	/** The from user. */
	private String fromUser;
	
	/** The to user. */
	private String toUser;

	/**
	 * Instantiates a new log decision.
	 */
	public LogDecision() {
		super();
	}

	/**
	 * Gets the id decision.
	 *
	 * @return the id decision
	 */
	public long getIdDecision() {
		return idDecision;
	}

	/**
	 * Sets the id decision.
	 *
	 * @param idDecision the new id decision
	 */
	public void setIdDecision(long idDecision) {
		this.idDecision = idDecision;
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
