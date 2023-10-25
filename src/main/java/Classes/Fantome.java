package Classes;

public class Fantome extends Personnage {
    private ModeFantome mode;

    public Fantome(Point position, Direction direction, ModeFantome mode) {
        super(position, direction);
        this.mode = mode;
    }

    public ModeFantome getMode() {
        return mode;
    }

    public void setMode(ModeFantome mode) {
        this.mode = mode;
    }

    public void disperser() {
        // Comportement de dispersion du fant
    }

    public void poursuivre() {
        // Comportement de poursuite du fant
    }

    public void effrayer() {
        // Comportement de devenir effrayé en mangeant un super-point
    }

    public void manger() {
        // Comportement de devenir mangé par Pac-Man
    }

    @Override
    public void deplacer() {
    }

    @Override
    public void mourir() {

    }
}
