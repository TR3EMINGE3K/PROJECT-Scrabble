public class SacDeLettres {

    // Création d'un tableau de lettre
    private Lettre[] sac;

    public Lettre[] getSac(){
        return sac;
    }    

    public SacDeLettres() {
        sac = new Lettre[100];

        // Mise en place de la lettre E dans le sac
        int i;
        for (i = 0; i < 15; i++) {
            sac[i] = new Lettre('E');
        }
        for (i = 15; i < 24; i++) {
            sac[i] = new Lettre('A');
        }
        for (i = 24; i < 32; i++) {
            sac[i] = new Lettre('I');
        }
        for (i = 32; i < 38; i++) {
            sac[i] = new Lettre('N');
        }
        for (i = 38; i < 44; i++) {
            sac[i] = new Lettre('O');
        }
        for (i = 44; i < 50; i++) {
            sac[i] = new Lettre('R');
        }
        for (i = 50; i < 56; i++) {
            sac[i] = new Lettre('S');
        }
        for (i = 56; i < 62; i++) {
            sac[i] = new Lettre('T');
        }
        for (i = 62; i < 68; i++) {
            sac[i] = new Lettre('U');
        }
        for (i = 68; i < 73; i++) {
            sac[i] = new Lettre('L');
        }
        for (i = 73; i < 76; i++) {
            sac[i] = new Lettre('D');
        }
        for (i = 76; i < 79; i++) {
            sac[i] = new Lettre('M');
        }
        for (i = 79; i < 81; i++) {
            sac[i] = new Lettre('B');
        }
        for (i = 81; i < 83; i++) {
            sac[i] = new Lettre('C');
        }
        for (i = 83; i < 85; i++) {
            sac[i] = new Lettre('F');
        }
        for (i = 85; i < 87; i++) {
            sac[i] = new Lettre('G');
        }
        for (i = 87; i < 89; i++) {
            sac[i] = new Lettre('H');
        }
        for (i = 89; i < 91; i++) {
            sac[i] = new Lettre('P');
        }
        for (i = 91; i < 93; i++) {
            sac[i] = new Lettre('V');
        }
        for (i = 93; i < 94; i++) {
            sac[i] = new Lettre('J');
        }
        for (i = 94; i < 95; i++) {
            sac[i] = new Lettre('K');
        }
        for (i = 95; i < 96; i++) {
            sac[i] = new Lettre('Q');
        }
        for (i = 96; i < 97; i++) {
            sac[i] = new Lettre('W');
        }
        for (i = 97; i < 98; i++) {
            sac[i] = new Lettre('X');
        }
        for (i = 98; i < 99; i++) {
            sac[i] = new Lettre('Y');
        }
        for (i = 99; i < 100; i++) {
            sac[i] = new Lettre('Z');
        }
    }

    // enlève (remplace par un point) une lettre du sac
    public void viderSac(int indiceSac) {
        this.sac[indiceSac].setCar('.');
    }

    // test si le sac est vide afin que les joueurs ne piochent pas dedans
    public boolean estVide(){
        for (int i = 0; i<100;i++){
            if (this.sac[i].getCar() !='.'){
                return false; 
            }

        }
        return true;
    }

    // juste pour tester que le sac s'actualise bien, ce qui n'est pas le cas (les
    // lettres ne sont pas retirées du sac quand elles sont piochées)
    String SacToString() {
        String str = " ";
        for (int i = 0; i < 100; i++) {
            str = str + sac[i].getCar();
        }
        return str;
    }

}


