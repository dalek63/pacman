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

		Terrain t = new Terrain();
		Point point = new Point(0,5);
		Point point2 = new Point(3,7);
		Point point3 = new Point(5,8);
		PacMan p = new PacMan(point, Direction.DROITE, 3, 3, "ROUGE");
		Fantome f1 = new Fantome(point2, Direction.GAUCHE, ModeFantome.EFFRAYE);
		Fantome f2 = new Fantome(point3, Direction.HAUT, ModeFantome.EFFRAYE);

		List<Fantome> fantomes = new ArrayList<Fantome>();

		Jeu j = new Jeu(t, p, fantomes);

		j.demarrerJeu();

	}

}
