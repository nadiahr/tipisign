package org.side.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.side.controller.TipiSignUserInfo;
import org.side.dao.UserInformationRepository;
import org.side.entites.UserInformation;
import org.side.mail.EmailHtmlSender;
import org.side.security.UserService;
import org.side.security.auth.JwtAuthenticationToken;
import org.side.security.auth.jwt.extractor.TokenExtractor;
import org.side.security.auth.jwt.verifier.TokenVerifier;
import org.side.security.config.JwtSettings;
import org.side.security.config.WebSecurityConfig;
import org.side.security.excepctions.EmailExistsException;
import org.side.security.excepctions.InvalidJwtToken;
import org.side.security.model.UserContext;
import org.side.security.model.token.JwtToken;
import org.side.security.model.token.JwtTokenFactory;
import org.side.security.model.token.RawAccessJwtToken;
import org.side.security.model.token.RefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInformationService.
 */
@RestController

@CrossOrigin(origins = "**")
public class UserInformationService {

	/** The token factory. */
	@Autowired
	private JwtTokenFactory tokenFactory;

	/** The jwt settings. */
	@Autowired
	private JwtSettings jwtSettings;

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The token verifier. */
	@Autowired
	private TokenVerifier tokenVerifier;

	/** The token extractor. */
	@Autowired
	@Qualifier("jwtHeaderTokenExtractor")
	private TokenExtractor tokenExtractor;
	
	/** The user information repository. */
	@Autowired
	private UserInformationRepository userInformationRepository;
	
	/** The tipi sign user info. */
	@Autowired
	TipiSignUserInfo tipiSignUserInfo;
	
	/** The email html sender. */
	@Autowired
	EmailHtmlSender emailHtmlSender;

	/**
	 * Save.
	 *
	 * @param u the u
	 * @return the user information
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws MessagingException the messaging exception
	 * @throws EmailExistsException the email exists exception
	 */
	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	public UserInformation save(@RequestBody UserInformation u)
			throws UnsupportedEncodingException, MessagingException, EmailExistsException {
		return tipiSignUserInfo.saveUserInformation(u);
	}

	/**
	 * List user information.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public List<UserInformation> listUserInformation() {
		return userInformationRepository.findAll();
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserInformation getUser(@PathVariable String id) {
		return userInformationRepository.findOne(id);
	}
	
	/**
	 * Find user by account.
	 *
	 * @param accountName the account name
	 * @return the user information
	 */
	@RequestMapping(value = "/getName/{accountName}", method = RequestMethod.GET)
	public UserInformation findUserByAccount(@PathVariable String accountName) {
		return userInformationRepository.findUserByAccount( accountName );
	}

	/**
	 * Find user by name.
	 *
	 * @param accountName the account name
	 * @param numPage the num page
	 * @param size the size
	 * @return the page
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Page<UserInformation> findUserByName(@RequestParam(name = "accountName") String accountName,
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return userInformationRepository.findUserByName("%" + accountName + "%", new PageRequest(numPage, size));
	}

	/**
	 * Gets the.
	 *
	 * @param token the token
	 * @return the user context
	 */
	@RequestMapping(value = "/api/me", method = RequestMethod.GET)
	public @ResponseBody UserContext get(JwtAuthenticationToken token) {
		return (UserContext) token.getPrincipal();
	}

	/**
	 * Refresh token.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the jwt token
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@RequestMapping(value = "/api/auth/token", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.AUTHENTICATION_HEADER_NAME));

		RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
		RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey())
				.orElseThrow(() -> new InvalidJwtToken());

		String jti = refreshToken.getJti();
		if (!tokenVerifier.verify(jti)) {
			throw new InvalidJwtToken();
		}

		String subject = refreshToken.getSubject();
		UserInformation user = userService.getByUsername(subject)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

		// if (user.getRoles() == null)
		// throw new InsufficientAuthenticationException("User has no roles assigned");
		// List<GrantedAuthority> authorities = user.getRoles().stream()
		// .map(authority -> new
		// SimpleGrantedAuthority(authority.getRole().authority()))
		// .collect(Collectors.toList());

		UserContext userContext = UserContext.create(user.getAccountName(), null);

		return tokenFactory.createAccessJwtToken(userContext);
	}
	
	
	

		/**
		 * Copyright (c) 2018 by HRDatabank. All rights reserved.
		 *
		 * @author yassine amira
		 * 
		 *         Using JRE: 1.8
		 * 
		 *         Project Name: Module-Web-Admin
		 * 
		 *         Class Name: HomeController.java
		 * 
		 *         Home.
		 * @param request
		 *            the request
		 * @return the string
		 */
		@RequestMapping({  "/login" , "/request" , "/profile" })
				public String home(HttpServletRequest request) {
			System.out.println("------------------------------" + request.getRequestURI());
			

				return "index.html";
			}
		
		/**
		 * Save.
		 *
		 * @param id the id
		 * @param c the c
		 * @return the user information
		 */
		@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
		public UserInformation save(@PathVariable String id, @RequestBody UserInformation c) {
			c.getAuthority();
		
			return userInformationRepository.save(c);

		}
		
}

