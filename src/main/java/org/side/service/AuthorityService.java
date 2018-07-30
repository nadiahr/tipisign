package org.side.service;

import java.util.List;

import org.side.dao.AuthorityRepository;
import org.side.entites.Authority;
import org.side.entites.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityService.
 */
@RestController
@CrossOrigin(origins = "**")
public class AuthorityService {
	
	/** The authority repository. */
	@Autowired
	private AuthorityRepository authorityRepository;

	/**
	 * Save user role.
	 *
	 * @param a the a
	 * @return the authority
	 */
	@RequestMapping(value = "/Authority", method = RequestMethod.POST)
	public Authority saveUserRole(@RequestBody Authority a) {
		return authorityRepository.save(a);
	}

	/**
	 * List user role.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getAuthority", method = RequestMethod.GET)
	public List<Authority> listUserRole() {
		return authorityRepository.findAll();
	}

	/**
	 * Find all authority.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<Authority> findAllAuthority(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return authorityRepository.findAll(new PageRequest(num, size));
	}
	
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(value = "/authority/{id}", method = RequestMethod.GET)
	public Authority   getUser(@PathVariable long id) {
		return authorityRepository.findOne(id);
	}

}