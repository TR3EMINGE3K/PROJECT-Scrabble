public class Lettre {

    public char car;

    public int points;

    public Lettre(){
        this.car='.';
        this.points=0;
    }
    
    public Lettre(char car){
        this.car = car;
        switch (car){

            case 'A':
            case 'E':
            case 'I':
            case 'N':
            case 'O':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'L':
                this.points=1;
            break;

            case 'D':
            case 'G':
            case 'M':
                this.points=2;
            break;

            case 'B':
            case 'C':
            case 'P':
                this.points=3;
            break;

            case 'F':
            case 'H':
            case 'V':
                this.points=4;
            break;

            case 'J':
            case 'Q':
                this.points=8;
            break;

            case 'K':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                this.points=10;
            break;
	}
    }
        
    // return la lettre 
    char getCar(){
        return car;
    }

    //return la valeur de la lettre 
    int getPoints(){
        return points;
    }

}