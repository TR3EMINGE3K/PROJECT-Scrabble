public class Scrabble {
	public static void main(String[] args) {

		// On crée un sac de lettre
		SacDeLettres sac = new SacDeLettres();
		// on affiche les lettres contenue dans le sac de lettre
        String strSac = sac.SacToString();
        
        	// On crée un plateau 
		Plateau plateau = new Plateau();
		// on affiche ce plateau
		String strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);

		Ecran.afficherln(strSac);
		// on crée un joueur.
		Joueur[] tabJoueurs = Joueur.creerJoueurs(sac);
		//strSac = sac.SacToString();
        //Ecran.afficherln(strSac);
        for(int i=0;i<tabJoueurs.length;i++){
            tabJoueurs[i].placerLettres(sac,plateau);
        }
	}
}