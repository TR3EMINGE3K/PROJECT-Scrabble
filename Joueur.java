public class Joueur {

    // Chaque joueur possède un nom et score
    String nom;
    int score;
    Chevalet chev;

    // Chaque joueur possède son chevalet
    public Joueur(){
        this.nom = "";
        this.score = 0;
    }
    public Joueur(SacDeLettres S) {

        this.chev = new Chevalet();

        
        Ecran.afficher("veuillez entrer votre nom : ");
        this.nom = Clavier.saisirString();
        Ecran.afficherln("Bienvenue ",this.nom);
        Ecran.afficherln("Voilà votre Chevalet de lettres : ");

        // On remplis le chevalet du joueur
		this.chev.remplirChevalet(S);
        String strC = this.chev.chevaletToString();

        // on affiche le chevalet
		Ecran.afficherln(strC);

    }

    //création de n joueurs (jusqu'à 4)
    static Joueur[] creerJoueurs (SacDeLettres S){
        Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
        int n = Clavier.saisirInt();
        while ((n<1)||(n>4)){
            Ecran.afficher("erreur de saisie");
            Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
            n = Clavier.saisirInt();
        }
        //création du tableau de n joueurs
        Joueur[] tabJoueur= new Joueur[n];
        for (int i=0; i<n;i++){
            tabJoueur[i] =  new Joueur(S);
        }
        return (tabJoueur);
    }

    //Cette fonction transforme une minuscule en majuscule et laisse en majuscule si c'en est déjà le cas.
    //Le but est de ne pas compter la saisie d'une minuscule comme une erreur
    static char lettreEnMaj (char a){
        switch (a){
            case 'a':
            case 'A':
                a = 'A';
            case 'b':
            case 'B':
                a = 'B';
            case 'c':
            case 'C':
                a = 'C';
            case 'd':
            case 'D':
                a = 'D';
            case 'e':
            case 'E':
                a = 'E';
            case 'f':
            case 'F':
                a = 'F';
            case 'g':
            case 'G':
                a = 'G';
            case 'h':
            case 'H':
                a = 'H';
            case 'i':
            case 'I':
                a = 'I';
            case 'j':
            case 'J':
                a = 'J';
            case 'k':
            case 'K':
                a = 'K';
            case 'l':
            case 'L':
                a = 'L';
            case 'm':
            case 'M':
                a = 'M';
            case 'n':
            case 'N':
                a = 'N';
            case 'o':
            case 'O':
                a = 'O';
            case 'p':
            case 'P':
                a = 'P';
            case 'q':
            case 'Q':
                a = 'Q';
            case 'r':
            case 'R':
                a = 'R';
            case 's':
            case 'S':
                a = 'S';
            case 't':
            case 'T':
                a = 'T';
            case 'u':
            case 'U':
                a = 'U';
            case 'v':
            case 'V':
                a = 'V';
            case 'w':
            case 'W':
                a = 'W';
            case 'x':
            case 'X':
                a = 'X';
            case 'y':
            case 'Y':
                a = 'Y';
            case 'z':
            case 'Z':
                a = 'Z';
            default :
                a = '*';
        } 
        return a;
    }

    //Placement des lettres sur le plateau: Le joueur va choisir sa case de départ puis une direction. 
    //il pourra ensuite ajouter des lettres jusqu'à ce qu'il rencontre des cases non vides ou qu'il sorte du plateau.
    public void placerLettres (SacDeLettres sac, Plateau plat){
        char dir;

        //saisie de la position
        Ecran.afficher("Où voulez vous placer votre première lettre?\n");
        Ecran.afficher("Quelle ligne (0,1,2,3...)\n");
        int ligne= Clavier.saisirInt();
        Ecran.afficher("Quelle colonne (0,1,2,3...)\n");
        int colonne= Clavier.saisirInt();

        //vérification de la saisie de la position
        while((plat.tabPlateau[colonne][ligne].lettre.car != '.')||(ligne<0)||(colonne<0)||(ligne>14)||(ligne>14)){
            Ecran.afficher("Erreur, la case sélectionnée n'est pas valide\n");
            Ecran.afficher("Quelle ligne (0,1,2,3...)\n");
            ligne= Clavier.saisirInt();
            Ecran.afficher("Quelle colonne (0,1,2,3...)\n");
            colonne= Clavier.saisirInt();
        }
        Ecran.afficher("Quelle lettre voulez placer en ",ligne," ",colonne," ?\n");

        //saisie de la lettre
        char strLet = Clavier.saisirChar();
        char strLET = lettreEnMaj(strLet);
        Ecran.afficher (strLET);

        //vérification de la saisie de la lettre
        while (!(chev.lettreDansChevalet(strLET))){
            Ecran.afficher("La lettre demandée ne se situe pas dans votre chevalet\n");
            Ecran.afficher ("veuillez saisir une lettre disponible dans votre chevalet\n");
            strLet = Clavier.saisirChar();
            strLET = lettreEnMaj(strLet);
        }

        //placement de la lettre sur le plateau et retirement de la lettre du chevalet
        plat.placerLettre(strLET,ligne,colonne);
        chev.retirerLettre(chev.positionDansChevalet(strLET));

    }

}   