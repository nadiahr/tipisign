package org.side.dao;

import java.io.Serializable;

import org.side.entites.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestRepository.
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Serializable> {
	
	/**
	 * Chercher.
	 *
	 * @param motcle the motcle
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query("select c from Request c where c.titleRequest like :x")
	public Page<Request> chercher(@Param("x") String motcle, Pageable pageable);

}
