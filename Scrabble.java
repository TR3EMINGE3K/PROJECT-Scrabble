public class Scrabble {
	public static void main(String[] args) {

		// On crée un sac de lettre
		SacDeLettres sac = new SacDeLettres();
		// on affiche les lettres contenue dans le sac de lettre
		String strSac = sac.SacToString();
		Ecran.afficherln(strSac);
		// on crée un joueur.
		Joueur joueur1 = new Joueur(sac);


		strSac = sac.SacToString();
		Ecran.afficherln(strSac);
		// On crée un plateau 
		Plateau plateau = new Plateau();
		// on affiche ce plateau
		String strPlateau = plateau.plateauToString();
		System.out.println(strPlateau);
	}
}