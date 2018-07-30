package org.side.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.savedrequest.SavedRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class WebUtil.
 */
public class WebUtil {
	
	/** The Constant XML_HTTP_REQUEST. */
	private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	
	/** The Constant X_REQUESTED_WITH. */
	private static final String X_REQUESTED_WITH = "X-Requested-With";

	/** The Constant CONTENT_TYPE. */
	private static final String CONTENT_TYPE = "Content-type";
	
	/** The Constant CONTENT_TYPE_JSON. */
	private static final String CONTENT_TYPE_JSON = "application/json";

	/**
	 * Checks if is ajax.
	 *
	 * @param request the request
	 * @return true, if is ajax
	 */
	public static boolean isAjax(HttpServletRequest request) {
		return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
	}

	/**
	 * Checks if is ajax.
	 *
	 * @param request the request
	 * @return true, if is ajax
	 */
	public static boolean isAjax(SavedRequest request) {
		return request.getHeaderValues(X_REQUESTED_WITH).contains(XML_HTTP_REQUEST);
	}

	/**
	 * Checks if is content type json.
	 *
	 * @param request the request
	 * @return true, if is content type json
	 */
	public static boolean isContentTypeJson(SavedRequest request) {
		return request.getHeaderValues(CONTENT_TYPE).contains(CONTENT_TYPE_JSON);
	}

}
