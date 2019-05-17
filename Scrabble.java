// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* Un jeu de Scrabble de 1 a 4 joueurs.
*/


public class Scrabble {



	
	/**
	* Affiche les scores et declare le vainqueur a la fin de la partie
	*
	* @param tabJoueurs , un tableau comportant tout les joueurs de la partie.
	* 
	*/
	public static void affichageFinDePartie(Joueur[] tabJoueurs){
		//recherche du vainqueur et affichage des scores

		/**
		* On dit que le scoreMax de base est a 0 ainsi que son indice.
		*/
		int scoreMax=0;
		int indiceMaxScore=0;


		for(int i =0;i<tabJoueurs.length;i++){
			Ecran.afficherln("\n La partie est finie ! \n");
			Ecran.afficherln("Le score de ",tabJoueurs[i].getNom()," est de ",tabJoueurs[i].getScore(), "points\n");
			if (tabJoueurs[i].getScore()>scoreMax){
				scoreMax=tabJoueurs[i].getScore();
				indiceMaxScore = i;
			}
		}
		Ecran.afficherln("\n Le grand gagnant est donc ",tabJoueurs[indiceMaxScore].getNom(),", Bravo!");
	}

	public static void main(String[] args) {

		//On cree un compteur de tour
		int compteurTour = 1;

		// On cree un sac de lettre
		SacDeLettres sac = new SacDeLettres();
		// on affiche les lettres contenue dans le sac de lettre
        //String strSac = sac.SacToString();
        // On cree un plateau 
		Plateau plateau = new Plateau();
		// on affiche ce plateau
		String strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);

		// On demande le Nombre de joueur.
		Joueur[] tabJoueurs = Joueur.creerJoueurs(sac);
		
		while(!sac.estVide()){
			for(int i=0;i<tabJoueurs.length;i++){
				// On affiche le chevalet du joueur : 
				Ecran.afficherln("Voici votre chevalet ",tabJoueurs[i].getNom());
				String strC = tabJoueurs[i].getChev().chevaletToString();
				Ecran.afficherln(strC);

				// on fait joueur le joueur
				tabJoueurs[i].placerLettres(sac,plateau,compteurTour);
				strPlateau = plateau.plateauToString();
				System.out.println(strPlateau);	
				// on remplis le chevalet du joueur qui a joue 
				tabJoueurs[i].getChev().remplirChevalet(sac);
				compteurTour++;
			}
		}

		strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);

		affichageFinDePartie(tabJoueurs);
		
	}
}
