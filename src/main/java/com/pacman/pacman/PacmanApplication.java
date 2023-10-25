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

		Terrain t = new Terrain(10,10);
		Point point = new Point(0,5);
		Point point2 = new Point(3,7);
		Point point3 = new Point(5,8);
		PacMan p = new PacMan(point, Direction.DROITE, 3, 3, "ROUGE");
		Fantome f1 = new Fantome(point2, Direction.GAUCHE, ModeFantome.EFFRAYE);
		Fantome f2 = new Fantome(point3, Direction.HAUT, ModeFantome.EFFRAYE);

		List<Fantome> fantomes = new ArrayList<Fantome>();

		Jeu j = new Jeu(t, p, fantomes);

		j.demarrerJeu();

	/*
		String[][] tableau2D = new String[11][11];
		int x;

		for (int i = 0; i < tableau2D.length; i++) {
			for (int j = 0; j < tableau2D.length; j++) {
				tableau2D[i][j]= "X";
			}
		}

		tableau2D[0][4]="P";

		while (true) {
			x = 0;
			for (int i = 0; i < tableau2D.length; i++) {
				for (int j = 0; j < tableau2D.length; j++) {
					System.out.print(tableau2D[i][j]+ "    ");

				}
				System.out.println();

			}

			System.out.println("-------------------------------------------------------------------");

			for (int i = 0; i < tableau2D.length; i++) {
				for (int j = 0; j < tableau2D.length; j++) {
					if(tableau2D[i][j]=="P"){
						x = x +1;
						if(x==1){
							if(j == tableau2D.length-1) {
								tableau2D[i][j] = "X";
								tableau2D[i+1][0] = "P";
							}
							else{
								tableau2D[i][j] = "X";
								tableau2D[i][j+1] = "P";
							}
						}
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

	*/
	}

}
