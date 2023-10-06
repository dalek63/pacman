package Classes;
public class Terrain {
    private int[][] grille;

    public Terrain(int lignes, int colonnes) {
        grille = new int[lignes][colonnes];
    }

    public int obtenirValeurCellule(int ligne, int colonne) {
        if (estDansLimites(ligne, colonne)) {
            return grille[ligne][colonne];
        } else {
            // Gérer l'erreur (par exemple, renvoyer une valeur par défaut)
            return -1;
        }
    }

    public void modifierValeurCellule(int ligne, int colonne, int nouvelleValeur) {
        if (estDansLimites(ligne, colonne)) {
            grille[ligne][colonne] = nouvelleValeur;
        } else {
            // Gérer l'erreur (par exemple, afficher un message d'erreur)
            System.out.println("Erreur : Coordonnées hors limites.");
        }
    }

    private boolean estDansLimites(int ligne, int colonne) {
        return ligne >= 0 && ligne < grille.length && colonne >= 0 && colonne < grille[0].length;
    }
}
