import java.util.HashMap;
import java.util.Map;

public class Cartes {
        int valeur[]; // Valeur de la carte pour comparaison
        String[] type; // 2,3,....,valet, dame, roi
        String classe[]; //Coeur, Pique, Carreau, trèfle

        public Cartes() {
            valeur = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14};
            type = new String[]{"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
            classe = new String[]{"Coeur","Pique","Trèfle","Carreaux"};
            Map<Integer,String> cartesParValeur = new HashMap<>();
            int k = 0;
            for (String s : classe) {
                for (String value : type) {
                    cartesParValeur.put(k, value + " " + s);
                    k++;
                    System.out.println(cartesParValeur.toString());
                }
            }
        }
}


