package com.nrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class BasicErpApplication {
	private static final Logger log = LoggerFactory.getLogger(BasicErpApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BasicErpApplication.class, args);
		log.info("SuccessFully  Start Application ...... ");

	}

}
