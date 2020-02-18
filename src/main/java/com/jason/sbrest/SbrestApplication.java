package com.jason.sbrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jason.sbrest")
public class SbrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbrestApplication.class, args);
	}

}
