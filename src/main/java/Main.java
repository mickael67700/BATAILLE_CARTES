public class Main {
    public static void main(String[]args){
        int VictoireJoueur1 =0;
        int VictoireJoueur2 =0;
       for(int i = 0 ; i<=100; i++){
           Carte carte = new Carte();
           carte.constructionJeuDeCartes();
           carte.distributionCartes();
           carte.joue();
          if(carte.getVictoireJoueur1()==1){
              VictoireJoueur1++;
          }
           if(carte.getVictoireJoueur2()==1){
               VictoireJoueur2++;
           }
       }
       System.out.println("Joueur 1 :" +VictoireJoueur1 + " victoires");
       System.out.println("Joueur 2 :" +VictoireJoueur2 + " victoires");
    }
}
