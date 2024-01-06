package Classes;
public class Terrain {
    private char[][] grille;
    private char[][] grilleNiveau2;
    private char[][] grilleNiveau3;

    public Terrain() {

        grille = new char[][] {

                {'P', 'o', '.'},
                {'.', 'M', '.'}
        };



       grilleNiveau2 = new char[][] {
               {'P', 'o', '.'},
               {'.', 'M', '.'}
        };
       grilleNiveau3 = new char[][] {
                {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'},
                {'M', 'P', 'o', 'M', '.', 'K', 'M', '.', 'M', 'o', 'C', 'M', '.', 'B', 'M'},
                {'M', 'M', 'M', '.', 'M', '.', 'M', 'o', 'M', '.', 'M', '.', 'M', 'M', 'M'},
                {'M', 'o', '.', '.', 'o', '.', '.', '.', '.', '.', 'o', '.', '.', 'o', 'M'},
                {'M', 'M', 'M', '.', 'M', 'M', 'M', 'M', 'M', 'M', '.', 'M', 'M', 'M', 'M'},
                {'M', 'K', 'o', '.', '.', 'M', 'B', 'O', 'M', '.', '.', '.', 'o', 'K', 'M'},
                {'M', '.', 'M', 'M', 'M', '.', 'M', '.', 'M', '.', 'M', 'M', 'M', '.', 'M'},
                {'M', 'o', 'M', '.', 'M', 'o', 'M', 'C', 'M', 'o', 'M', '.', 'M', 'o', 'M'},
                {'M', '.', 'M', 'M', 'M', '.', 'M', '.', 'M', '.', 'M', 'M', 'M', '.', 'M'},
                {'M', 'C', 'o', '.', '.', 'M', '.', 'M', 'M', '.', '.', '.', 'o', 'C', 'M'},
                {'M', 'M', 'M', '.', 'M', 'M', 'M', 'M', 'M', 'M', '.', 'M', 'M', 'M', 'M'},
                {'M', '.', '.', 'o', '.', 'M', '.', '.', '.', 'M', '.', 'o', '.', '.', 'M'},
                {'M', 'o', 'M', 'M', '.', 'M', 'M', '.', 'M', 'M', '.', 'M', 'M', 'o', 'M'},
                {'M', 'B', 'o', 'M', '.', 'o', 'M', '.', 'M', 'o', '.', 'M', 'o', 'F', 'M'},
                {'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M'}
        };
    }

    public char[][] getGrille() {
        return grille;
    }
    // Méthode pour changer la grille en fonction du niveau
    public void changerNiveau(int niveau) {
        switch (niveau) {

            case 2:
                grille = grilleNiveau2;
                break;
            case 3:
                grille = grilleNiveau3;
                break;
            // ... autres niveaux ...
            default:
                // Gestion du cas où le niveau n'est pas défini
                break;
        }


    }}
