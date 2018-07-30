package org.side.dao;

import java.io.Serializable;
import java.util.Optional;

import org.side.entites.UserInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInformationRepository.
 */
@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Serializable> {
	
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user information
	 */
	UserInformation findByEmail(String email);

	/**
	 * Check login.
	 *
	 * @param accountName the account name
	 * @param password the password
	 * @return the user information
	 */
	@Query("select c from UserInformation c where c.accountName = :x and c.password = :y")
	public UserInformation checkLogin(@Param("x") String accountName, @Param("y") String password);

	
	/**
	 * Find user by name.
	 *
	 * @param userName the user name
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from UserInformation c where c.accountName like :x and  (c.status='actif' or c.status=null)")
	public Page<UserInformation> findUserByName(@Param("x") String userName, Pageable pageable);
	
	/**
	 * Find user by account name.
	 *
	 * @param userName the user name
	 * @return the user information
	 */
	@Query("select c from UserInformation c where c.accountName like :x")
	public UserInformation findUserByAccountName(@Param("x") String userName);
	
	/**
	 * Find user by account.
	 *
	 * @param userName the user name
	 * @return the user information
	 */
	@Query("select c from UserInformation c where c.accountName  =:x")
	public UserInformation findUserByAccount(@Param("x") String userName);
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	@Query("select u from UserInformation u   where u.accountName=:username")
	public Optional<UserInformation> findByUsername(@Param("username") String username);
	
	
}
