package com.szqy08;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szqy08.dao")
public class Szqy08NumOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(Szqy08NumOneApplication.class, args);
	}

}
