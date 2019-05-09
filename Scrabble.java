public class Scrabble {

	//affiche les scores et déclare le vainqueur à la fin de la partie
	public void affichageFinDePartie(Joueur[] tabJoueurs){
		//recherche du vainqueur et affichage des scores
		int scoreMax=0;
		int indiceMaxScore=0;
		for(int i =0;i<tabJoueurs.length;i++){
			Ecran.afficher ("\n La partie est finie ! \n");
			Ecran.afficher("Le score de ",tabJoueurs[i].nom," est de ",tabJoueurs[i].score, "points\n");
			if (tabJoueurs[i].score>scoreMax){
				scoreMax=tabJoueurs[i].score;
				indiceMaxScore = i;
			}
		}
		Ecran.afficher("\n Le grand gagnant est donc ",tabJoueurs[indiceMaxScore].nom,", Bravo!");
	}
	public static void main(String[] args) {

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
				tabJoueurs[i].placerLettres(sac,plateau);
				strPlateau = plateau.plateauToString();
				System.out.println(strPlateau);	
			}
		}
			/*String strC = tabJoueurs[i-1].chev.chevaletToString();
			Ecran.afficherln(strC);*/

		strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);
		
	}
}