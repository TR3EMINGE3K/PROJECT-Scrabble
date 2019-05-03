public class SacDeLettres{

    // Création d'un tableau de lettre de taille 100
    Lettre [] sac;

    public SacDeLettres(){
	     this.sac=  new Lettre[100];
	    
        // Mise en place de la lettre E dans le sac
	    int i;
        for (i = 0;i<15;i++){
            sac[i].car = 'E';
        }
        for (i = 15;i<24;i++){
            sac[i].car = 'A';
        }
        for (i = 24;i<32;i++){
            sac[i].car = 'I';
        }
        for (i = 32;i<38;i++){
            sac[i].car = 'N';
        }
        for (i = 38;i<44;i++){
            sac[i].car = 'O';
        }
        for (i = 44;i<50;i++){
            sac[i].car = 'R';
        }
        for (i = 50;i<56;i++){
            sac[i].car = 'S';
        }
        for (i = 56;i<62;i++){
            sac[i].car = 'T';
        }
        for (i = 62;i<68;i++){
            sac[i].car = 'U';
        }
        for (i = 68;i<73;i++){
            sac[i].car = 'L';
        }
        for (i = 73;i<76;i++){
            sac[i].car = 'D';
        }
        for (i = 76;i<79;i++){
            sac[i].car = 'M';
        }
        for (i = 79;i<81;i++){
            sac[i].car = 'B';
        }
        for (i = 81;i<83;i++){
            sac[i].car = 'C';
        }
        for (i = 83;i<85;i++){
            sac[i].car = 'F';
        }
        for (i = 85;i<87;i++){
            sac[i].car = 'G';
        }
        for (i = 87;i<89;i++){
            sac[i].car = 'H';
        }
        for (i = 89;i<91;i++){
            sac[i].car = 'P';
        }
        for (i = 91;i<93;i++){
            sac[i].car = 'V';
        }
        for (i = 93;i<94;i++){
            sac[i].car = 'J';
        }
        for (i = 94;i<95;i++){
            sac[i].car = 'K';
        }
        for (i = 95;i<96;i++){
            sac[i].car = 'Q';
        }
        for (i = 96;i<97;i++){
            sac[i].car = 'W';
        }
        for (i = 97;i<98;i++){
            sac[i].car = 'X';
        }
        for (i = 98;i<99;i++){
            sac[i].car = 'Y';
        }
        for (i = 99;i<100;i++){
            sac[i].car = 'Z';
        }
    }
    
    

    
}