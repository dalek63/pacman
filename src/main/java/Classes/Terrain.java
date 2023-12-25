package Classes;

public class Terrain {
    private Cellule[][] grille;

    public Terrain(int lignes, int colonnes) {
        grille = new Cellule[lignes][colonnes];

        // Initialisez chaque Cellule avec un type par défaut (par exemple, VIDE)
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] = new Cellule(TypeCellule.VIDE, new Point(i, j));
            }
        }
    }

    public void initialiserTerrainAvecMurs() {
        // Logique pour définir les murs sur le terrain
        grille[1][1].setType(TypeCellule.MUR);
        grille[2][2].setType(TypeCellule.MUR);
        // Ajoutez d'autres cellules de type mur selon vos besoins
    }

    public Cellule getCellule(int ligne, int colonne) {
        if (estDansLimites(ligne, colonne)) {
            return grille[ligne][colonne];
        } else {
            // Gérer l'erreur si les coordonnées sont hors limites
            return null;
        }
    }

    private boolean estDansLimites(int ligne, int colonne) {
        return ligne >= 0 && ligne < grille.length && colonne >= 0 && colonne < grille[0].length;
    }

    public int obtenirValeurCellule(int ligne, int colonne) {
        if (estDansLimites(ligne, colonne)) {
            return grille[ligne][colonne].getType().ordinal();
        } else {
            // Gérer l'erreur (par exemple, renvoyer une valeur par défaut)
            return -1;
        }
    }

    public void modifierValeurCellule(int ligne, int colonne, int nouvelleValeur) {
        if (estDansLimites(ligne, colonne)) {
            grille[ligne][colonne].setType(TypeCellule.values()[nouvelleValeur]);
        } else {
            // Gérer l'erreur (par exemple, afficher un message d'erreur)
            System.out.println("Erreur : Coordonnées hors limites.");
        }
    }

    // ... Ajoutez d'autres méthodes ou fonctionnalités pour la classe Terrain selon vos besoins
}
