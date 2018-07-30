package org.side;

import java.util.Arrays;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomCorsFilter.
 *
 * @author nadia
 */
public class CustomCorsFilter extends CorsFilter {

	/**
	 * Instantiates a new custom cors filter.
	 */
	public CustomCorsFilter() {
		super(configurationSource());
	}

	/**
	 * Configuration source.
	 *
	 * @return the url based cors configuration source
	 */
	private static UrlBasedCorsConfigurationSource configurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		//HttpServletResponse res = null;
		//HttpServletResponse response = (HttpServletResponse) res;
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		//response.setHeader("Access-Control-Allow-Origin", "http://tipisign.com");
		config.setMaxAge(36000L);
		config.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		// source.registerCorsConfiguration("/api/**", config);
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}