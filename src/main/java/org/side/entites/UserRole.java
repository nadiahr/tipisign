package org.side.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	/** The id role. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idRole;
	
	/** The users. */
	@OneToMany(mappedBy = "userRole")
	private Collection<UserInformation> users;

	/** The role. */
	@Column(name = "ROLE")
	private String role;

	/**
	 * Gets the id role.
	 *
	 * @return the id role
	 */
	public long getIdRole() {
		return idRole;
	}

	/**
	 * Sets the id role.
	 *
	 * @param idRole the new id role
	 */
	public void setIdRole(long idRole) {
		this.idRole = idRole;
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

	/**
	 * Instantiates a new user role.
	 */
	public UserRole() {

	}

	/**
	 * Instantiates a new user role.
	 *
	 * @param idRole the id role
	 * @param users the users
	 * @param role the role
	 */
	public UserRole(long idRole, Collection<UserInformation> users, String role) {
		super();
		this.idRole = idRole;
		this.users = users;
		this.role = role;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
