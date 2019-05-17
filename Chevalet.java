// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe Chevalet de notre jeu.
*/

public class Chevalet {

	/**
	* La classe est consitutée d'un tableau de type Lettre
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
	* Méthode qui tire un entier au hasard entre 2 bornes.
	*
	* @param b1 , la borne inférieure
	* @param b2 , la borne supérieure 
	* @return L'entier tiré au sort entre b1 et b2.
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
	* Méthode qui construit la chaine de caractère pour afficher le chevalet.
	*
	* @return str, une chaîne de caractère représentant le chevalet
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
	* Méthode qui permet de remplir le chevalet de 7 lettres.
	*
	* @param S , un sac composé d'un certain nombre de lettres.
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
	* Méthode qui vérifie si une lettre choisie par l'utilisateur est bien dans son chevalet.
	*
	* @param car , le caractère saisit par l'utilisateur.
	* @return exists, le booléen qui va nous dire si la lettre existe dans le chevalet.
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
	* Méthode qui donne la position d'une lettre dans le chevalet.
	*
	* @param car , le caractère saisit par l'utilisateur.
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
	* Méthode qui va remplacer la lettre du chevalet par un '.'.
	*
	* @param indice , l'indice de la lettre qui se fera retirer.
	*/
    void retirerLettre(int indice){
        //la lettre est remplacée par un point
        chevalet[indice]=new Lettre();
    }

}