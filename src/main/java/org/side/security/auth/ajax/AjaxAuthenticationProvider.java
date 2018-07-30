package org.side.security.auth.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.side.entites.UserInformation;
import org.side.security.model.UserContext;
import org.side.userInformation.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

// TODO: Auto-generated Javadoc
/**
 * The Class AjaxAuthenticationProvider.
 *
 * @author nadia
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	/** The encoder. */
	private final BCryptPasswordEncoder encoder;
	
	/** The user service. */
	private final DatabaseUserService userService;

	/**
	 * Instantiates a new ajax authentication provider.
	 *
	 * @param userService the user service
	 * @param encoder the encoder
	 */
	@Autowired
	public AjaxAuthenticationProvider(final DatabaseUserService userService, final BCryptPasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.notNull(authentication, "No authentication data provided");

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		System.out.println("**************************" + username);
		System.out.println("**************************" + username);

		UserInformation user = userService.getByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
System.out.println("user"+user);
		if (!encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");

		}

		//if (user.getRoles() == null)
		//	throw new InsufficientAuthenticationException("User has no roles assigned");

//		List<GrantedAuthority> authorities = user.getRole().stream()
//				.map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
//				.collect(Collectors.toList());

		UserContext userContext = UserContext.create(user.getAccountName(), null);

		return new UsernamePasswordAuthenticationToken(userContext, null, null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
