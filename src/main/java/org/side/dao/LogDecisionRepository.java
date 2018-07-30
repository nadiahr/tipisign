package org.side.dao;

import java.io.Serializable;

import org.side.entites.LogDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface LogDecisionRepository.
 */
@Repository
public interface LogDecisionRepository extends JpaRepository<LogDecision, Serializable> {

}
