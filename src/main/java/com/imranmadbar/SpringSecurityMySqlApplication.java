package com.imranmadbar;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class SpringSecurityMySqlApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(SpringSecurityMySqlApplication.class, args);
		System.out.println("Spring Security MySQL MVC Application Run Successfully Done !");
	}

}
