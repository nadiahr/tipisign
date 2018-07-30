package org.side.security.auth.ajax;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.side.common.WebUtil;
import org.side.security.excepctions.AuthMethodNotSupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * AjaxLoginProcessingFilter.
 *
 * @author nadia
 */
public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(AjaxLoginProcessingFilter.class);

	/** The success handler. */
	private final AuthenticationSuccessHandler successHandler;
	
	/** The failure handler. */
	private final AuthenticationFailureHandler failureHandler;

	/** The object mapper. */
	private final ObjectMapper objectMapper;

	/**
	 * Instantiates a new ajax login processing filter.
	 *
	 * @param defaultProcessUrl the default process url
	 * @param successHandler the success handler
	 * @param failureHandler the failure handler
	 * @param mapper the mapper
	 */
	public AjaxLoginProcessingFilter(String defaultProcessUrl, AuthenticationSuccessHandler successHandler,
			AuthenticationFailureHandler failureHandler, ObjectMapper mapper) {
		super(defaultProcessUrl);
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
		this.objectMapper = mapper;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		logger.debug("***********************************0********d. Request method: " + request.getMethod());
		logger.debug("*********************************************2. Request method: " + !WebUtil.isAjax(request));

		System.out.println("***********************************0********d. Request method: " + request.getMethod());
		System.out.println("***********************************0********d. Request method:************************ "
				+ !WebUtil.isAjax(request));

		if (!HttpMethod.POST.name().equals(request.getMethod()) || !WebUtil.isAjax(request)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Authentication method not supported. Request method: " + request.getMethod());
			}
			throw new AuthMethodNotSupportedException("Authentication ***method not supported");
		}
	
		System.out.println("***********************************0*******method suported:************************ ");

		LoginRequest loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);

		System.out.println("***************************username************************ " + loginRequest.getUsername());
		System.out.println("***************************password************************ " + loginRequest.getPassword());

		if (StringUtils.isBlank(loginRequest.getUsername()) || StringUtils.isBlank(loginRequest.getPassword())) {
			System.out.println("******************ssssssssssssssssss************* ");
			throw new AuthenticationServiceException("Username or Password not provided");

		}
		
		System.out.println("******************khbkbnkbnklj************* ");
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
				loginRequest.getPassword());
	
		
		return this.getAuthenticationManager().authenticate(token);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		successHandler.onAuthenticationSuccess(request, response, authResult);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#unsuccessfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
	
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}
}
