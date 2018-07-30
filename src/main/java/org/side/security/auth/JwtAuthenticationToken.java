package org.side.security.auth;

import java.util.Collection;


import org.side.security.model.UserContext;
import org.side.security.model.token.RawAccessJwtToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;




// TODO: Auto-generated Javadoc
/**
 * The Class JwtAuthenticationToken.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2877954820905567501L;

	/** The raw access token. */
	private RawAccessJwtToken rawAccessToken;
	
	/** The user context. */
	private UserContext userContext;

	/**
	 * Instantiates a new jwt authentication token.
	 *
	 * @param unsafeToken the unsafe token
	 */
	public JwtAuthenticationToken(RawAccessJwtToken unsafeToken) {
		super(null);
		this.rawAccessToken = unsafeToken;
		this.setAuthenticated(false);
	}

	/**
	 * Instantiates a new jwt authentication token.
	 *
	 * @param userContext the user context
	 * @param authorities the authorities
	 */
	public JwtAuthenticationToken(UserContext userContext, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.eraseCredentials();
		this.userContext = userContext;
		super.setAuthenticated(true);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AbstractAuthenticationToken#setAuthenticated(boolean)
	 */
	@Override
	public void setAuthenticated(boolean authenticated) {
		if (authenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return rawAccessToken;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return this.userContext;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AbstractAuthenticationToken#eraseCredentials()
	 */
	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		this.rawAccessToken = null;
	}

}
