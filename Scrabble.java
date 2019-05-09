public class Scrabble {

	//affiche les scores et déclare le vainqueur à la fin de la partie
	public void affichageFinDePartie(Joueur[] tabJoueurs){
		//recherche du vainqueur et affichage des scores
		int scoreMax=0;
		int indiceMaxScore=0;
		for(int i =0;i<tabJoueurs.length;i++){
			Ecran.afficherln("\n La partie est finie ! \n");
			Ecran.afficherln("Le score de ",tabJoueurs[i].nom," est de ",tabJoueurs[i].score, "points\n");
			if (tabJoueurs[i].score>scoreMax){
				scoreMax=tabJoueurs[i].score;
				indiceMaxScore = i;
			}
		}
		Ecran.afficherln("\n Le grand gagnant est donc ",tabJoueurs[indiceMaxScore].nom,", Bravo!");
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
		while(!sac.estVide()){
			for(int i=0;i<tabJoueurs.length;i++){
				// On affiche le chevalet du joueur : 
				Ecran.afficherln("Voici votre chevalet ",tabJoueurs[i].nom);
				String strC = tabJoueurs[i].chev.chevaletToString();
				Ecran.afficherln(strC);

				// on fait joueur le joueur
				tabJoueurs[i].placerLettres(sac,plateau,compteurTour);
				strPlateau = plateau.plateauToString();
				System.out.println(strPlateau);	
				// on remplis le chevalet du joueur qui a joué 
				tabJoueurs[i].chev.remplirChevalet(sac);
				compteurTour++;
			}
		}
			/*String strC = tabJoueurs[i-1].chev.chevaletToString();
			Ecran.afficherln(strC);*/

		strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);
		
	}
}