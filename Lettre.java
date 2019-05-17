// Medhi Louison, Antoine Claudel, I2 CMI informatique 

/**
* La classe Lettre de notre jeu.
*/


public class Lettre {

    /**
    * Elle est composée d'un caractère et d'une valeur (points).
    */
    private char car;

    private int points;

    /**
	* Méthode qui permet d'obtenir le caractère de la Lettre.
	* @return car, le caractère de la Lettre.
	*/
    public char getCar(){
        return this.car;
    }    


    /**
	* Méthode qui permet de donner au caractère de la classe un caractère.(nécessaire puisque car est en private)
	* @param car , le caractère que l'on veut affecter.
	*/
    public void setCar(char car){
        this.car=car;
    }

    /**
	* Méthode qui permet d'obtenir la valeur d'une lettre.
	* @return points, le valeur de la Lettre.
	*/
    public int getPoints(){
        return points;
    }    

    /**
	* Le constructeur de la lettre, il l'initialise avec un caractère égale à '.' et a une valeur de 0.
	*/
    public Lettre() {
        this.car = '.';
        this.points = 0;
    }

    
    /**
    * Le constructeur surchargé de Lettre(), il va donner une valeur selon son entrée.
    * @param car, le caractère qui va permettre d'affecter une valeur à la lettre.
	*/
    public Lettre(char car) {
        this.car = car;
        switch (car) {

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
            this.points = 1;
            break;

        case 'D':
        case 'G':
        case 'M':
            this.points = 2;
            break;

        case 'B':
        case 'C':
        case 'P':
            this.points = 3;
            break;

        case 'F':
        case 'H':
        case 'V':
            this.points = 4;
            break;

        case 'J':
        case 'Q':
            this.points = 8;
            break;

        case 'K':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            this.points = 10;
            break;
        default:
            this.points = 0;
            break;
        }
    }

}