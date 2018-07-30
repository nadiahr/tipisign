package org.side.dao;

import java.io.Serializable;

import org.side.entites.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface NotificationRepository.
 *
 * @author Nadia
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Serializable> {

}
