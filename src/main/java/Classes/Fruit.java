package Classes;

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

    public int getScore() {
        // Implémentez la logique pour obtenir le nombre de points associés à ce fruit
        // Par exemple, en utilisant une correspondance entre le type de fruit et les points
        int points = 0;
        switch (type) {
            case CERISE:
                points = 100; // Exemple de points pour une cerise
                break;
            case ORANGE:
                points = 200; // Exemple de points pour une orange
                break;
            // Ajoutez d'autres cas pour les différents types de fruits
            default:
                points = 0; // Par défaut, aucun point
        }
        return points;
    }
}
