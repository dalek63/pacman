package Classes;

import java.util.List;

public class Fruit {
    private TypeFruit type;
    private Point position;

    public Fruit(TypeFruit type, Point position) {
        this.type = type;
        this.position = position;
    }

    public TypeFruit getType() {
        return type;
    }

    public void setType(TypeFruit type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    // Méthode pour obtenir l'objet Fruit à une position spécifique dans la liste de fruits

    public int getScore() {

        int points = 0;
        switch (type) {
            case CERISE:
                points = 100; // Exemple de points pour une cerise
                break;
            case BANANE:
                points = 200; // Exemple de points pour une orange
                break;

            case KIWI :
                points = 300;
                break;
            default:
                points = 0; // Par défaut, aucun point
        }
        return points;
    }
}
