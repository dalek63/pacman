package Classes;

import java.util.List;

public class Boule {
    private Point position;
    private boolean superBoule ;

    public Boule(Point position, boolean superBoule ) {

        this.position = position;
        this.superBoule = superBoule;
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
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }


    public int getScore() {
        int points = 25 ;
        return points;
    }


    // Méthode pour obtenir l'objet Boule à une position spécifique dans la liste de boules

}
