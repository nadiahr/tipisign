package org.side;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// TODO: Auto-generated Javadoc
/**
 * The Class TipiSignApplication.
 */
@ComponentScan(basePackages = { "org.side.common" })
@ComponentScan(basePackages = { "org.side.web" })
@ComponentScan(basePackages = { "org.side.security" })
@ComponentScan(basePackages = { "org.side.security.auth" })

@ComponentScan(basePackages = { "org.side.security.auth.ajax" })
@ComponentScan(basePackages = { "org.side.security.auth.jwt" })

@ComponentScan(basePackages = { "org.side.security.auth.jwt.extractor" })

@ComponentScan(basePackages = { "org.side.security.auth.jwt.verifier" })

@ComponentScan(basePackages = { "org.side.security.config" })

@ComponentScan(basePackages = { "org.side.security.endpoint" })
@ComponentScan(basePackages = { "org.side.security.exceptions" })
@ComponentScan(basePackages = { "org.side.security.model" })
@ComponentScan(basePackages = { "org.side.security.model.token" })
@ComponentScan(basePackages = { "org.side.userInformation.service" })
@EnableJpaRepositories(basePackages = { "org.side.dao" })
@EntityScan(basePackages = { "org.side.entites" })
@SpringBootApplication
@EnableConfigurationProperties
public class TipiSignApplication {
	// @Autowired
	// RequestRepository RequestReposotory;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("***************************************************************tessssssssssssssssss");
		SpringApplication.run(TipiSignApplication.class, args);
	}

}
