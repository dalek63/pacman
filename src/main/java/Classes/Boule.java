package Classes;

import java.util.List;

public class Boule {
    private Point position;
    private boolean superBoule ;

    public Boule(Point position, boolean superBoule ) {

        this.position = position;
        this.superBoule = superBoule;
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


}
