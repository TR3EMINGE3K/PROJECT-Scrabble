// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* Un jeu de Scrabble de 1 à 4 joueurs.
*/


public class Scrabble {

	/*static class position{
		int colonne;
		int ligne;
	}

	//tableau qui prend les positions des lettres du mot qui est en train d'être inséré dans le plateau.
	position[] posMotActuel = new position[7];

	//initialisation de ce tableau
	//on initialise avec des valeurs imposibles à obtenir en plaçant les lettres
	public static void initialisationTabPosMot (position[] posMotActuel){
		for(int i = 0; i<7 ; i++){
			posMotActu[i].colonne = 20;
			posMotActu[i].ligne = 20;
		}
	}	*/
	


	
	/**
	* Affiche les scores et déclare le vainqueur à la fin de la partie
	*
	* @param tabJoueurs , un tableau comportant tout les joueurs de la partie.
	* 
	*/
	public static void affichageFinDePartie(Joueur[] tabJoueurs){
		//recherche du vainqueur et affichage des scores

		/**
		* On dit que le scoreMax de base est à 0 ainsi que son indice.
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

		//On crée un compteur de tour
		int compteurTour = 1;

		// On crée un sac de lettre
		SacDeLettres sac = new SacDeLettres();
		// on affiche les lettres contenue dans le sac de lettre
        //String strSac = sac.SacToString();
        // On crée un plateau 
		Plateau plateau = new Plateau();
		// on affiche ce plateau
		String strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);

		// On demande le Nombre de joueur.
		Joueur[] tabJoueurs = Joueur.creerJoueurs(sac);
		//Ecran.afficherln(strSac);
		//int i;
		//while(!sac.estVide()){
		int adad=1;
		while(adad<3){
			for(int i=0;i<tabJoueurs.length;i++){
				// On affiche le chevalet du joueur : 
				Ecran.afficherln("Voici votre chevalet ",tabJoueurs[i].getNom());
				String strC = tabJoueurs[i].getChev().chevaletToString();
				Ecran.afficherln(strC);

				// on fait joueur le joueur
				tabJoueurs[i].placerLettres(sac,plateau,compteurTour);
				strPlateau = plateau.plateauToString();
				System.out.println(strPlateau);	
				// on remplis le chevalet du joueur qui a joué 
				tabJoueurs[i].getChev().remplirChevalet(sac);
				compteurTour++;
			}adad++;
		}
			/*String strC = tabJoueurs[i-1].chev.chevaletToString();
			Ecran.afficherln(strC);*/

		strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);

		affichageFinDePartie(tabJoueurs);
		
	}
}