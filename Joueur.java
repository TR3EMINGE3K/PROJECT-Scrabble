// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe Joueur de notre jeu.
*/

public class Joueur {

    /**
    * Un joueur possede un nom, un score et un chevalet.
    */
    private String nom;
    private int score;
    private Chevalet chev;

    /**
    * Methode permettant de recuperer le nom du joueur.
    * @return nom, le nom du joueur.
    */
    public String getNom(){
        return nom;
    }

    /**
    * Methode permettant de recuperer le score du joueur.
    * @return score, le score du joueur.
    */
    public int getScore(){
        return score;
    }

    /**
    * Methode permettant de recuperer le chevalet du joueur.
    * @return chev, le chevalet du joueur.
    */
    public Chevalet getChev(){
        return chev;
    }

    /**
    * Constructeur qui initialise le nom comme etant une chaine vide et le score a 0.
    */
    public Joueur() {
        this.nom = "";
        this.score = 0;
    }

    /**
    * Constructeur surcharge qui demande la saisie du nom et qui va remplir le chevalet grâce au sac en entree
    * @param S , le sac qui va permettre de remplir le chevalet. 
    */
    public Joueur(SacDeLettres S) {

        this.chev = new Chevalet();

        Ecran.afficher("veuillez entrer votre nom : ");
        this.nom = Clavier.saisirString();
        Ecran.afficherln("Bienvenue ", this.nom);

        // On remplis le chevalet du joueur
        this.chev.remplirChevalet(S);

    }

    /**
    * Methode permettant de creer le nombre de joueurs.
    * @param S , le sac qui va permettre de remplir le chevalet de chaque joueur.
    * @return tabJoueur le tableau remplis du nombre de joueur saisi par l'utilisateur. 
    */
    static Joueur[] creerJoueurs(SacDeLettres S) {
        Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
        int n = Clavier.saisirInt();
        while ((n < 1) || (n > 4)) {
            Ecran.afficher("erreur de saisie");
            Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
            n = Clavier.saisirInt();
        }
        // creation du tableau de n joueurs
        Joueur[] tabJoueur = new Joueur[n];
        for (int i = 0; i < n; i++) {
            tabJoueur[i] = new Joueur(S);
        }
        return (tabJoueur);
    }


    /**
    * Methode permettant de transformer une minuscule en majuscule. elle consiste a permettre a l'utilisateur de rentrer une lettre en minuscule ou en majuscule et d'être bien detectee.
    * @param a , le caractere que l'on veut mettre en majuscule.
    * @return b, le caractere changer en majuscule.
    */
    static char lettreEnMaj(char a) {
        char b;
        b = Character.toUpperCase(a);
        return b;
    }


    /**
    * Methode permettant placer des lettres sur le plateau : Le joueur va choisir sa case de depart
    * @param sac , le sac qui permettra de remplir de nouveau le chevalet.
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param compteurTour , le compteur qui permet de savoir a quels tour on est (utile que pour le 1er tour.)
    */
    public void placerLettres( SacDeLettres sac, Plateau plat, int compteurTour) {
        char dir;
        int scoreLettre = 0;

        Boolean motDouble = false;
        Boolean motTriple = false;
        boolean motQuadruple = false;

        // saisie de la position
        if (compteurTour == 1) {
            /*//indique qu'une lettre de ce mot se trouve en 7,7
            posMotActu[0].colonne = 7;
            posMotActu[0].ligne = 7;
*/
            motDouble=true;
            Ecran.afficher("Quelle lettre voulez placer en (7,7) ", nom, " ?\n");
            // saisie de la lettre
            char strLet = Clavier.saisirChar();
            char strLET = lettreEnMaj(strLet);
            // verification de la saisie de la lettre
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandee ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);
            }

            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            // et ajout du score lettre par lettre
            scoreLettre = (ajoutScore(plat, strLET, 7, 7));
            plat.placerLettre(strLET, 7, 7);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // On demande au joueur ou veut il placer la lettre suivante
            Ecran.afficherln(
                    "Dans quelle direction voulez vous ecrire votre mot ? \nTapez 'b' pour ecrire en bas et 'd' pour ecrire a droite");
            dir = Clavier.saisirChar();
            char dire = lettreEnMaj(dir);
            switch (dire) {
            case 'B':
                placerLettresBas(plat, 7, 7, scoreLettre,motDouble,motTriple,motTriple);
                break;

            case 'D':
                placerLettresDroite(plat, 7, 7, scoreLettre,motDouble,motTriple,motTriple);
                break;
            }
        } else {
            Ecran.afficher("Ou voulez vous placer votre premiere lettre ", nom, " ?\n");
            Ecran.afficher("Quelle Colonne (0,1,2,3...)\n");
            int colonne = Clavier.saisirInt();
            Ecran.afficher("Quelle Ligne (0,1,2,3...)\n");
            int ligne = Clavier.saisirInt();

            // verification de la saisie de la position
            while ((plat.getTabPlateau()[ligne][colonne].getLettre().getCar() != '.') || (ligne < 0) || (colonne < 0) || (colonne > 14)
                    || (ligne > 14) && ((plat.getTabPlateau()[ligne + 1][colonne].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne - 1][colonne].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne][colonne + 1].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne][colonne - 1].getLettre().getCar() != '.'))) {
                Ecran.afficher("Erreur, la case selectionnee n'est pas valide\n");
                Ecran.afficher("Quelle ligne (0,1,2,3...)\n");
                ligne = Clavier.saisirInt();
                Ecran.afficher("Quelle colonne (0,1,2,3...)\n");
                colonne = Clavier.saisirInt();

            }
            Ecran.afficher("Quelle lettre voulez placer en (", colonne, ",", ligne, ") ", nom, " ?\n");

            // saisie de la lettre
            char strLet = Clavier.saisirChar();
            char strLET = lettreEnMaj(strLet);

            // verification de la saisie de la lettre
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandee ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);
            }

            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            // et ajout du score lettre par lettre
            scoreLettre = (ajoutScore(plat, strLET, colonne, ligne));
            plat.placerLettre(strLET, ligne, colonne);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // On demande au joueur ou veut il placer la lettre suivante
            Ecran.afficherln(
                    "Dans quelle direction voulez vous ecrire votre mot ? \nTapez 'b' pour ecrire en bas et 'd' pour ecrire a droite \nTapez 'f' si votre mot est fini");
            dir = Clavier.saisirChar();
            char dire = lettreEnMaj(dir);
            switch (dire) {
            case 'B':
                placerLettresBas(plat, colonne, ligne, scoreLettre, motDouble, motTriple, motQuadruple);
                break;

            case 'D':
                placerLettresDroite(plat, colonne, ligne, scoreLettre, motDouble, motTriple, motQuadruple);
                break;

            case 'F':
                Ecran.afficherln("C'est la fin de votre tour");
                // on applique le bonus au mot une fois finis
                if (motDouble) {
                    scoreLettre = scoreLettre * 2;
                } else if (motTriple) {
                    scoreLettre = scoreLettre * 3;
                } else if (motQuadruple) {
                    scoreLettre = scoreLettre * 4;
                }
                Ecran.afficherln("Voila ton score ", nom, " : ", scoreLettre);
                break;
            }

        }
        
    }

    /**
    * Methode permettant placer des lettres sur le plateau vers le bas (il faut que l'utilisateur choissise si il veut ecrire vers le bas)
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la 1ere lettre posee.
    * @param ligne , la ligne de la 1ere lettre posee.
    * @param scoreLettre , le score cumule par les lettres posees
    * @param motDouble , un booleen qui permet de savoir si le mot en construction est deja un mot double. 
    * @param motTriple , un booleen qui permet de savoir si le mot en construction est deja un mot triple. 
    * @param motQuadruple , un booleen qui permet de savoir si le mot en construction est deja un mot quadruple 
    *
    */
    public void placerLettresBas(Plateau plat, int colonne, int ligne, int scoreLettre, boolean motDouble,
                boolean motTriple,boolean motQuadruple) {
        boolean motBienPlace = false;
        Boolean finMot = false;

        Ecran.afficherln("Vous avez decide d'ecrire votre mot vers le bas");
        
        int compteur = 1;
        while ((finMot == false) && (compteur < 6) && (ligne < 14)) {
            
            ligne++;
            boolean estVide = false;
            while (estVide==false){
                if (!(plat.getTabPlateau()[colonne][ligne].estVide())){
                    ligne++;
                    
                }
                else {
                    estVide = true;
                }
            }
            
        
            // on verifie qu'il y a mot compte double, compte triple ou compte quadruple
            if (estMotDouble(plat, colonne, ligne)){
                if  (!motDouble){ 
                motDouble = true;
                }else{
                    motQuadruple = true;
                }
            }
            if (estMotTriple(plat, colonne, ligne)) {
                motTriple = true;
            }

            Ecran.afficherln("Quelle lettre voulez vous placer en (", colonne, ",", ligne, ")", nom, " ?");

            // on Saisi une lettre
            char strLet = Clavier.saisirChar();
            char strLET = lettreEnMaj(strLet);
            Ecran.afficherln(strLET);

            // on verifie que la lettre soit bien dans le chevalet du joueur
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandee ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);

            }
            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            scoreLettre = scoreLettre + (ajoutScore(plat, strLET, colonne, ligne));
            plat.placerLettre(strLET, ligne, colonne);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // Demande de l'action suivante
            switch (ligne) {
            case 14:
                finMot = true;
                break;
            default:
                Ecran.afficherln("Votre mot est-il fini ?\n Tapez 'o' pour oui et 'n' pour non : ");
                char choix = Clavier.saisirChar();
                if (choix == 'o') {
                    finMot = true;
                }
                break;

            }

        }
        // on applique le bonus au mot une fois finis
        if (motDouble) {
            scoreLettre = scoreLettre * 2;
        } else if (motTriple) {
            scoreLettre = scoreLettre * 3;
        } else if (motQuadruple) {
            scoreLettre = scoreLettre * 4;
        }
        Ecran.afficherln("Voila ton score ", nom, " ", scoreLettre);
        this.score=this.score+scoreLettre;
    }

    /**
    * Methode permettant placer des lettres sur le plateau vers le bas (il faut que l'utilisateur choissise si il veut ecrire vers la droite)
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la 1ere lettre posee.
    * @param ligne , la ligne de la 1ere lettre posee.
    * @param scoreLettre , le score cumule par les lettres posees
    * @param motDouble , un booleen qui permet de savoir si le mot en construction est deja un mot double. 
    * @param motTriple , un booleen qui permet de savoir si le mot en construction est deja un mot triple. 
    * @param motQuadruple , un booleen qui permet de savoir si le mot en construction est deja un mot quadruple 
    *
    */
    public void placerLettresDroite(Plateau plat, int colonne, int ligne, int scoreLettre, boolean motDouble,
    boolean motTriple,boolean motQuadruple) {

        Boolean finMot = false;

        Ecran.afficherln("Vous avez decide d'ecrire votre mot vers la droite");
        int compteur = 1;
        while ((finMot == false) && (compteur < 6) && (colonne < 14)) {
            colonne++;
            
            if (estMotDouble(plat, colonne, ligne)){
                if  (!motDouble){ 
                motDouble = true;
                }else{
                    motQuadruple = true;
                }
            }
            if (estMotTriple(plat, colonne, ligne)) {
                motTriple = true;
            }

            Ecran.afficherln("Quelle lettre voulez vous placer en (", colonne, ",", ligne, ")", nom, " ?");

            // on Saisi une lettre
            char strLet = Clavier.saisirChar();
            char strLET = lettreEnMaj(strLet);
            Ecran.afficherln(strLET);

            // on verifie que la lettre soit bien dans le chevalet du joueur
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandee ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);

            }
            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            scoreLettre = scoreLettre + (ajoutScore(plat, strLET, colonne, ligne));
            //scoreLettre = scoreLettre
                    //+ pointsMotHautBas(plat, colonne, ligne, plat.tabPlateau[colonne][ligne].lettre.points);
            plat.placerLettre(strLET, ligne, colonne);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // Demande de l'action suivante
            switch (colonne) {
            case 14:
                finMot = true;
                break;
            default:
                Ecran.afficherln("Votre mot est-il fini ?\n Tapez 'o' pour oui et 'n' pour non : ");
                char choix = Clavier.saisirChar();
                if (choix == 'o') {
                    finMot = true;
                }
                break;

            }

        }
        // on applique le bonus au mot une fois finis
        if (motDouble) {
            scoreLettre = scoreLettre * 2;
        } else if (motTriple) {
            scoreLettre = scoreLettre * 3;
        } else if (motQuadruple) {
            scoreLettre = scoreLettre * 4;
        }
        Ecran.afficherln("Voila ton score ", nom, " : ", scoreLettre);
        this.score=this.score+scoreLettre;
    }


    /**
    * Methode permettant d'ajouter le score de la lettre qui est en parametre 
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param strLET , une lettre posee par le joueur.
    * @param colonne , la colonne de la lettre en parametre.
    * @param ligne , la ligne de la lettre en parametre.
    * @return scor, le score de la lettre qu'il faudra ajouter.
    */
    public int ajoutScore(Plateau plat, char strLET, int colonne, int ligne) {
        Lettre letra = new Lettre(strLET);
        int scor;

        if (estDouble(plat, colonne, ligne)) {
            scor = letra.getPoints() * 2;
        } else if (estTriple(plat, colonne, ligne)) {
            scor = letra.getPoints() * 3;
        } else {
            scor = letra.getPoints();
        }

        return (scor);

    }




    /**
    * Methode booleenne permettant de savoir une case est comptee comme lettre compte double.
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la lettre en parametre.
    * @param ligne , la ligne de la lettre en parametre.
    * @return estDouble, un bouleen qui indiquera si la case est une lettre compte double
    */
    public boolean estDouble(Plateau plat, int colonne, int ligne) {
        boolean estDouble = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "l2") {
            estDouble = true;
        }
        return estDouble;
    }

    /**
    * Methode booleenne permettant de savoir une case est comptee comme lettre compte triple.
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la lettre en parametre.
    * @param ligne , la ligne de la lettre en parametre.
    * @return estTriple, un bouleen qui indiquera si la case est une lettre compte triple.
    */
    public boolean estTriple(Plateau plat, int colonne, int ligne) {
        boolean estTriple = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "l3") {
            estTriple = true;
        }
        return estTriple;
    }

    /**
    * Methode booleenne permettant de savoir une case est comptee comme mot compte double.
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la lettre en parametre.
    * @param ligne , la ligne de la lettre en parametre.
    * @return estMotDouble, un bouleen qui indiquera si la case est une mot compte double.
    */
    public boolean estMotDouble(Plateau plat, int colonne, int ligne) {
        boolean estMotDouble = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "m2") {
            estMotDouble = true;
        }
        return estMotDouble;

    }
    /**
    * Methode booleenne permettant de savoir une case est comptee comme mot compte triple.
    * @param plat , le plateau sur lequel le joueur va jouer.
    * @param colonne , la colonne de la lettre en parametre.
    * @param ligne , la ligne de la lettre en parametre.
    * @return estMotTriple, un bouleen qui indiquera si la case est une mot compte triple.
    */
    public boolean estMotTriple(Plateau plat, int colonne, int ligne) {
        boolean estMotTriple = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "m3") {
            estMotTriple = true;
        }
        return estMotTriple;

    }
    public char verificationVide(Plateau plat, int colonne, int ligne){
        return(plat.getTabPlateau()[colonne][ligne].getLettre().getCar());

    }

}