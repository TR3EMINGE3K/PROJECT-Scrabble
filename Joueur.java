public class Joueur {

    // Chaque joueur possède un nom et score
    String nom;
    int score;

    // Chaque joueur possède son chevalet
    public Joueur(){
        this.nom = "";
        this.score = 0;
    }
    public Joueur(SacDeLettres S) {

        Chevalet chev = new Chevalet();

        
        Ecran.afficher("veuillez entrer votre nom : ");
        this.nom = Clavier.saisirString();
        Ecran.afficherln("Bienvenue ",nom);
        Ecran.afficherln("Voilà votre Chevalet de lettres : ");

        // On remplis le chevalet du joueur
		chev.remplirChevalet(S);
        String strC = chev.chevaletToString();

        // on affiche le chevalet
		Ecran.afficherln(strC);

    }

}