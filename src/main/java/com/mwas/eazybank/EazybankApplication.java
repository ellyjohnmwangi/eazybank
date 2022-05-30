package com.mwas.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.mwas.controllers"), @ComponentScan("com.mwas.config")})
public class EazybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazybankApplication.class, args);
	}

}
