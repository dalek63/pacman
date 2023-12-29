package Classes;
import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jeu {
    private Terrain terrain;
    private PacMan pacMan;
    private List<Fantome> fantomes;
    private int score;

    public Jeu(Terrain terrain, PacMan pacMan, List<Fantome> fantomes) {
        this.terrain = terrain;
        this.pacMan = pacMan;
        this.fantomes = fantomes;
        this.score = 0;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public List<Fantome> getFantomes() {
        return fantomes;
    }


    List<Boule> boules = new ArrayList<>();
    List<SuperBoule> superBoules = new ArrayList<>();

    List<Fruit> fruits = new ArrayList<>();
    public void setFantomes(List<Fantome> fantomes) {
        this.fantomes = fantomes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private Fruit getFruitAtPosition(List<Fruit> fruits, int x, int y, TypeFruit type) {
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().getPositionX() == x && fruit.getPosition().getPositionY() == y && fruit.getType() == type) {
                return fruit; // Retourne l'objet Fruit correspondant à la position et au type spécifiés
            }
        }
        return null; // Retourne null si aucun fruit correspondant n'est trouvé
    }

    public Boule getBouleAtPosition(List<Boule> boules, int x, int y) {
        for (Boule boule : boules) {
            if (boule.getPosition().getPositionX() == x && boule.getPosition().getPositionY() == y) {
                return boule; // Retourne l'objet Boule correspondant à la position spécifiée
            }
        }
        return null; // Retourne null si aucune boule correspondante n'est trouvée
    }

    private SuperBoule getSuperBouleAtPosition(List<SuperBoule> superBoules, int x, int y) {
        for (SuperBoule superBoule : superBoules) {
            if (superBoule.getPosition().getPositionX() == x && superBoule.getPosition().getPositionY() == y) {
                return superBoule; // Retourne l'objet SuperBoule correspondant à la position spécifiée
            }
        }
        return null; // Retourne null si aucune superboule correspondante n'est trouvée
    }

    public void demarrerJeu() {
/*
        String[][] tableau2D = new String[11][11];
        int x;

        for (int i = 0; i < tableau2D.length; i++) {
            for (int j = 0; j < tableau2D.length; j++) {
                tableau2D[i][j]= "X";
            }
        }

        tableau2D[0][4]="P";
*/

        char[][] tableau2D = {
                {'P', 'o', 'K', 'K', 'M', '.', '.', '.', '.', '.', '.', '.', '.', 'O', '.'},
                {'O', 'M', '.', 'C', 'M', '.', '.', '.', 'M', 'M', '.', 'o', 'M', '.', '.'},
                {'K', 'M', 'M', 'O', 'M', 'M', '.', 'M', '.', 'C', '.', '.', '.', 'K', '.'},
                {'O', '.', 'M', 'M', '.', 'M', '.', 'M', '.', '.', 'O', 'M', 'M', 'M', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', 'M', 'M', 'M', '.', '.', 'K', 'M', 'M'},
                {'B', 'C', 'M', '.', '.', 'M', '.', 'O', 'M', '.', '.', 'M', '.', 'K', 'C'},
                {'K', '.', '.', 'O', '.', '.', '.', 'M', '.', 'M', '.', 'M', 'M', 'M', '.'},
                {'M', 'M', 'M', '.', 'M', 'B', 'M', 'K', 'M', '.', 'M', 'K', 'M', '.', 'o'},
                {'.', '.', 'M', '.', 'M', '.', 'M', '.', 'M', 'o', 'M', '.', '.', 'B', '.'},
                {'M', 'M', 'M', '.', '.', '.', 'M', 'M', 'M', '.', '.', 'C', 'M', 'M', '.'},
                {'K', 'o', '.', '.', '.', 'B', 'C', '.', 'M', '.', 'O', '.', 'M', '.', '.'},
                {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'K', '.', 'C', '.', 'O', 'M', '.', '.'},
                {'.', '.', '.', 'M', '.', 'C', '.', '.', '.', 'M', '.', 'M', 'M', 'O', 'C'},
                {'C', 'O', '.', 'M', '.', '.', '.', 'B', '.', '.', 'B', 'M', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', 'o', 'K', 'M', '.'}
        };

        for (int i = 0; i < tableau2D.length; i++) {
            for (int j = 0; j < tableau2D[i].length; j++) {
                if (tableau2D[i][j] == 'o' || tableau2D[i][j] == 'O') {
                    boolean isSuperBoule = (tableau2D[i][j] == 'O'); // Vérifier si c'est une superboule

                    // Créer un objet Boule à la position (i, j) dans la grille
                    Boule boule = new Boule(new Point(i, j), isSuperBoule);

                    // Ajouter l'objet Boule créé à la liste des boules
                    boules.add(boule);
                }
            }
        }

        // Parcourir la grille pour créer les objets Fruit
        for (int i = 0; i < tableau2D.length; i++) {
            for (int j = 0; j < tableau2D[i].length; j++) {
                switch (tableau2D[i][j]) {
                    case 'C': // Création d'une cerise
                        Fruit cerise = new Fruit(TypeFruit.CERISE, new Point(i, j));
                        fruits.add(cerise);
                        break;
                    case 'O': // Création d'une orange
                        Fruit orange = new Fruit(TypeFruit.BANANE, new Point(i, j));
                        fruits.add(orange);
                        break;

                    case 'K': // Création d'un kiwi
                        Fruit kiwi = new Fruit(TypeFruit.KIWI, new Point(i, j));
                        fruits.add(kiwi);
                        break;
                    default:
                        // Si le caractère n'est pas associé à un fruit, passer au suivant
                        break;
                }
            }
        }



/*
// Affichage du nombre total d'objets Boule créés
        System.out.println("Nombre total d'objets Boule créés : " + boules.size());

// Affichage des positions des objets Boule dans la liste boules
        System.out.println("Positions des objets Boule créés :");
        for (Boule boule : boules) {
            System.out.println("Position : (" + boule.getPosition().getPositionX() + ", " + boule.getPosition().getPositionY() + ")");
            System.out.println("Est superboule : " + boule.IsSuperBoule());
            System.out.println("------------------");
        }


 */
        int score = 0;
        Direction d = Direction.DROITE;


        int x;

        while (true) {
            x = 0;
            for (int i = 0; i < tableau2D.length; i++) {
                for (int j = 0; j < tableau2D.length; j++) {
                    System.out.print(tableau2D[i][j]+ "    ");

                }
                System.out.println();

            }
            System.out.println(score);
            System.out.println("-------------------------------------------------------------------");

// Reaction des differents déplacements
            for (int i = 0; i < tableau2D.length; i++) {
                for (int j = 0; j < tableau2D.length; j++) {

                    if(tableau2D[i][j]=='P'){
                        x = x +1;
                            if (x == 1) {
                                //DROITE
                                if (d == Direction.DROITE && j< tableau2D[0].length-1) {
                                    //REACTION A CASE


                                    if(tableau2D[i][j+1]=='.'){
                                        tableau2D[i][j] = '.';
                                        tableau2D[i][j + 1] = 'P';
                                    } else if (tableau2D[i][j+1]=='M') {System.out.println("MUR A DROITE");}


                                    // Vérifiez si la case contient une boule ou une superboule)
                                    if (tableau2D[i][j + 1] == 'o' || tableau2D[i][j + 1] == 'O' ){
                                        Boule bouleMange = null;
                                        SuperBoule superbouleMange = null ;
                                        // Initialisez un objet Fruit à null
                                        switch (tableau2D[i][j + 1]) {
                                            case 'o': // Boule
                                                // Obtenez la boule correspondant à la cerise à la position (i, j + 1)
                                                bouleMange = getBouleAtPosition(boules, i, j + 1);
                                                break;
                                            case 'O': //
                                                // Obtenir la superboule correspendante à la position (i, j + 1)
                                                superbouleMange = getSuperBouleAtPosition(superBoules, i, j + 1);
                                                break;

                                            default:
                                                break;
                                        }

                                        if (bouleMange != null) {
                                            // Ajoutez les points du fruit mangé au score
                                            score += bouleMange.getScore();

                                            // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                            tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                            tableau2D[i][j + 1] = 'P'; // Déplacez Pac-Man sur la case suivante
                                        }
                                    else if (superbouleMange != null ) {
                                            // Ajoutez les points du fruit mangé au score
                                            score += superbouleMange.getScore();

                                            // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                            tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                            tableau2D[i][j + 1] = 'P'; // Déplacez Pac-Man sur la case suivante
                                    }
                                }


                                    // Vérifiez si la case contient un fruit ('B' pour cerise, 'K' pour kiwi, 'C' pour litchi, etc.)
                                    if (tableau2D[i][j + 1] == 'B' || tableau2D[i][j + 1] == 'K' || tableau2D[i][j + 1] == 'C') {
                                        Fruit fruitMange = null; // Initialisez un objet Fruit à null

                                        switch (tableau2D[i][j + 1]) {
                                            case 'B': // Banane
                                                // Obtenir l'objet Fruit correspondant à la cerise à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.BANANE);
                                                break;
                                            case 'K': // Kiwi
                                                // Obtenir l'objet Fruit correspondant au kiwi à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.KIWI);
                                                break;
                                            case 'C': // Cerise
                                                // Obtenir l'objet Fruit correspondant au litchi à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.CERISE);
                                                break;

                                            default:
                                                break;
                                        }


                                    if (fruitMange != null) {
                                        // Ajout des points du fruit mangé au score
                                        score += fruitMange.getScore();

                                        // Mettre à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                        tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                        tableau2D[i][j + 1] = 'P'; // Déplacez Pac-Man sur la case suivante
                                   }}
                                }

                                //HAUT
                                else if (d == Direction.HAUT && i> 0) {
                                    //REACTION A CASE
                                    if(tableau2D[i-1][j]=='.'){
                                        tableau2D[i][j] = '.';
                                        tableau2D[i-1][j] = 'P';
                                    }else if(tableau2D[i-1][j]=='M'){System.out.println("MUR EN HAUT");

                                    }
                                    // Vérifiez si la case contient une boule ou une superboule)
                                    if (tableau2D[i-1][j] == 'o' || tableau2D[i-1][j] == 'O' ){
                                        Boule bouleMange = null;
                                        SuperBoule superbouleMange = null ;
                                        // Initialisez un objet boule à null
                                        switch (tableau2D[i-1][j]) {
                                            case 'o': // Boule
                                                // Obtenez la boule correspondant à la cerise à la position (i, j + 1)
                                                bouleMange = getBouleAtPosition(boules, i, j + 1);
                                                break;
                                            case 'O': //
                                                // Obtenir la superboule correspendante à la position (i, j + 1)
                                                superbouleMange = getSuperBouleAtPosition(superBoules, i, j + 1);
                                                break;

                                            default:
                                                break;
                                        }

                                        if (bouleMange != null) {
                                            // Ajoutez les points du fruit mangé au score
                                            score += bouleMange.getScore();

                                            // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                            tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                            tableau2D[i-1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                        }
                                        else if (superbouleMange != null ) {
                                            // Ajoutez les points du fruit mangé au score
                                            score += superbouleMange.getScore();

                                            // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                            tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                            tableau2D[i-1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                        }
                                    }


                                    // Vérifiez si la case contient un fruit ('B' pour cerise, 'K' pour kiwi, 'C' pour litchi, etc.)
                                    if (tableau2D[i-1][j] == 'B' || tableau2D[i-1][j] == 'K' || tableau2D[i-1][j] == 'C') {
                                        Fruit fruitMange = null; // Initialisez un objet Fruit à null

                                        switch (tableau2D[i-1][j]) {
                                            case 'B': // Banane
                                                // Obtenir l'objet Fruit correspondant à la cerise à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.BANANE);
                                                break;
                                            case 'K': // Kiwi
                                                // Obtenir l'objet Fruit correspondant au kiwi à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.KIWI);
                                                break;
                                            case 'C': // Cerise
                                                // Obtenir l'objet Fruit correspondant au litchi à la position (i, j + 1)
                                                fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.CERISE);
                                                break;

                                            default:
                                                break;
                                        }


                                        if (fruitMange != null) {
                                            // Ajout des points du fruit mangé au score
                                            score += fruitMange.getScore();

                                            // Mettre à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                            tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                            tableau2D[i-1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                        }}
                                }

                                //GAUCHE
                                else if (d == Direction.GAUCHE && j> 0) {
                                    //REACTION A CASE
                                    if(tableau2D[i][j-1]=='.') {
                                        tableau2D[i][j] = '.';
                                        tableau2D[i][j - 1] = 'P';
                                    }else if(tableau2D[i][j-1]=='M') {System.out.println("MUR A GAUCHE");}

                                // Vérifiez si la case contient une boule ou une superboule)
                                if (tableau2D[i][j-1]== 'o' || tableau2D[i][j-1] == 'O' ){
                                    Boule bouleMange = null;
                                    SuperBoule superbouleMange = null ;
                                    // Initialisez un objet boule à null
                                    switch (tableau2D[i][j-1]) {
                                        case 'o': // Boule
                                            // Obtenez la boule correspondant à la cerise à la position (i, j + 1)
                                            bouleMange = getBouleAtPosition(boules, i, j + 1);
                                            break;
                                        case 'O': //
                                            // Obtenir la superboule correspendante à la position (i, j + 1)
                                            superbouleMange = getSuperBouleAtPosition(superBoules, i, j + 1);
                                            break;

                                        default:
                                            break;
                                    }

                                    if (bouleMange != null) {
                                        // Ajoutez les points du fruit mangé au score
                                        score += bouleMange.getScore();

                                        // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                        tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                        tableau2D[i][j-1] = 'P'; // Déplacez Pac-Man sur la case suivante
                                    }
                                    else if (superbouleMange != null ) {
                                        // Ajoutez les points du fruit mangé au score
                                        score += superbouleMange.getScore();

                                        // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                        tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                        tableau2D[i][j-1] = 'P'; // Déplacez Pac-Man sur la case suivante
                                    }
                                }


                                // Vérifiez si la case contient un fruit ('B' pour cerise, 'K' pour kiwi, 'C' pour litchi, etc.)
                                if (tableau2D[i][j-1] == 'B' || tableau2D[i][j-1] == 'K' || tableau2D[i-1][j] == 'C') {
                                    Fruit fruitMange = null; // Initialisez un objet Fruit à null

                                    switch (tableau2D[i][j-1]) {
                                        case 'B': // Banane
                                            // Obtenir l'objet Fruit correspondant à la cerise à la position (i, j + 1)
                                            fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.BANANE);
                                            break;
                                        case 'K': // Kiwi
                                            // Obtenir l'objet Fruit correspondant au kiwi à la position (i, j + 1)
                                            fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.KIWI);
                                            break;
                                        case 'C': // Cerise
                                            // Obtenir l'objet Fruit correspondant au litchi à la position (i, j + 1)
                                            fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.CERISE);
                                            break;

                                        default:
                                            break;
                                    }


                                    if (fruitMange != null) {
                                        // Ajout des points du fruit mangé au score
                                        score += fruitMange.getScore();

                                        // Mettre à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                        tableau2D[i][j] = '.';
                                        tableau2D[i][j-1] = 'P';
                                    }
                                }
                                }
                                //BAS
                                else if (d == Direction.BAS && i< tableau2D.length-1) {
                                    //REACTION A CASE
                                    if(tableau2D[i+1][j]=='.') {
                                        tableau2D[i][j] = '.';
                                        tableau2D[i + 1][j] = 'P';
                                    }else if(tableau2D[i+1][j]=='M'){System.out.println("MUR EN BAS");}

                                    // Vérifiez si la case contient une boule ou une superboule)
                                        if (tableau2D[i+1][j]== 'o' || tableau2D[i+1][j] == 'O' ){
                                            Boule bouleMange = null;
                                            SuperBoule superbouleMange = null ;
                                            // Initialisez un objet boule à null
                                            switch (tableau2D[i+1][j]) {
                                                case 'o': // Boule
                                                    // Obtenez la boule correspondant à la cerise à la position (i, j + 1)
                                                    bouleMange = getBouleAtPosition(boules, i, j + 1);
                                                    break;
                                                case 'O': //
                                                    // Obtenir la superboule correspendante à la position (i, j + 1)
                                                    superbouleMange = getSuperBouleAtPosition(superBoules, i, j + 1);
                                                    break;

                                                default:
                                                    break;
                                            }

                                            if (bouleMange != null) {
                                                // Ajoutez les points du fruit mangé au score
                                                score += bouleMange.getScore();

                                                // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                                tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                                tableau2D[i+1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                            }
                                            else if (superbouleMange != null ) {
                                                // Ajoutez les points du fruit mangé au score
                                                score += superbouleMange.getScore();

                                                // Mettez à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                                tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                                tableau2D[i+1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                            }
                                        }


                                        // Vérifiez si la case contient un fruit ('B' pour cerise, 'K' pour kiwi, 'C' pour litchi, etc.)
                                        if (tableau2D[i+1][j] == 'B' || tableau2D[i+1][j] == 'K' || tableau2D[i+1][j] == 'C') {
                                            Fruit fruitMange = null; // Initialisez un objet Fruit à null

                                            switch (tableau2D[i+1][j]) {
                                                case 'B': // Banane
                                                    // Obtenir l'objet Fruit correspondant à la cerise à la position (i, j + 1)
                                                    fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.BANANE);
                                                    break;
                                                case 'K': // Kiwi
                                                    // Obtenir l'objet Fruit correspondant au kiwi à la position (i, j + 1)
                                                    fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.KIWI);
                                                    break;
                                                case 'C': // Cerise
                                                    // Obtenir l'objet Fruit correspondant au litchi à la position (i, j + 1)
                                                    fruitMange = getFruitAtPosition(fruits, i, j + 1, TypeFruit.CERISE);
                                                    break;

                                                default:
                                                    break;
                                            }


                                            if (fruitMange != null) {
                                                // Ajout des points du fruit mangé au score
                                                score += fruitMange.getScore();

                                                // Mettre à jour la grille et la position de Pac-Man après avoir mangé le fruit
                                                tableau2D[i][j] = '.'; // Mettre à jour la case comme vide après avoir mangé le fruit
                                                tableau2D[i+1][j] = 'P'; // Déplacez Pac-Man sur la case suivante
                                            }

                                         }
                                }

                            }
                        }


                }
                d = directionAleatoire(d); //Mettre ici la valeur de direction reçu
                System.out.println();

            }

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    private Direction directionAleatoire(Direction d) {
        Random random = new Random();

        int randomDirection = random.nextInt(4);

        if (randomDirection ==0){
            d=Direction.BAS;
        }
        else if (randomDirection ==1){
            d=Direction.HAUT;
        }
        else if (randomDirection ==2){
            d=Direction.DROITE;
        }
        else if (randomDirection ==3){
            d=Direction.GAUCHE;
        }

        return d;
    }







    public void terminerJeu() {
    }

    public boolean verifierCollision() {
        // Vérifiez s'il y a une collision entre Pac-Man et un fantôme
        return false; // Par défaut, il n'y a pas de collision
    }

    public void mangerFruit(Fruit fruit) {
        // Gérez l'action de manger un fruit
        int points = fruit.getScore(); // Obtenez les points associés au fruit
        score += points; // Ajoutez les points au score du joueur
    }
}
