public class test {
	public static void main(String[] args) {
 
	   // On crée un sac de lettre
	   SacDeLettres sac = new SacDeLettres();
	   //on affiche les lettres contenue dans le sac de lettre
	   String strSac = sac.SacToString();
	   Ecran.afficher(strSac);
	   // on crée un chevalet et on le remplit de 7 lettres
	   Chevalet c = new Chevalet();
	   c.remplirChevalet(sac);
	   String strC = c.chevaletToString();
	   
	   // on affiche le chevalet et le sac de lettre une fois fini
	   Ecran.afficher(strC);
	   Ecran.afficher(strSac);
	}
 }