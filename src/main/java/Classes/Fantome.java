package Classes;

import java.util.Random;

public class Fantome extends Personnage {
    private ModeFantome mode;

    private Game game;

    private char caseEcrasee;


    public Fantome(Point position, Game game) {
        super(position);
        this.game = game;
    }

    public Fantome(Point position, Direction direction, ModeFantome mode) {
        super(position, direction);
        this.mode = mode;
    }

    public void deplacer(char[][] terrain) {
        Random random = new Random();
        int direction;

        Point position = getPosition();
        int positionX = position.getPositionX();
        int positionY = position.getPositionY();
        int directionSave = 5;
        int anciennePositionX = positionX;
        int anciennePositionY = positionY;
        char ancienContenu = this.game.getTerrain()[anciennePositionX][anciennePositionY];

        System.out.println("Postion Fantome "+ position.getPositionX() +" "+position.getPositionY());

//         Choisir une direction aléatoire (0 pour haut, 1 pour droite, 2 pour bas, 3 pour gauche)
        do {

            direction = random.nextInt(4);
             directionSave = direction;
            System.out.println("Direction aléatoirement choisi: "+direction);
        } while (!peutSeDeplacer(terrain, direction, positionX, positionY));

//            direction = random.nextInt(4);
//            System.out.println("Direction aléatoirement choisi: "+direction);
//            if(!peutSeDeplacer(terrain, direction, positionX, positionY)){

//        if (this.game.modeSansMurIsActive()) {
//            direction = (random.nextBoolean()) ? 0 : 2; // Choisir aléatoirement entre haut (0) et bas (2)
//        } else {
//            // Choisir une direction aléatoire (0 pour haut, 1 pour droite, 2 pour bas, 3 pour gauche)
//            do {
//                direction = random.nextInt(4);
//                System.out.println("doWHile et direction: " + direction);
//            } while (!peutSeDeplacer(terrain, direction, positionX, positionY));
//        }

        // Déplacer le fantôme dans la direction choisie
        switch (direction) {
            case 0:
                // Déplacer vers le haut
                System.out.println("Fantome: Déplacement autorisé Vers le haut");
                position.setPositionX(position.getPositionX() - 1);
                break;
            case 1:
                // Déplacer vers la droite
                System.out.println("Fantome: Déplacement autorisé vers la droite");
                position.setPositionY(position.getPositionY() + 1);
                break;
            case 2:
                // Déplacer vers le bas
                System.out.println("Fantome: Déplacement autorisé vers le bas");
                position.setPositionX(position.getPositionX() + 1);
                break;
            case 3:
                // Déplacer vers la gauche
                System.out.println("Fantome: Déplacement autorisé vers la gauche");
                position.setPositionY(position.getPositionY() - 1);
                break;
        }


/*
        char nouveauContenu = terrain[position.getPositionX()][position.getPositionY()];
        if (estUnBonus(nouveauContenu)) {
            caseEcrasee = nouveauContenu;
        } else {
            caseEcrasee = '.'; // Si la nouvelle position n'est pas un bonus, réinitialisez caseEcrasee
        }
*/
        this.game.getTerrain()[anciennePositionX][anciennePositionY] = '.';
        this.game.getTerrain()[position.getPositionX()][position.getPositionY()] = 'F'; // Nouvelle position avec le fantôme
//        this.game.getTerrain()[anciennePositionX][anciennePositionY] = ancienContenu;   // Restaurer le bonus à l'ancienne position du fantôme

        System.out.println("Postion Fantome après maj "+ position.getPositionX() +" "+ position.getPositionY());

    }

    private boolean peutSeDeplacer(char[][] terrain, int direction, int positionX, int positionY) {
        // Nouvelles coordonnées après le déplacement
        int newX = positionX;
        int newY = positionY;

        switch (direction) {
            case 0:
                newX--; // Déplacement vers le haut
                System.out.println("Fantome Vers le haut");
                break;
            case 1:
                newY++; // Déplacement vers la droite
                System.out.println("Fantome Vers le droite");
                break;
            case 2:
                newX++; // Déplacement vers le bas
                System.out.println("Fantome Vers le bas");
                break;
            case 3:
                newY--; // Déplacement vers la gauche
                System.out.println("Fantome Vers le gauche");
                break;
            default:
                return false; // Direction non valide
        }

        // Vérifier les limites de la grille
        if (newX < 0 || newX >= this.game.getTerrain().length || newY < 0 || newY >= this.game.getTerrain()[0].length) {
            System.out.println("Fantome a atteint la limite de grille " + direction);
            System.out.println("Valeur de NewX = "+newX);
            System.out.println("TabX valeur = "+this.game.getTerrain()[0].length);
            System.out.println("Valeur de NewY = "+newY);
            System.out.println("TabY valeur = "+this.game.getTerrain().length);

            return false; // En dehors de la grille
        }

        // Vérifier s'il y a un mur à la nouvelle position
        if (this.game.getTerrain()[newX][newY] == 'M') {
            System.out.println("Collision Fantome avec un MUR");
            return false; // Mur présent
        }

        if (this.game.getTerrain()[newX][newY] == 'P') {
            // Collision avec un fantôme, perdre une vie
            System.out.println("Collision avec un Pacman");
            this.game.getPacMan().perdreVies();
            return true;
        }
/*
        if(estUnBonus(this.game.getTerrain()[newX][newY])){
            caseEcrasee = this.game.getTerrain()[newX][newY];
            System.out.println("Case écraser "+ caseEcrasee );
        }
*/

        return true; // Déplacement autorisé
    }

/*

    private boolean estUnBonus(char contenu) {
        return contenu == 'o' || contenu == 'O' || contenu == 'B' || contenu == 'C' || contenu == 'K';
    }
    */

    public ModeFantome getMode() {
        return mode;
    }

    public void setMode(ModeFantome mode) {
        this.mode = mode;
    }

    public void disperser() {
        // Comportement de dispersion du fant
    }

    public void poursuivre() {
        // Comportement de poursuite du fant
    }

    public void effrayer() {
        // Comportement de devenir effrayé en mangeant un super-point
    }

    public void manger() {
        // Comportement de devenir mangé par Pac-Man
    }


    public void deplacer() {
    }

    @Override
    public void mourir() {

    }
}
