package Classes;

import javax.swing.text.Position;
import java.util.Random;

public class PacMan extends Personnage {
    private int vies;
    private int vitesse;
    private String couleur;

    private Game game;

    public PacMan(Point position, Game game) {
        super(position);
        this.vies = 3;
        this.game = game;
    }

    public PacMan(Point position, int vies, int vitesse) {
        super(position);
        this.vies = vies;
        this.vitesse = vitesse;
    }

    public int getVies() {
        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }
    public void perdreVies() {
        vies--;

        if (vies <= 0) {
            // GAME OVER
            System.out.println("Game Over");
            this.game.gameOver(); // fin du jeu
        } else {
            System.out.println("Pacman a perdu une vie. Vies restantes : " + vies);
            this.game.gestionCollision();
        }
    }

    public boolean estVivant() {
        return vies > 0;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public void mangerBoule() {
        this.game.setScore(25);
    }
    public void mangerSuperBoule() {
        this.game.setScore(50);
    }
    private Fruit trouverFruit(int x, int y) {
        for (Fruit fruit : this.game.fruits) {
            if (fruit.getPosition().getPositionX() == x && fruit.getPosition().getPositionY() == y) {
                return fruit;
            }
        }
        return null;
    }
    public void mangerFruit(Fruit fruit) {
        if (fruit != null) {
            this.game.setScore(fruit.getPointsFruit());

        }
    }


    public void deplacer(char[][] terrain, int direction) {

        //Position actuel du Pacman
        Point position = getPosition();
        int positionX = position.getPositionX();
        int positionY = position.getPositionY();

        int anciennePositionX = positionX;
        int anciennePositionY = positionY;

        System.out.println("Postion Pacman "+ position.getPositionX() +" "+position.getPositionY());

        if (terrain[positionX][positionY] == 'F') {
            // Collision avec un fantôme, perdre une vie
            System.out.println("Collision avec un Fantome");
            perdreVies();
        }
//        System.out.println("peutSeDeplacer: "+peutSeDeplacer(terrain, direction, positionX, positionY));
        if (peutSeDeplacer(terrain, direction, positionX, positionY)){
            // Déplacer le Pacman dans la direction choisie
            switch (direction) {
                case 0:
                    // Déplacer vers le haut
                    System.out.println("Pacman Vers le haut");
                    position.setPositionX(position.getPositionX() - 1);
                    break;
                case 1:
                    // Déplacer vers la droite
                    System.out.println("Pacman vers la droite");
                    position.setPositionY(position.getPositionY() + 1);
                    break;
                case 2:
                    // Déplacer vers le bas
                    System.out.println("Pacman vers le bas");
                    position.setPositionX(position.getPositionX() + 1);
                    break;
                case 3:
                    // Déplacer vers la gauche
                    System.out.println("Pacman vers la gauche");
                    position.setPositionY(position.getPositionY() - 1);
                    break;
            }
            System.out.println("MAJ POSITION");
            // Mettre à jour la grille avec la nouvelle position du pacman
            this.game.getTerrain()[anciennePositionX][anciennePositionY] = '.'; // Ancienne position vide
            this.game.getTerrain()[position.getPositionX()][position.getPositionY()] = 'P'; // Nouvelle position avec le Pacman

            System.out.println("Postion Pacman après maj "+ position.getPositionX() +" "+ position.getPositionY());
        }

        this.game.verifierEtMettreAJourNiveau();
    }

    private boolean peutSeDeplacer(char[][] terrain, int direction, int positionX, int positionY) {
        // Nouvelles coordonnées après le déplacement
        int newX = positionX;
        int newY = positionY;
        System.out.println("POSITION X "+positionX+" POSITION Y "+ positionY);

        switch (direction) {
            case 0:
                newX--; // Déplacement vers le haut
                break;
            case 1:
                newY++; // Déplacement vers la droite
                break;
            case 2:
                newX++; // Déplacement vers le bas
                break;
            case 3:
                newY--; // Déplacement vers la gauche
                break;
            default:
                System.out.println("Direction non Valide "+direction);
                return false; // Direction non valide
        }

        // Vérifier les limites de la grille
        if (newX < 0 || newX >= terrain.length || newY < 0 || newY >= terrain[0].length) {
            System.out.println("Pacman Limite de grille " + direction+" "+"NextX: "+newX+" NextY "+newY);
            System.out.println("Taille Tab X "+terrain[0].length+" "+"Taille Tab Y "+terrain.length);
            return false; // En dehors de la grille
        }


        // Vérifier s'il y a un mur à la nouvelle position
        if (terrain[newX][newY] == 'M') {
            System.out.println("PacMan collision avec un Mur");
            return false; // Mur présent
        }
        if (terrain[newX][newY] == 'F') {
            // Collision avec un fantôme, perdre une vie
            System.out.println("PacMan collision avec un Fantome");
            this.game.getPacMan().perdreVies();
            return false;
        }

        // Vérifier s'il y a une boule ou une super boule à la nouvelle position
        if (terrain[newX][newY] == 'o') {
            this.game.getPacMan().mangerBoule();
            this.game.getTerrain()[newX][newY] = '.';
            System.out.println("PacMan Boule: + 25 points");

            return true;
        }

        if (terrain[newX][newY] == 'O') {
            // Manger la super boule, augmenter le score de 50 points
            this.game.getPacMan().mangerSuperBoule();
            this.game.getTerrain()[newX][newY] = '.';
            System.out.println("PacMan SuperBoule: + 50 points");


            return true;
        }
        if (terrain[newX][newY] == 'C' || terrain[newX][newY] == 'B' || terrain[newX][newY] == 'K') {
            Fruit fruit = trouverFruit(newX, newY);
            if (fruit != null) {
                this.game.getPacMan().mangerFruit(fruit);
                this.game.getTerrain()[newX][newY] = '.';
                System.out.println("Fruit mangé : + " + fruit.getPointsFruit() + " points");

            }
            return true;
        }

            return true; // Déplacement autorisé
    }

    @Override
    public void mourir() {
    }
}
