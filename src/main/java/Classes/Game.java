package Classes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Component
public class Game {

    private Terrain terrain;
    private PacMan pacMan;
    private List<Fantome> fantomes;
    private int score;
    private boolean started;
//    private boolean enCours;
//    private int niveauActuel;

    List<Boule> boules = new ArrayList<>();
    List<SuperBoule> superBoules = new ArrayList<>();
    List<Fruit> fruits = new ArrayList<>();
    ArrayList<Integer> lastDirections = new ArrayList<>();

    public Game() {
        this.terrain =  new Terrain();
//        this.pacMan = pacMan;
        this.fantomes = new ArrayList<>();
//        this.niveauActuel = 1;
        this.score = 0;
//        this.enCours = true;
    }

//    public char[][] updateGrid(String direction) {
    public char[][] updateGrid(int direction) {
        System.out.println("updateGrid "+ direction);
        // Mettre à jour la position du Pac-Man en fonction de la direction
        // on recoit -1 pour la direction si il ne bouge pas sinon 0,1,2 ou 3
        if (direction != -1) {
            pacMan.deplacer(this.terrain.getGrille(), direction);
//            this.lastDirections.add(direction);
        }


        // Mettre à jour la position des fantômes
        deplacerFantomes();

        // Afficher la grille mise à jour (peut être envoyée au front-end)
        afficherGrille(this.terrain.getGrille());
        return this.terrain.getGrille();
    }
    public void demarrerJeu(){
        afficherGrille(terrain.getGrille());
        this.started = true;
        initialiserJeu();

    }

    public void finJeu(){
        this.started = false ;
    }


    public void reinitialiserGrille() {
        this.terrain = new Terrain();
        initialiserFruitEtBoule(); // TO DO reinitiliser et save les manger
        reinitialiserFantomesEtPacman();
    }

    public void initialiserJeu(){
        initialiserFruitEtBoule();
        initialiserFantomesEtPacman();
    }

    private void initialiserFantomesEtPacman() {
        for (int i = 0; i < this.terrain.getGrille().length; i++) {
            for (int j = 0; j < this.terrain.getGrille()[i].length; j++) {
                if (this.terrain.getGrille()[i][j] == 'F') {
                    // Trouvé un fantôme dans la grille, instanciez un objet Fantome
                    Fantome fantome = new Fantome(new Point(i, j),this);
                    this.fantomes.add(fantome);
                } else if (this.terrain.getGrille()[i][j] == 'P') {
                    // Trouvé le Pac-Man dans la grille, instanciez un objet Pacman
                    PacMan pacman = new PacMan(new Point(i, j),this);
                    // Initialisez le Pac-Man
                    this.pacMan = pacman;
                }
            }
        }
    }

    private void reinitialiserFantomesEtPacman() {
        System.out.println("Start REINIT");
        for (int i = 0; i < this.terrain.getGrille().length; i++) {
            for (int j = 0; j < this.terrain.getGrille()[i].length; j++) {
                if (this.terrain.getGrille()[i][j] == 'F') {
                    if (!this.fantomes.isEmpty()) {
                        Fantome fantome = this.fantomes.remove(0); // Retire le premier fantôme de la liste
                        fantome.setPosition(new Point(i, j));
                        this.fantomes.add(fantome); // Ajoute le fantôme mis à jour à la fin de la liste
                    }
                } else if (this.terrain.getGrille()[i][j] == 'P') {
                    this.pacMan.setPosition(new Point(i,j));
                }
            }
        }
        System.out.println("FINISH REINIT");
    }


    private void initialiserFruitEtBoule() {
        for (int i = 0; i < terrain.getGrille().length; i++) {
            for (int j = 0; j < terrain.getGrille()[i].length; j++) {
                if (terrain.getGrille()[i][j] == 'o' || terrain.getGrille()[i][j] == 'O') {
                    boolean isSuperBoule = (terrain.getGrille()[i][j] == 'O'); // Vérifier si c'est une superboule

                    // Créer un objet Boule à la position (i, j) dans la grille
                    Boule boule = new Boule(new Point(i, j), isSuperBoule);

                    // Ajouter l'objet Boule créé à la liste des boules
                    boules.add(boule);
                }
            }
        }

        // Parcourir la grille pour créer les objets Fruit
        for (int i = 0; i < terrain.getGrille().length; i++) {
            for (int j = 0; j < terrain.getGrille()[i].length; j++) {
                switch (terrain.getGrille()[i][j]) {
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
    }

    public void deplacerFantomes() {
        for (Fantome fantome : this.fantomes) {
            fantome.deplacer(this.terrain.getGrille()); // Appeler la méthode deplacement du fantome
        }
        System.out.println("FINISH depalcerFantomes");
    }

    public void afficherGrille(char[][] grille) {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();  // Saut de ligne après chaque ligne de la grille
        }
    }
    public char[][] getTerrain(){
        return this.terrain.getGrille();
    }
    public boolean isStarted() {
        return started;
    }

    public PacMan getPacMan(){
        return this.pacMan;
    }

    public void setScore(int pointGagne){
        this.score+= pointGagne;
    }

    public int getScore() {return score; }

}
