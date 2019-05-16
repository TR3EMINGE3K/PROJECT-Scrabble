public class Joueur {

    // Chaque joueur possède un nom et score
    private String nom;
    private int score;
    private Chevalet chev;

    public String getNom(){
        return nom;
    }

    public int getScore(){
        return score;
    }

    public Chevalet getChev(){
        return chev;
    }

    // Chaque joueur possède son chevalet
    public Joueur() {
        this.nom = "";
        this.score = 0;
    }

    public Joueur(SacDeLettres S) {

        this.chev = new Chevalet();

        Ecran.afficher("veuillez entrer votre nom : ");
        this.nom = Clavier.saisirString();
        Ecran.afficherln("Bienvenue ", this.nom);

        // On remplis le chevalet du joueur
        this.chev.remplirChevalet(S);

    }

    // création de n joueurs (jusqu'à 4)
    static Joueur[] creerJoueurs(SacDeLettres S) {
        Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
        int n = Clavier.saisirInt();
        while ((n < 1) || (n > 4)) {
            Ecran.afficher("erreur de saisie");
            Ecran.afficher("Saisissez le nombre de joueurs. (Entre 1 et 4)\n");
            n = Clavier.saisirInt();
        }
        // création du tableau de n joueurs
        Joueur[] tabJoueur = new Joueur[n];
        for (int i = 0; i < n; i++) {
            tabJoueur[i] = new Joueur(S);
        }
        return (tabJoueur);
    }

    // Cette fonction transforme une minuscule en majuscule et laisse en majuscule
    // si c'en est déjà le cas.
    // Le but est de ne pas compter la saisie d'une minuscule comme une erreur
    static char lettreEnMaj(char a) {
        char b;
        b = Character.toUpperCase(a);
        return b;
    }

    // Placement des lettres sur le plateau: Le joueur va choisir sa case de départ
    // puis une direction.
    // il pourra ensuite ajouter des lettres jusqu'à ce qu'il rencontre des cases
    // non vides ou qu'il sorte du plateau.
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
            // vérification de la saisie de la lettre
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandée ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);
            }

            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            // et ajout du score lettre par lettre
            scoreLettre = (ajoutScore(plat, strLET, 7, 7));
            plat.placerLettre(strLET, 7, 7);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // On demande au joueur où veut il placer la lettre suivante
            Ecran.afficherln(
                    "Dans quelle direction voulez vous écrire votre mot ? \nTapez 'b' pour écrire en bas et 'd' pour écrire à droite");
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
            Ecran.afficher("Où voulez vous placer votre première lettre ", nom, " ?\n");
            Ecran.afficher("Quelle Colonne (0,1,2,3...)\n");
            int colonne = Clavier.saisirInt();
            Ecran.afficher("Quelle Ligne (0,1,2,3...)\n");
            int ligne = Clavier.saisirInt();

            // vérification de la saisie de la position
            while ((plat.getTabPlateau()[ligne][colonne].getLettre().getCar() != '.') || (ligne < 0) || (colonne < 0) || (colonne > 14)
                    || (ligne > 14) && ((plat.getTabPlateau()[ligne + 1][colonne].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne - 1][colonne].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne][colonne + 1].getLettre().getCar() != '.')
                            || (plat.getTabPlateau()[ligne][colonne - 1].getLettre().getCar() != '.'))) {
                Ecran.afficher("Erreur, la case sélectionnée n'est pas valide\n");
                Ecran.afficher("Quelle ligne (0,1,2,3...)\n");
                ligne = Clavier.saisirInt();
                Ecran.afficher("Quelle colonne (0,1,2,3...)\n");
                colonne = Clavier.saisirInt();

            }
            Ecran.afficher("Quelle lettre voulez placer en (", colonne, ",", ligne, ") ", nom, " ?\n");

            // saisie de la lettre
            char strLet = Clavier.saisirChar();
            char strLET = lettreEnMaj(strLet);

            // vérification de la saisie de la lettre
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandée ne se situe pas dans votre chevalet\n");
                Ecran.afficher("veuillez saisir une lettre disponible dans votre chevalet\n");
                strLet = Clavier.saisirChar();
                strLET = lettreEnMaj(strLet);
            }

            // placement de la lettre sur le plateau et retirement de la lettre du chevalet
            // et ajout du score lettre par lettre
            scoreLettre = (ajoutScore(plat, strLET, colonne, ligne));
            plat.placerLettre(strLET, ligne, colonne);
            chev.retirerLettre(chev.positionDansChevalet(strLET));

            // On demande au joueur où veut il placer la lettre suivante
            Ecran.afficherln(
                    "Dans quelle direction voulez vous écrire votre mot ? \nTapez 'b' pour écrire en bas et 'd' pour écrire à droite \nTapez 'f' si votre mot est fini");
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
                Ecran.afficherln("Voilà ton score ", nom, " : ", scoreLettre);
                break;
            }

        }
        
    }

    public void placerLettresBas(Plateau plat, int colonne, int ligne, int scoreLettre, boolean motDouble,
                boolean motTriple,boolean motQuadruple) {
        boolean motBienPlace = false;
        Boolean finMot = false;

        Ecran.afficherln("Vous avez décidé d'écrire votre mot vers le bas");
        
        int compteur = 1;
        while ((finMot == false) && (compteur < 6) && (ligne < 14)) {
            ligne++;
            
            /*posMotActu[compteur].colonne = colonne;
            posMotActu[compteur].ligne = ligne;
*/
            // on vérifie qu'il y a mot compte double, compte triple ou compte quadruple
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

            // on vérifie que la lettre soit bien dans le chevalet du joueur
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandée ne se situe pas dans votre chevalet\n");
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
        Ecran.afficherln("Voilà ton score ", nom, " ", scoreLettre);
        this.score=this.score+scoreLettre;
    }

    public void placerLettresDroite(Plateau plat, int colonne, int ligne, int scoreLettre, boolean motDouble,
    boolean motTriple,boolean motQuadruple) {

        Boolean finMot = false;

        Ecran.afficherln("Vous avez décidé d'écrire votre mot vers la droite");
        int compteur = 1;
        while ((finMot == false) && (compteur < 6) && (colonne < 14)) {
            colonne++;
            /*posMotActu[compteur].colonne = colonne;
            posMotActu[compteur].ligne = ligne;*/
            // on vérifie qu'il y a mot compte double, compte triple ou compte quadruple
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

            // on vérifie que la lettre soit bien dans le chevalet du joueur
            while (!(chev.lettreDansChevalet(strLET))) {
                Ecran.afficher("La lettre demandée ne se situe pas dans votre chevalet\n");
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
        Ecran.afficherln("Voilà ton score ", nom, " : ", scoreLettre);
        this.score=this.score+scoreLettre;
    }

    /*
     * cette fonction vérifie si, lorsque l'on place un mot horizontal, on en
     * complète un vertical, puis calcule le score ajouté public int
     * pointsMotHautBas(Plateau plat, int colonne, int ligne, valeur de la première
     * lettreint pts){ Boolean finMot = false; String bonusCaseDepart =
     * plat.tabPlateau[colonne][ligne].type; char strLET; //on vérifie si il y a un
     * mot seulement vers le bas: if((plat.tabPlateau[colonne][ligne+1].lettre.car
     * != ' ')&&(plat.tabPlateau[colonne][ligne-1].lettre.car == ' ')){ //compte des
     * points à ajouter while ((finMot==false) && (ligne < 14)) { ligne++;
     * strLET=plat.tabPlateau[colonne][ligne].lettre.car; pts = pts +
     * (ajoutScore(plat, strLET, colonne, ligne)); if (ligne + 1 >14){ finMot=true;
     * } } } return pts; }
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

    public int ComptageScore(int score) {
        int multiplicateur = 0;
        return (score * multiplicateur);
    }

    public boolean estDouble(Plateau plat, int colonne, int ligne) {
        boolean estDouble = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "l2") {
            estDouble = true;
        }
        return estDouble;
    }

    public boolean estTriple(Plateau plat, int colonne, int ligne) {
        boolean estTriple = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "l3") {
            estTriple = true;
        }
        return estTriple;
    }

    public boolean estMotDouble(Plateau plat, int colonne, int ligne) {
        boolean estMotDouble = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "m2") {
            estMotDouble = true;
        }
        return estMotDouble;

    }

    public boolean estMotTriple(Plateau plat, int colonne, int ligne) {
        boolean estMotTriple = false;
        if (plat.getTabPlateau()[colonne][ligne].getType() == "m3") {
            estMotTriple = true;
        }
        return estMotTriple;

    }

}