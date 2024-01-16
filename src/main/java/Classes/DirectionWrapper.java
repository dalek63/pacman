package Classes;

public class DirectionWrapper{
    private String direction;


    public DirectionWrapper(String direction){
        this.direction = direction;
    }
    public int getDirection() {
        return convertStringToInt(direction);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    // Convertit la direction recu en JSON en int
    public int convertStringToInt(String direction){
        switch (direction) {
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "-1":
                return -1;
            default:
                throw new IllegalArgumentException("La direction doit être l'une des valeurs suivantes : -1, 0, 1, 2, 3");
        }
    }

}
