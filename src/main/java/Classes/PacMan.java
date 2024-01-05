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


    public void deplacerpacman(Terrain terrain, Direction d) {
        for (int i = 0; i < terrain.getGrille().length; i++) {
            for (int j = 0; j < terrain.getGrille().length; j++) {

                if (terrain.getGrille()[i][j] == 'P') {
                    int x=+ 1;
                    if (x == 1) {
                        //DROITE
                        if (d == Direction.DROITE && j < terrain.getGrille()[0].length - 1) {
                            //REACTION A CASE

                            if (terrain.getGrille()[i][j + 1] == '.') {
                                terrain.getGrille()[i][j] = '.';
                                terrain.getGrille()[i][j + 1] = 'P';
                            } else if (terrain.getGrille()[i][j + 1] == 'M') {
                                System.out.println("MUR A DROITE");
                            } else if (terrain.getGrille()[i][j + 1] == 'F') {
                                System.out.println("PERDU");
                            }

                        }
                    }
                }
            }
        }
    }

    @Override
    public void mourir() {

    }

}
