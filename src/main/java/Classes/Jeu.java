package Classes;
import java.util.List;

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

    public void setFantomes(List<Fantome> fantomes) {
        this.fantomes = fantomes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void demarrerJeu() {
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
