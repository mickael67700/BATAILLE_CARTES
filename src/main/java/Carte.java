import org.apache.commons.lang3.ArrayUtils;

public class Carte {
    int valeur; // Valeur de la carte pour comparaison
    String carte; // 2,3,....,valet, dame, roi
    Carte[] jeuDeCartes = new Carte[52];
    Carte[] jeuDeCartesJoueur1 = new Carte[jeuDeCartes.length/2];
    Carte[] jeuDeCartesJoueur2 = new Carte[jeuDeCartes.length/2];

    public Carte() {
    }

    public Carte(int valeur, String carte) {
        this.valeur = valeur;
        this.carte = carte;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public void constructionJeuDeCartes() {
        int[] val = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        String[] typeCarte = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
        String[] classe = new String[]{"Coeur", "Pique", "Trèfle", "Carreaux"};
        int k = 0;
        for (int i = 0; i < classe.length; i++) {
            for (int j = 0; j < val.length; j++) {

                jeuDeCartes[k] = new Carte(val[j], typeCarte[j] + " " + classe[i]);
                //System.out.println(val[j] + " " + typeCarte[j]+ " " + classe[i] + " " + k );
                k++;
            }
        }
        //Mélange tableau jeuDeCartes
        ArrayUtils.shuffle(jeuDeCartes);
        //affichage jeuDeCarte
        for (Carte carte : jeuDeCartes) {
            System.out.println(carte.getCarte());
        }
    }

    public void distributionCartes(){
        //Distribution cartes joueur 1 , cartes index pair
        int j = 0;
        for (int i = 0; i<jeuDeCartesJoueur1.length; i ++){
            jeuDeCartesJoueur1[i] = jeuDeCartes[i];
            j = j+2;
        }
        //Distribution cartes joueur 2 , cartes index impair
        j = 1;
        for (int i = 0; i<jeuDeCartesJoueur2.length; i++){
            jeuDeCartesJoueur2[i] = jeuDeCartes[j];
            j = j+2;
        }
        for (Carte carte : jeuDeCartesJoueur1) {
            System.out.println("joueur 1 :"+carte.getCarte());
        }
        for (Carte carte : jeuDeCartesJoueur2) {
            System.out.println("joueur 2 :"+carte.getCarte());
        }
    }
}


