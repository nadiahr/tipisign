package org.side.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInformation.
 */
@Entity
public class UserInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id user. */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idUser;
	
	/** The account name. */
	private String accountName;
	
	/** The status. */
	private String status;
	
	/** The email. */
	private String email;
	
	/** The email verified. */
	private boolean emailVerified;
	
	/** The password. */
	private String password;
	
	/** The Photo. */
	private String Photo ;
	
	/** The line id. */
	private String lineId;
	
	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return Photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		Photo = photo;
	}

	/**
	 * Gets the line id.
	 *
	 * @return the line id
	 */
	public String getLineId() {
		return lineId;
	}

	/**
	 * Sets the line id.
	 *
	 * @param lineId the new line id
	 */
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	/** The created at. */
	private Timestamp createdAt;
	
	/** The last login. */
	private Timestamp lastLogin;
	
	/** The system language. */
	private String systemLanguage = "English";
	
	/** The initial setting. */
	private boolean initialSetting = true;
	
	/** The authority. */
	@ManyToOne
	@JoinColumn(name = "authority")
	
	private Authority authority;
	
	/** The user role. */
	@ManyToOne
	@JoinColumn(name = "userRole")
	
	private UserRole userRole;

	/** The line progresses. */
	@OneToMany(mappedBy = "userLine")
	
	private List<LineProgress> lineProgresses;

	/** The from users. */
	@OneToMany(mappedBy = "userFrom" )
	private List<UserToUserRequest> fromUsers;

	/**
	 * Gets the id user.
	 *
	 * @return the id user
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * Sets the id user.
	 *
	 * @param idUser the new id user
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/** The to users. */
	@OneToMany(mappedBy = "userTo" )
	private List<UserToUserRequest> toUsers;

	
	// @ManyToMany(mappedBy = "users")
	// private List<Company> companies;

	/**
	 * Instantiates a new user information.
	 */
	public UserInformation() {

	}

	/**
	 * Instantiates a new user information.
	 *
	 * @param idUser the id user
	 * @param accountName the account name
	 */
	public UserInformation(String idUser, String accountName) {
		this.idUser = idUser;
		this.accountName = accountName;
	}

	/**
	 * Gets the account name.
	 *
	 * @return the account name
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Sets the account name.
	 *
	 * @param accountName the new account name
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Checks if is email verified.
	 *
	 * @return true, if is email verified
	 */
	public boolean isEmailVerified() {
		return emailVerified;
	}

	/**
	 * Sets the email verified.
	 *
	 * @param emailVerified the new email verified
	 */
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Gets the system language.
	 *
	 * @return the system language
	 */
	public String getSystemLanguage() {
		return systemLanguage;
	}

	/**
	 * Sets the system language.
	 *
	 * @param systemLanguage the new system language
	 */
	public void setSystemLanguage(String systemLanguage) {
		this.systemLanguage = systemLanguage;
	}

	/**
	 * Checks if is initial setting.
	 *
	 * @return true, if is initial setting
	 */
	public boolean isInitialSetting() {
		return initialSetting;
	}

	/**
	 * Sets the initial setting.
	 *
	 * @param initialSetting the new initial setting
	 */
	public void setInitialSetting(boolean initialSetting) {
		this.initialSetting = initialSetting;
	}

	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	public Authority getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 *
	 * @param authority the new authority
	 */
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	// public List<Company> getCompanies() {
	// return companies;
	// }
	//
	// public void setCompanies(List<Company> companies) {
	// this.companies = companies;
	// }

	/**
	 * Gets the line progresses.
	 *
	 * @return the line progresses
	 */
	@JsonIgnore
	public List<LineProgress> getLineProgresses() {
		return lineProgresses;
	}

	/**
	 * Sets the line progresses.
	 *
	 * @param lineProgresses the new line progresses
	 */
	@JsonSetter
	public void setLineProgresses(List<LineProgress> lineProgresses) {
		this.lineProgresses = lineProgresses;
	}

	/**
	 * Gets the from users.
	 *
	 * @return the from users
	 */
	@JsonIgnore
	public List<UserToUserRequest> getFromUsers() {
		return fromUsers;
	}

	/**
	 * Sets the from users.
	 *
	 * @param fromUsers the new from users
	 */
	@JsonSetter
	public void setFromUsers(List<UserToUserRequest> fromUsers) {
		this.fromUsers = fromUsers;
	}

	/**
	 * Gets the to users.
	 *
	 * @return the to users
	 */
	@JsonIgnore
	public List<UserToUserRequest> getToUsers() {
		return toUsers;
	}

	/**
	 * Sets the to users.
	 *
	 * @param toUsers the new to users
	 */
	@JsonSetter
	public void setToUsers(List<UserToUserRequest> toUsers) {
		this.toUsers = toUsers;
	}

	//@Override
//	public String toString() {
//		return "UserInformation [idUser=" + idUser + ", accountName=" + accountName + ", status=" + status + ", email="
//				+ email + ", emailVerified=" + emailVerified + ", password=" + password + ", createdAt=" + createdAt
//				+ ", lastLogin=" + lastLogin + ", systemLanguage=" + systemLanguage + ", initialSetting="
//				+ initialSetting + ", authority=" + authority + ", userRole=" + userRole + ", lineProgresses="
//				+ lineProgresses + ", fromUsers=" + fromUsers + ", toUsers=" + toUsers + "]";
//	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	

}