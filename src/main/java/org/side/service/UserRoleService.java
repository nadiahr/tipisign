package org.side.service;

import java.util.List;

import org.side.dao.UserRoleRepository;
import org.side.entites.Authority;
import org.side.entites.UserRole;
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
 * The Class UserRoleService.
 */
@RestController
@CrossOrigin(origins = "**")
public class UserRoleService {

	/** The user role repository. */
	@Autowired
	private UserRoleRepository userRoleRepository;

	/**
	 * Save user role.
	 *
	 * @param a the a
	 * @return the user role
	 */
	@RequestMapping(value = "/UserRole", method = RequestMethod.POST)
	public UserRole saveUserRole(@RequestBody UserRole a) {
		return userRoleRepository.save(a);
	}
	
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(value = "/UserRole/{id}", method = RequestMethod.GET)
	public UserRole   getUser(@PathVariable long id) {
		return userRoleRepository.findOne(id);
	}
	

	/**
	 * List user role.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getUserRole", method = RequestMethod.GET)
	public List<UserRole> listUserRole() {
		return userRoleRepository.findAll();
	}

	/**
	 * Find all user role.
	 *
	 * @param num the num
	 * @param size the size
	 * @return the page
	 */
	public Page<UserRole> findAllUserRole(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return userRoleRepository.findAll(new PageRequest(num, size));
	}

}
