public class Scrabble {
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
		int i;
        for(i=0;i<tabJoueurs.length;i++){
			tabJoueurs[i].placerLettres(sac,plateau);
			
		}
		String strC = tabJoueurs[i-1].chev.chevaletToString();
		Ecran.afficherln(strC);

		strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);
		
	}
}