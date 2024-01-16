package Classes;

public abstract class Personnage {
    private Point position;
    private Direction direction;

    public Personnage(Point position) {
        this.position = position;
    }
    public Personnage(Point position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }


    public abstract void mourir();

    // Getters & setters pour position et direction
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

