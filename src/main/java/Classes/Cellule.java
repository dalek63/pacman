package Classes;

public class Cellule {
    private TypeCellule type;
    private Point position;

    public Cellule(TypeCellule type, Point position) {
        this.type = type;
        this.position = position;
    }

    public TypeCellule getType() {
        return type;
    }

    public void setType(TypeCellule type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isMur() {
        return type == TypeCellule.MUR;
    }

    public boolean isPoint() {
        return type == TypeCellule.POINT;
    }

    public boolean isSuperPoint() {
        return type == TypeCellule.SUPER_POINT;
    }

    public boolean isVide() {
        return type == TypeCellule.VIDE;
    }
}
