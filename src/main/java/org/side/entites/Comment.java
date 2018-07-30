package org.side.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
@Entity
public class Comment implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id comment. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idComment;
	
	/** The detail. */
	private String detail;
	
	/** The created at. */
	private Date createdAt;

	/** The request. */
	@ManyToOne
	@JoinColumn(name = "RequestId")
	private Request request;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
		super();
	}

	/**
	 * Instantiates a new comment.
	 *
	 * @param idComment the id comment
	 * @param createdAt the created at
	 */
	public Comment(long idComment, Date createdAt) {
		super();
		this.idComment = idComment;
		this.createdAt = createdAt;
	}

	/**
	 * Gets the id comment.
	 *
	 * @return the id comment
	 */
	public long getIdComment() {
		return idComment;
	}

	/**
	 * Sets the id comment.
	 *
	 * @param idComment the new id comment
	 */
	public void setIdComment(long idComment) {
		this.idComment = idComment;
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
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
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

}