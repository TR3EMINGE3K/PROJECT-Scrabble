// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe SacDeLettres de notre jeu.
*/

public class SacDeLettres {

    /**
    * Elle est composee d'un tableau de type Lettre. 
    */
    private Lettre[] sac;

    /**
	* Methode qui permet d'obtenir le tableau de lettres.
	* @return sac, le tableau de lettres.
	*/
    public Lettre[] getSac(){
        return sac;
    }    

    /**
    * Le constructeur du sac, il l'initialise en le remplissant avec 100 lettres fideles aux regles du jeu.
	*/
    public SacDeLettres() {
        sac = new Lettre[100];

        int i;
        for (i = 0; i < 15; i++) {
            sac[i] = new Lettre('E');
        }
        for (i = 15; i < 24; i++) {
            sac[i] = new Lettre('A');
        }
        for (i = 24; i < 32; i++) {
            sac[i] = new Lettre('I');
        }
        for (i = 32; i < 38; i++) {
            sac[i] = new Lettre('N');
        }
        for (i = 38; i < 44; i++) {
            sac[i] = new Lettre('O');
        }
        for (i = 44; i < 50; i++) {
            sac[i] = new Lettre('R');
        }
        for (i = 50; i < 56; i++) {
            sac[i] = new Lettre('S');
        }
        for (i = 56; i < 62; i++) {
            sac[i] = new Lettre('T');
        }
        for (i = 62; i < 68; i++) {
            sac[i] = new Lettre('U');
        }
        for (i = 68; i < 73; i++) {
            sac[i] = new Lettre('L');
        }
        for (i = 73; i < 76; i++) {
            sac[i] = new Lettre('D');
        }
        for (i = 76; i < 79; i++) {
            sac[i] = new Lettre('M');
        }
        for (i = 79; i < 81; i++) {
            sac[i] = new Lettre('B');
        }
        for (i = 81; i < 83; i++) {
            sac[i] = new Lettre('C');
        }
        for (i = 83; i < 85; i++) {
            sac[i] = new Lettre('F');
        }
        for (i = 85; i < 87; i++) {
            sac[i] = new Lettre('G');
        }
        for (i = 87; i < 89; i++) {
            sac[i] = new Lettre('H');
        }
        for (i = 89; i < 91; i++) {
            sac[i] = new Lettre('P');
        }
        for (i = 91; i < 93; i++) {
            sac[i] = new Lettre('V');
        }
        for (i = 93; i < 94; i++) {
            sac[i] = new Lettre('J');
        }
        for (i = 94; i < 95; i++) {
            sac[i] = new Lettre('K');
        }
        for (i = 95; i < 96; i++) {
            sac[i] = new Lettre('Q');
        }
        for (i = 96; i < 97; i++) {
            sac[i] = new Lettre('W');
        }
        for (i = 97; i < 98; i++) {
            sac[i] = new Lettre('X');
        }
        for (i = 98; i < 99; i++) {
            sac[i] = new Lettre('Y');
        }
        for (i = 99; i < 100; i++) {
            sac[i] = new Lettre('Z');
        }
    }

    /**
	* Methode qui permet de supprimer un caractere si il a ete pioche.
	* @param indiceSac , l'indice du caractere que l'on veut supprimer.
	*/
    public void viderSac(int indiceSac) {
        this.sac[indiceSac].setCar('.');
    }

    /**
	* Methode qui permet de savoir si le sac est vide.
	* @return true ou false en fonction de l'etat du sac.
	*/
    public boolean estVide(){
        for (int i = 0; i<100;i++){
            if (this.sac[i].getCar() !='.'){
                return false; 
            }

        }
        return true;
    }

    /**
    * Methode qui permet de construire une chaine de caractere qui affiche le sac.(Methode utilisee au debut de notre projet pour savoir si le sac se vidait bien etc. 
    * Elle n'est plus utilisee.).
	* @return str, la chaine de caractere representant les lettres du sac. 
	*/
    String SacToString() {
        String str = " ";
        for (int i = 0; i < 100; i++) {
            str = str + sac[i].getCar();
        }
        return str;
    }

}


