package org.side.dao;

import org.side.entites.LogRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface LogRequestRepository.
 */
@Repository
public interface LogRequestRepository extends JpaRepository<LogRequest, Integer> {
	
	/**
	 * Find request.
	 *
	 * @param motcle the motcle
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from LogRequest c where c.idRequest  =:x")
	public Page<LogRequest> findRequest(@Param("x") long motcle , Pageable pageable);
	
	

}
