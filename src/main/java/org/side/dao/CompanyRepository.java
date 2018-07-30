package org.side.dao;

import java.io.Serializable;

import org.side.entites.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface CompanyRepository.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Serializable> {

}
