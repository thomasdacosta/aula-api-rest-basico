package edu.senac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SenacApiRestBasicoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SenacApiRestBasicoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SenacApiRestBasicoApplication.class, args);
	}

}
