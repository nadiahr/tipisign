package org.side.service;

import java.util.List;

import org.side.dao.CommentRepository;
import org.side.entites.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentService.
 */
@RestController
@CrossOrigin(origins = "**")
public class CommentService {
	
	/** The comment repository. */
	@Autowired
	private CommentRepository commentRepository;

	/**
	 * Save comments.
	 *
	 * @param co the co
	 * @return the comment
	 */
	@RequestMapping(value = "/Comments", method = RequestMethod.POST)
	public Comment saveComments(@RequestBody Comment co) {
		return commentRepository.save(co);
	}

	/**
	 * List comments.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getComments", method = RequestMethod.GET)
	public List<Comment> listComments() {
		return commentRepository.findAll();
	}

}