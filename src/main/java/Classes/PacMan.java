package Classes;
public class PacMan extends Personnage {
    private int vies;
    private int vitesse;
    private String couleur;

    public PacMan(Point position, Direction direction, int vies, int vitesse, String couleur) {
        super(position, direction);
        this.vies = vies;
        this.vitesse = vitesse;
        this.couleur = couleur;
    }

    public int getVies() {
        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void mangerPoint() {
    }

    @Override
    public void deplacer() {
    }

    @Override
    public void mourir() {

    }

}
