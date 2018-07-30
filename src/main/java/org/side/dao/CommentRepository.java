package org.side.dao;

import java.io.Serializable;

import org.side.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface CommentRepository.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Serializable> {

}
