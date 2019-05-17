// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe Plateau de notre jeu.
*/


public class Plateau{

        /**
        * Un plateau est forme d'un tableau a 2 dimensions de type CaseDePlateau
        */
        private CaseDePlateau[][] tabPlateau;

        /**
        * Methode permettant d'obtenir le tableau du Plateau.
        * @return tabPlateau, le tableau du Plateau.
        */
        public CaseDePlateau[][] getTabPlateau(){
            return tabPlateau;
        }    


        /**
	    * Constructeur du plateau, il initialise le tableau comme etant un tableau de 15x15. Il remplit ensuite chaque case de ce plateau fidelement aux regles.
	    */
        public Plateau(){
            tabPlateau=  new CaseDePlateau[15][15];
            //i correspond a la colonne et j a la ligne.
            int i, j;

            for (i=0;i<15;i++){
                for(j=0;j<15;j++){
                    //premiere et derniere ligne
                    if ((j==0)||(j==14)){
                        switch (i){
                            case 0:
                            case 7:
                            case 14:
                                tabPlateau[i][j]= new CaseDePlateau("m3");
                            break;

                            case 3:
                            case 11:
                                tabPlateau[i][j]= new CaseDePlateau("l2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }
                    
                    //deuxieme et 14eme ligne
                    if((j==1)||(j==13)){
                        switch (i){
                            case 1:
                            case 13:
                                tabPlateau[i][j]= new CaseDePlateau("m2");
                            break;

                            case 4:
                            case 9:
                                tabPlateau[i][j]= new CaseDePlateau("l3");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                    //3eme et 13eme ligne
                    if((j==2)||(j==12)){
                        switch (i){
                            case 2:
                            case 12:
                                tabPlateau[i][j]= new CaseDePlateau("m2");
                            break;

                            case 6:
                            case 8:
                                tabPlateau[i][j]= new CaseDePlateau("l2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }
                    
                    //4eme et 12eme ligne
                    if((j==3)||(j==11)){
                        switch (i){
                            case 0:
                            case 14:
                                tabPlateau[i][j]= new CaseDePlateau("l2");
                            break;

                            case 3:
                            case 11:
                                tabPlateau[i][j]= new CaseDePlateau("m2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                    //5eme et 11eme ligne
                    if((j==4)||(j==10)){
                        switch (i){
                            case 4:
                            case 10:
                                tabPlateau[i][j]= new CaseDePlateau("m2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                    //6eme et 10eme ligne
                    if((j==5)||(j==9)){
                        switch (i){
                            case 1:
                            case 5:
                            case 9:
                            case 13:
                                tabPlateau[i][j]= new CaseDePlateau("l3");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                    //7eme et 9eme ligne
                    if((j==6)||(j==8)){
                        switch (i){
                            case 2:
                            case 6:
                            case 8:
                            case 12:
                                tabPlateau[i][j]= new CaseDePlateau("l2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                    //8eme ligne
                    if(j==7){
                        switch (i){
                            case 0:
                            case 14:
                                tabPlateau[i][j]= new CaseDePlateau("m3");
                            break;

                            case 7:
                                tabPlateau[i][j]= new CaseDePlateau("m2");
                            break;

                            default:
                                tabPlateau[i][j]= new CaseDePlateau(); 
                            break;
                        }
                    }

                }
            }
        }
        /**
        * Methode permettant de construire une chaine de caractere representant le plateau.
        * @return str, la chaine qui represente le plateau .
	    */
        public String plateauToString(){
            String str= "";
            for (int i =0;i<10;i++){
                str= str+" "+ i+ "  <";
                for (int j =0;j<15;j++){
                    str = str + tabPlateau[i][j].caseToString();
                } 
                str=str+"\n";
            }
            for (int i =10;i<15;i++){
                str= str+ i+ "  <";
                for (int j =0;j<15;j++){
                    str = str + tabPlateau[i][j].caseToString();
                } 
                str=str+"\n";
            }
            str=str+"\n";
            str=str+"     ";
            for (int i =0; i<10;i++){
                str=str +"| "+i+"| ";
            }
            for (int i =10; i<15;i++){
                str=str +"|"+i+"| ";
            }
            str=str+"\n";
            return str;
        }

        /**
        * Methode permettant de placer une lettre sur le plateau
        * @param ltr , le caractere qui sera affiche
        * @param colonne , la colonne du tableau qui represente le plateau.
        * @param ltr , la ligne du tableau qui represente le plateau.
	    */
        public void placerLettre(char ltr, int colonne, int ligne){
            this.tabPlateau[colonne][ligne]= new CaseDePlateau(new Lettre(ltr));
        }
}