package com.BackendTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.BackendTech"})
public class BackendTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTechApplication.class, args);
	}

}
