package org.side.entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Company.
 */
@Entity
public class Company implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id company. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompany;
	
	/** The name company. */
	private String nameCompany;
	
	/** The detail. */
	private String detail;
	
	/** The adress. */
	private String adress;

	// @ManyToMany
	// @JoinTable(name = "company_user")
	// private Collection<UserInformation> users;

	/**
	 * Instantiates a new company.
	 */
	public Company() {
		super();
	}

	/**
	 * Instantiates a new company.
	 *
	 * @param idCompany the id company
	 * @param nameCompany the name company
	 * @param detail the detail
	 */
	public Company(long idCompany, String nameCompany, String detail) {
		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
		this.detail = detail;
	}

	/**
	 * Gets the id company.
	 *
	 * @return the id company
	 */
	public long getIdCompany() {
		return idCompany;
	}

	/**
	 * Sets the id company.
	 *
	 * @param idCompany the new id company
	 */
	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}

	/**
	 * Gets the name company.
	 *
	 * @return the name company
	 */
	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * Sets the name company.
	 *
	 * @param nameCompany the new name company
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
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
	 * Gets the adress.
	 *
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Sets the adress.
	 *
	 * @param adress the new adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	// public Collection<UserInformation> getUsers() {
	// return users;
	// }
	//
	// public void setUsers(Collection<UserInformation> users) {
	// this.users = users;
	// }

}