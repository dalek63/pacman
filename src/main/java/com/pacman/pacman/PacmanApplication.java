package com.pacman.pacman;


import Classes.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling

public class PacmanApplication {
	public static void main(String[] args) {

		SpringApplication.run(PacmanApplication.class, args);



	}

}
