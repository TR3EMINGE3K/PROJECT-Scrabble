// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe CaseDePlateau de notre jeu.
*/


public class CaseDePlateau{
        
        /**
        * Chaque case est constiutée d'une lettre et d'un type (mot ou lettre compte double etc.)
        */
        private Lettre lettre;
        private String type;

        /**
	    * Méthode qui permet d'obtenir la lettre de la case.
	    * @return lettre, la Lettre de la case.
	    */
        public Lettre getLettre(){
            return lettre;
        }    

        /**
	    * Méthode qui permet d'obtenir la lettre de la case.
	    * @return lettre, la Lettre de la case.
	    */
        public String getType(){
            return type;
        }    

        /**
	    * Constructeur de la case, il initialise la lettre. Son type est défini comme classique : il n'est donc pas un bonus.
	    */
        public CaseDePlateau(){
            this.lettre = new Lettre();
            this.type = "cl";
        }

        /**
        * Constructeur surchargé de CaseDePlateau(), il donne à la lettre de la case la lettre qui est en entrée. Son type est défini comme classique.
        * @param let , la Lettre qui va être donnée à la letre de case.
	    */
        public CaseDePlateau(Lettre let){
            this.lettre = let;
            this.type = "cl";
        }

        /**
        * Constructeur surchargé de CaseDePlateau(), il initialise la lettre. Son type est défini grâce à l'entrée.
        * @param str , le type qui va être donné à la classe.
	    */
        public CaseDePlateau(String str){
            this.lettre = new Lettre();
            this.type = str;
        }

        /**
        * Constructeur surchargé de CaseDePlateau(), il donne à la lettre de la case la lettre qui est en entrée. Son type est défini grâce à l'entrée.
        * @param str , le type qui va être donné à la classe.
        * @param let , la Lettre qui va être donnée à la letre de case.
	    */
        public CaseDePlateau(String str, Lettre let){
            this.lettre = let;
            this.type = str;
        }

        /**
        * Méthode permettant de construire une chaine de caractère représentant la case
        * @return la case crée.
	    */
        public String caseToString(){
            //L'intérieur de la case sera composé de deux charactères, afin qu'elles soient toutes de même taille.
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

                    //afin de vérifier si il y a une erreur dans le code
                    default :
                        return ("ERREUR");
                }
            }else{
                return ("|"+this.lettre.getCar()+" | ");
            }
        }
        
        /**
        * Méthode qui vérifie qu'une case est vide pour pouvoir y placer une lettre.
        * @return true ou false dépendant de l'état de la case. 
	    */
        public boolean estVide(){
            return (this.lettre.getCar()=='.');
        }
}