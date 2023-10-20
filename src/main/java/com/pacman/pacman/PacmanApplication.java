package com.pacman.pacman;

import Services.Boucle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PacmanApplication {

	public static void main(String[] args) {

		SpringApplication.run(PacmanApplication.class, args);


		String[][] tableau2D = new String[11][11];

		for (int i = 0; i < tableau2D.length; i++) {
			for (int j = 0; j < tableau2D.length; j++) {
				tableau2D[i][j]= "X";
			}
		}

		tableau2D[0][4]="P";

		while (true) {

			for (int i = 0; i < tableau2D.length; i++) {
				for (int j = 0; j < tableau2D.length; j++) {
					System.out.print(tableau2D[i][j]+ "    ");

				}
				System.out.println();

			}

			System.out.println("-------------------------------------------------------------------");

			for (int i = 0; i < tableau2D.length; i++) {
				for (int j = 0; j < tableau2D.length; j++) {
					if(tableau2D[i][j]="P"){

					}

				}
				System.out.println();

			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
