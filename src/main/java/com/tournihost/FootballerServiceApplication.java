package com.tournihost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EntityScan(basePackages ="common.model")
public class FootballerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballerServiceApplication.class, args);
	}

}
