public class CaseDePlateau{
        //chaque case sera remplie par une lettre. Au début, la lettre des case est initialisée à '.', et ne sera pas affiché.
        public Lettre lettre;

        // le type de la case correspond au fait qu'elle soit classique(cl), mot compte double(m2), lettre triple(l3)...
        public String type;

        public CaseDePlateau(){
            this.lettre = new Lettre();
            this.type = "cl";
        }

        public CaseDePlateau(Lettre let){
            this.lettre = let;
            this.type = "cl";
        }

        public CaseDePlateau(String str){
            this.lettre = new Lettre();
            this.type = str;
        }

        
        public CaseDePlateau(String str, Lettre let){
            this.lettre = let;
            this.type = str;
        }

        public String caseToString(){
            //L'intérieur de la case sera composé de deux charactères, afin qu'elles soient toutes de même taille.
            //si la "lettre" est un point (donc vide), on affichera une case vide avec le type de la case
            if (this.lettre.car == '.'){
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
                return ("|"+this.lettre.car+" | ");
            }
        }
}