package org.side.userInformation.service;

import java.util.Optional;

import org.side.dao.UserInformationRepository;
import org.side.entites.UserInformation;
import org.side.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseUserService.
 */
@Service
public class DatabaseUserService implements UserService {
	
	/** The user information repository. */
	private final UserInformationRepository userInformationRepository;

	/**
	 * Instantiates a new database user service.
	 *
	 * @param userInformationRepository the user information repository
	 */
	@Autowired
	public DatabaseUserService(UserInformationRepository userInformationRepository) {
		this.userInformationRepository = userInformationRepository;
	}

	/**
	 * Gets the user repository.
	 *
	 * @return the user repository
	 */
	public UserInformationRepository getUserRepository() {
		return userInformationRepository;
	}

	/* (non-Javadoc)
	 * @see org.side.security.UserService#getByUsername(java.lang.String)
	 */
	@Override
	public Optional<UserInformation> getByUsername(String username) {
		// TODO Auto-generated method stub
		return userInformationRepository.findByUsername(username);
	}
	

}