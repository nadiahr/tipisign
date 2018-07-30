package org.side.dao;

import java.io.Serializable;

import org.side.entites.LineProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface LineProgressRepository.
 */
@Repository
public interface LineProgressRepository extends JpaRepository<LineProgress, Serializable> {

}