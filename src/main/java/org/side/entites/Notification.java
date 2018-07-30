package org.side.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Notification.
 */
@Entity
public class Notification implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id notification. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNotification;
	
	/** The from user. */
	private String fromUser;
	
	/** The to user. */
	private String toUser;
	
	/** The read. */
	private boolean read;
	
	/** The created at. */
	private Timestamp createdAt;

	/**
	 * Instantiates a new notification.
	 */
	public Notification() {
		super();
	}

	/**
	 * Gets the id notification.
	 *
	 * @return the id notification
	 */
	public long getIdNotification() {
		return idNotification;
	}

	/**
	 * Sets the id notification.
	 *
	 * @param idNotification the new id notification
	 */
	public void setIdNotification(long idNotification) {
		this.idNotification = idNotification;
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

	/**
	 * Checks if is read.
	 *
	 * @return true, if is read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * Sets the read.
	 *
	 * @param read the new read
	 */
	public void setRead(boolean read) {
		this.read = read;
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

}