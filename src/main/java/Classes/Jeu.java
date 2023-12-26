package Classes;
import java.util.List;

public class Jeu {
    private Terrain terrain;
    private PacMan pacMan;
    private List<Fantome> fantomes;
    private int score;

    public Jeu(Terrain terrain, PacMan pacMan, List<Fantome> fantomes) {
        this.terrain = terrain;
        this.pacMan = pacMan;
        this.fantomes = fantomes;
        this.score = 0;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public List<Fantome> getFantomes() {
        return fantomes;
    }

    public void setFantomes(List<Fantome> fantomes) {
        this.fantomes = fantomes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void demarrerJeu() {
/*
        String[][] tableau2D = new String[11][11];
        int x;

        for (int i = 0; i < tableau2D.length; i++) {
            for (int j = 0; j < tableau2D.length; j++) {
                tableau2D[i][j]= "X";
            }
        }

        tableau2D[0][4]="P";
*/

        char[][] tableau2D = {
                {'P', '.', '.', '.', 'M', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'M', '.', '.', '.', 'M', 'M', '.', '.', 'M', '.', '.'},
                {'.', 'M', 'M', '.', 'M', 'M', '.', 'M', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', '.', 'M', '.', 'M', '.', '.', '.', 'M', 'M', 'M', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', '.', 'M', '.', '.', 'M', '.', '.', 'M', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'M', '.', 'M', 'M', '.', '.'},
                {'M', 'M', 'M', '.', 'M', '.', 'M', '-', 'M', '.', 'M', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.', '.', '.', '.'},
                {'M', 'M', 'M', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', 'M', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', 'M', '.', '.', '.', 'M', '.', '.'},
                {'M', 'M', 'M', 'M', 'M', 'M', 'M', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'M', '.', '.', '.', '.', '.', 'M', '.', '.', 'M', '.', '.'},
                {'.', '.', '.', 'M', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', '.', '.', '.', '.'}
        };


        Direction d = Direction.DROITE;


        int x;

        while (true) {
            x = 0;
            for (int i = 0; i < tableau2D.length; i++) {
                for (int j = 0; j < tableau2D.length; j++) {
                    System.out.print(tableau2D[i][j]+ "    ");

                }
                System.out.println();

            }

            System.out.println("-------------------------------------------------------------------");

            for (int i = 0; i < tableau2D.length; i++) {
                for (int j = 0; j < tableau2D.length; j++) {

                    if(tableau2D[i][j]=='P'){
                        x = x +1;
                        if(tableau2D[i][j+1]!= 'M') {
                            if (x == 1) {
                                if (j == tableau2D.length - 1) {
                                    tableau2D[i][j] = '.';
                                    tableau2D[i + 1][0] = 'P';
                                } else {
                                    tableau2D[i][j] = '.';
                                    tableau2D[i][j + 1] = 'P';
                                }
                            }
                        }
                    }

                }
                System.out.println();

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }









    }

    public void terminerJeu() {
    }

    public boolean verifierCollision() {
        // Vérifiez s'il y a une collision entre Pac-Man et un fantôme
        return false; // Par défaut, il n'y a pas de collision
    }

    public void mangerFruit(Fruit fruit) {
        // Gérez l'action de manger un fruit
        int points = fruit.getScore(); // Obtenez les points associés au fruit
        score += points; // Ajoutez les points au score du joueur
    }
}
