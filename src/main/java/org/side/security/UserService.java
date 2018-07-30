package org.side.security;

import java.util.Optional;

import org.side.entites.UserInformation;

public interface UserService {
	public Optional<UserInformation> getByUsername(String username);

}
