package com.example.spring_board_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoardStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoardStudyApplication.class, args);
	}

}
