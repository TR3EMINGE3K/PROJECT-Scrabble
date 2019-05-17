// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe Chevalet de notre jeu.
*/

public class Chevalet {

	/**
	* La classe est consitutee d'un tableau de type Lettre
	*/
	private Lettre[] chevalet;

	/**
	* Permettre d'obtenir le chevalet puisqu'il est en private.
	*
	* @return chevalet , il retourne le chevalet de la classe.
	* 
	*/
	public Lettre[] getChevalet(){
		return chevalet;
	}    

	/**
	* Methode qui tire un entier au hasard entre 2 bornes.
	*
	* @param b1 , la borne inferieure
	* @param b2 , la borne superieure 
	* @return L'entier tire au sort entre b1 et b2.
	*/
	static int hasardo(int b1, int b2) {
		return ((int) (Math.random() * (b2 - b1 + 1)) + b1);
	}

	/**
	* Le constructeur du Chevalet.
	*/
	Chevalet() {
		this.chevalet = new Lettre[7];
		for (int i = 0; i < 7; i++) {
			this.chevalet[i] = new Lettre();
		}
	}

	/**
	* Methode qui construit la chaine de caractere pour afficher le chevalet.
	*
	* @return str, une chaîne de caractere representant le chevalet
	*/
	String chevaletToString() {
		String str = ("[");
		for (int i = 0; i < 7; i++) {
			str = str + " " + chevalet[i].getCar();
		}
		str = str + "]";
		return str;
	}

	/**
	* Methode qui permet de remplir le chevalet de 7 lettres.
	*
	* @param S , un sac compose d'un certain nombre de lettres.
	*/
	void remplirChevalet(SacDeLettres S) {
		int indiceSac = 0;
		if(!S.estVide()){
			for (int i = 0; i < 7; i++) {
				if (chevalet[i].getCar() == '.') {
					indiceSac = hasardo(0, 99);
					if (S.getSac()[indiceSac].getCar() == '.') {
						remplirChevalet(S);
					} else {
						chevalet[i] = new Lettre(S.getSac()[indiceSac].getCar());
						S.viderSac(indiceSac);
						
					}
				}
			}

		}

    }
    
    /**
	* Methode qui verifie si une lettre choisie par l'utilisateur est bien dans son chevalet.
	*
	* @param car , le caractere saisit par l'utilisateur.
	* @return exists, le booleen qui va nous dire si la lettre existe dans le chevalet.
	*/
    boolean lettreDansChevalet(char car){
        boolean exists= false;
        for (int i=0; i<chevalet.length;i++){
            if (car == chevalet[i].getCar()){
                exists = true;
            }
        }
        return exists;
    }

    /**
	* Methode qui donne la position d'une lettre dans le chevalet.
	*
	* @param car , le caractere saisit par l'utilisateur.
	* @return un entier qui indique sa place dans le chevalet.
	*/
    int positionDansChevalet(char car){
        for (int i=0; i<chevalet.length;i++){
            if (car == chevalet[i].getCar()){
                return (i);
            }
        }
        return (-1);
    }

    /**
	* Methode qui va remplacer la lettre du chevalet par un '.'.
	*
	* @param indice , l'indice de la lettre qui se fera retirer.
	*/
    void retirerLettre(int indice){
        //la lettre est remplacee par un point
        chevalet[indice]=new Lettre();
    }

}