/**
* Un jeu de scrabble de 2 à 4 joueurs
*/


public class Scrabble {
	
	/**
	* Type agrégé pour le sac, un sac est constitué d'un nombre de lettre
	*/
	static class Sac {
		int nombreLettre;
	}
	
	/**
	* Type agrégé pour le Joueur, un joueur possède un nom, un chevalet et un score
	*/
	static class Joueur {
		String nom;
		Chevalet chevalet;
		int score;
	}
	
	/**
	* Type agrégé pour le Chevalet, un chevalet est constitué d'un nombre de 
	* lettre inférieur ou égal à 7
	*/
	static class Chevalet {
		char... lettre;
	}
	
	/**
	* Fonction pour créer le Sac, elle va donner 100 lettres
	*/
	static Sac creationSac{
		Sac sacPartie = new Sac();
		sacPartie.nombreLettre = 100;
		return sacPartie;
	}
}
	
	