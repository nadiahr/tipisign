package org.side.dao;

import java.io.Serializable;

import org.side.entites.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface UserRoleRepository.
 *
 * @author Nadia
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {

}
