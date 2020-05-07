import org.apache.commons.lang3.ArrayUtils;

public class Carte {
    int valeur; // Valeur de la carte pour comparaison
    String carte; // 2,3,....,valet, dame, roi
    Carte[] jeuDeCartes = new Carte[52];
    Carte[] jeuDeCartesJoueur1 = new Carte[jeuDeCartes.length/2];
    Carte[] jeuDeCartesJoueur2 = new Carte[jeuDeCartes.length/2];
    int compteurJoueur1 = 0;
    int compteurJoueur2 = 0;
    int victoireJoueur1 = 0;
    int victoireJoueur2 = 0;

    public Carte() {
    }

    public Carte(int valeur, String carte) {
        this.valeur = valeur;
        this.carte = carte;
    }

    public Carte[] getJeuDeCartes() {
        return jeuDeCartes;
    }

    public int getVictoireJoueur1() {
        return victoireJoueur1;
    }

    public int getVictoireJoueur2() {
        return victoireJoueur2;
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
        /*affichage jeuDeCarte pour test
        for (Carte carte : jeuDeCartes) {
            System.out.println(carte.getCarte());
        }
         */
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
        /* affichage pour test
        for (Carte carte : jeuDeCartesJoueur1) {
            System.out.println("joueur 1 :"+carte.getCarte());
        }
        for (Carte carte : jeuDeCartesJoueur2) {
            System.out.println("joueur 2 :"+carte.getCarte());
        }

         */
    }

    public void joue(){
        //Mélange tableau jeuDeCartes
        ArrayUtils.shuffle(jeuDeCartesJoueur1);
        ArrayUtils.shuffle(jeuDeCartesJoueur2);
        for(int i = 1 ; i<jeuDeCartesJoueur1.length; i++){
            Carte carteJoueur1 = jeuDeCartesJoueur1[jeuDeCartesJoueur1.length-i];
            Carte carteJoueur2 = jeuDeCartesJoueur2[jeuDeCartesJoueur2.length-i];
            //System.out.println("Joueur 1 tire :" +carteJoueur1.getCarte());
            //System.out.println("Joueur 2 tire :" +carteJoueur2.getCarte());
            if(carteJoueur1.getValeur()<carteJoueur2.getValeur()){
                //System.out.println("Joueur 2 gagne");
                compteurJoueur2++;
            }else {
                //System.out.println("Joueur 1 gagne");
                compteurJoueur1++;
            }
        }
        if(compteurJoueur1<compteurJoueur2){
            //System.out.println("Joueur 2 gagne la partie avec: " + compteurJoueur2 +" duels gagnants sur " + (compteurJoueur1+compteurJoueur2) + " duels");
            victoireJoueur2 ++;
        }else {
            //System.out.println("Joueur 1 gagne la partie avec: " + compteurJoueur1 +" duels gagnants sur " + (compteurJoueur1+compteurJoueur2) + " duels");
            victoireJoueur1++;
        }
    }
}


