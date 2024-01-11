package Classes;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Component
public class Game {

    private Terrain terrain;
    private PacMan pacMan;
    private ArrayList<Fantome> fantomes;
    private int score;
    private boolean started;
    private int niveauActuel;
    private boolean isWin; //True si on a gagne ou false sinon.
    List<Boule> boules = new ArrayList<>();
    List<SuperBoule> superBoules = new ArrayList<>();
    List<Fruit> fruits = new ArrayList<>();
    ArrayList<Integer> lastDirections = new ArrayList<>();
    private boolean modeSansMur = false;

    public Game() {
        this.terrain =  new Terrain();
        this.fantomes = new ArrayList<>();
    }

//    public char[][] updateGrid(String direction) {
    public void updateGrid(int direction) {
        System.out.println("updateGrid "+ direction);

        if(this.started){ // si le jeu est toujours en cours
            /*Mettre à jour la position du Pac-Man en fonction de la direction
                on recoit -1 pour la direction si il ne bouge pas sinon 0,1,2 ou 3*/

        if (direction != -1) {
            pacMan.deplacer(this.terrain.getGrille(), direction);
//            this.lastDirections.add(direction);
        }

        // Mettre à jour la position des fantômes
        deplacerFantomes();

        // Afficher la grille mise à jour (peut être envoyée au front-end)
        afficherGrille(this.terrain.getGrille());
    }
}

    private void preparerNouveauNiveau() {
        this.checkWin(); // verifie si on a win
        if(!this.isWin){ // sinon on continue
            this.niveauActuel++;
            this.terrain.changerNiveau(niveauActuel);
            initialiserFruitEtBoule();
            initialiserFantomesEtPacman();
            // Réinitialiser les positions de Pac-Man et des fantômes, etc.
            System.out.println("Bravo, Niveau suivant ! Niveau " + niveauActuel);
        }
    }

    public void verifierEtMettreAJourNiveau() {
        if (toutesLesBoulesMangees()) {
            System.out.println("Bravo, Niveau suivant !");
            preparerNouveauNiveau();
        }
    }
    public void demarrerJeu(){
        afficherGrille(this.terrain.getGrille());
        this.started = true;

        initialiserJeu();
    }

    public void finJeu(){
        this.started = false ;
    }


    public void reinitialiserGrille() { // Réinitialise la map d'origine
        this.terrain = new Terrain();
        initialiserFruitEtBoule(); // TO DO reinitiliser et save les manger
        reinitialiserFantomesEtPacman();
    }

    public void initialiserJeu(){
        initialiserFruitEtBoule();
        initialiserFantomesEtPacman();
        initParametre();
    }

    public void initParametre(){
        this.isWin = false;
        this.setScore(0);
        this.niveauActuel = 1;
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
    private boolean estUnFruit(char caseActuelle) {
        // Vérifier si le caractère représente un fruit (à adapter selon votre implémentation)
        return caseActuelle == 'B' || caseActuelle == 'K' || caseActuelle == 'C';
    }

    private boolean toutesLesBoulesMangees() {
        // Vérifier si toutes les boules, superboules et fruits ont été mangées
        for (int i = 0; i < this.terrain.getGrille().length; i++) {
            for (int j = 0; j < this.terrain.getGrille().length; j++) {
                char caseActuelle = this.terrain.getGrille()[i][j];
                if (caseActuelle == 'o' || caseActuelle == 'O' || estUnFruit(caseActuelle)) {
                    return false; // Il reste des éléments à manger
                }
            }
        }
        return true; // Tous les éléments ont été mangés
    }
    public void deplacerFantomes() {
        for (Fantome fantome : this.fantomes) {
            System.out.println("MOUVVVVVV");
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
        return this.started;
    }

    public PacMan getPacMan(){
        return this.pacMan;
    }

    public ArrayList<Fantome> getFantomes(){
        return this.fantomes;
    }

    public void setScore(int pointGagne){
        this.score+= pointGagne;
    }

    public int getScore() {return score; }

    public int getNiveauActuel() {return niveauActuel;}

    public boolean modeSansMurIsActive(){
        return this.modeSansMur;
    }
    public void activeModeSansMur(){
        this.modeSansMur = true;
    }

    // Vérifie si on a gagne la partie, on l'appel lorsqu'on prépare un nouveau niveau
    public void checkWin(){ //TO DO win par niveau ?
        if (this.niveauActuel == 3 && this.toutesLesBoulesMangees()){
            this.isWin = true;
            this.started =false;
        }
    }

    public void gameOver(){
        this.isWin = false;
        this.started = false;
    }


    public String getResult() { // Retouren si on a gagner ou perdu la partie
        if (this.started && !this.isWin) { // si le jeu est lancer
            return "Partie en cours";
        }
        return this.isWin? "WIN" : "Game Over !";
    }
}
