package com.example.IlOrn;

import com.example.IlOrn.modal.Il;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.IlOrn" )
@ComponentScan(basePackages = "com.example.IlOrn")
public class IlOrnApplication {

	public static void main(String[] args) {
		SpringApplication.run(IlOrnApplication.class, args);
	}

}
