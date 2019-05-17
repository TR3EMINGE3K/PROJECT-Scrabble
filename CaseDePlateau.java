// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe CaseDePlateau de notre jeu.
*/


public class CaseDePlateau{
        
        /**
        * Chaque case est constiutee d'une lettre et d'un type (mot ou lettre compte double etc.)
        */
        private Lettre lettre;
        private String type;

        /**
	    * Methode qui permet d'obtenir la lettre de la case.
	    * @return lettre, la Lettre de la case.
	    */
        public Lettre getLettre(){
            return lettre;
        }    

        /**
	    * Methode qui permet d'obtenir la lettre de la case.
	    * @return lettre, la Lettre de la case.
	    */
        public String getType(){
            return type;
        }    

        /**
	    * Constructeur de la case, il initialise la lettre. Son type est defini comme classique : il n'est donc pas un bonus.
	    */
        public CaseDePlateau(){
            this.lettre = new Lettre();
            this.type = "cl";
        }

        /**
        * Constructeur surcharge de CaseDePlateau(), il donne a la lettre de la case la lettre qui est en entree. Son type est defini comme classique.
        * @param let , la Lettre qui va être donnee a la letre de case.
	    */
        public CaseDePlateau(Lettre let){
            this.lettre = let;
            this.type = "cl";
        }

        /**
        * Constructeur surcharge de CaseDePlateau(), il initialise la lettre. Son type est defini grâce a l'entree.
        * @param str , le type qui va être donne a la classe.
	    */
        public CaseDePlateau(String str){
            this.lettre = new Lettre();
            this.type = str;
        }

        /**
        * Constructeur surcharge de CaseDePlateau(), il donne a la lettre de la case la lettre qui est en entree. Son type est defini grâce a l'entree.
        * @param str , le type qui va être donne a la classe.
        * @param let , la Lettre qui va être donnee a la letre de case.
	    */
        public CaseDePlateau(String str, Lettre let){
            this.lettre = let;
            this.type = str;
        }

        /**
        * Methode permettant de construire une chaine de caractere representant la case
        * @return la case cree.
	    */
        public String caseToString(){
            //L'interieur de la case sera compose de deux characteres, afin qu'elles soient toutes de même taille.
            //si la "lettre" est un point (donc vide), on affichera une case vide avec le type de la case
            if (this.lettre.getCar() == '.'){
                switch (this.type){
                    //case classique
                    case "cl" :
                        return ("|  | ");
                    
                    //case lettre compte double
                    case "l2":
                        return ("|L2| ");

                    //case lettre compte triple
                    case "l3":
                        return ("|L3| ");

                    //case mot compte double
                    case "m2":
                        return ("|M2| ");

                    //case mot compte triple
                    case "m3":
                        return ("|M3| ");

                    //afin de verifier si il y a une erreur dans le code
                    default :
                        return ("ERREUR");
                }
            }else{
                return ("|"+this.lettre.getCar()+" | ");
            }
        }
        
        /**
        * Methode qui verifie qu'une case est vide pour pouvoir y placer une lettre.
        * @return true ou false dependant de l'etat de la case. 
	    */
        public boolean estVide(){
            return (this.lettre.getCar()=='.');
        }
}