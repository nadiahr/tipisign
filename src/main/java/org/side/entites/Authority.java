package org.side.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

// TODO: Auto-generated Javadoc
/**
 * The Class Authority.
 */
@Entity
public class Authority implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The authority id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long authorityId;
	
	/** The authority. */
	private String authority;
	
	/** The ranking. */
	private long ranking;

	/** The users. */
	@OneToMany(mappedBy = "authority")
	private Collection<UserInformation> users;

	/**
	 * Instantiates a new authority.
	 */
	public Authority() {
		super();
	}

	/**
	 * Instantiates a new authority.
	 *
	 * @param authorityId the authority id
	 * @param authority the authority
	 * @param ranking the ranking
	 */
	public Authority(long authorityId, String authority, long ranking) {
		super();
		this.authorityId = authorityId;
		this.authority = authority;
		this.ranking = ranking;
	}

	/**
	 * Gets the authority id.
	 *
	 * @return the authority id
	 */
	public long getAuthorityId() {
		return authorityId;
	}

	/**
	 * Sets the authority id.
	 *
	 * @param authorityId the new authority id
	 */
	public void setAuthorityId(long authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 *
	 * @param authority the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * Gets the ranking.
	 *
	 * @return the ranking
	 */
	public long getRanking() {
		return ranking;
	}

	/**
	 * Sets the ranking.
	 *
	 * @param ranking the new ranking
	 */
	public void setRanking(long ranking) {
		this.ranking = ranking;
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@JsonIgnore
	public Collection<UserInformation> getUsers() {
		return users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the new users
	 */
	@JsonSetter
	public void setUsers(Collection<UserInformation> users) {
		this.users = users;
	}

}

