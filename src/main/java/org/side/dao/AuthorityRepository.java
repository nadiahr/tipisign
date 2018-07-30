package org.side.dao;

import java.io.Serializable;

import org.side.entites.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface AuthorityRepository.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Serializable> {

}
