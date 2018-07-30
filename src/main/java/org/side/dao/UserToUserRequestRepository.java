package org.side.dao;

import java.io.Serializable;
import java.util.List;

import org.side.entites.Request;
import org.side.entites.UserToUserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserToUserRequestRepository.
 */
@Repository
public interface UserToUserRequestRepository extends JpaRepository<UserToUserRequest, Serializable> {
	
	/**
	 * Request approved.
	 *
	 * @param idUser the id user
	 * @return the list
	 */
	@Query("select c from UserToUserRequest c where c.userFrom.idUser = :x and c.request.status='approved'")
    public List<UserToUserRequest> requestApproved(@Param("x") String idUser);
    
    /**
     * Request disapproved.
     *
     * @param idUser the id user
     * @return the list
     */
    @Query("select c from UserToUserRequest c where c.userFrom.idUser = :x and c.request.status='disapproved'")
    public List<UserToUserRequest> requestDisapproved(@Param("x") String idUser);
    
    /**
     * Request pending.
     *
     * @param idUser the id user
     * @return the list
     */
    @Query("select c from UserToUserRequest c where c.userFrom.idUser = :x and c.request.status='pending'")
    public List<UserToUserRequest> requestPending(@Param("x") String idUser);
    
    /**
     * Chercher disavpoved.
     *
     * @param idUser the id user
     * @param pageable the pageable
     * @return the page
     */
    @Query("select c from UserToUserRequest c where c.userFrom.idUser = :x and c.request.status='disapproved'")
    public Page<UserToUserRequest> chercherDisavpoved(@Param("x") String idUser ,Pageable pageable);

	/**
	 * Find pending request by to user.
	 *
	 * @param idUser the id user
	 * @return the list
	 */
	@Query("select c from UserToUserRequest c where c.userTo.idUser = :x and (c.request.status='pending' or c.request.status='passed')")
	public List<UserToUserRequest> findPendingRequestByToUser(@Param("x") String idUser);

	/**
	 * Find my requests.
	 *
	 * @param idUser the id user
	 * @return the list
	 */
	@Query("select c from UserToUserRequest c where c.userFrom.idUser =:x and (c.request.status='approved' or c.request.status='disapproved')")
	public List<UserToUserRequest> findMyRequests(@Param("x") String idUser);

	/**
	 * Find request.
	 *
	 * @param idRequest the id request
	 * @return the user to user request
	 */
	@Query("select c from UserToUserRequest c where c.request.idRequest =:x ")
	public UserToUserRequest findRequest(@Param("x") long idRequest);
	
	/**
	 * Find requestby user.
	 *
	 * @param motcle the motcle
	 * @param status the status
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from UserToUserRequest c where c.userFrom.idUser =:x and c.request.status =:y order By c.request.updatedAt desc")
	public Page<UserToUserRequest> findRequestbyUser(@Param("x") String  motcle ,@Param("y") String status , Pageable pageable);
	
	/**
	 * Chercher.
	 *
	 * @param motcle the motcle
	 * @param userId the user id
	 * @param userToId the user to id
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from UserToUserRequest c where c.request.visibility >= :x or c.userFrom.idUser = :y or c.userTo.idUser = :z order By c.request.createdAt desc")
	public Page<UserToUserRequest> chercher(@Param("x")  long motcle, @Param("y") String userId , @Param("z") String userToId  ,Pageable pageable);
	
	/**
	 * Find all requestby user.
	 *
	 * @param motcle the motcle
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from UserToUserRequest c where c.userFrom.idUser =:x  order By c.request.createdAt desc")
	public Page<UserToUserRequest> findAllRequestbyUser(@Param("x") String  motcle  , Pageable pageable);
	


}
