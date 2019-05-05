public class Chevalet {

	Lettre[] chevalet;

	static int hasardo(int b1, int b2) {
		return ((int) (Math.random() * (b2 - b1 + 1)) + b1);
	}

	Chevalet() {
		this.chevalet = new Lettre[7];
		for (int i = 0; i < 7; i++) {
			this.chevalet[i] = new Lettre();
		}
	}

	String chevaletToString() {
		String str = ("[");
		for (int i = 0; i < 7; i++) {
			str = str + " " + chevalet[i].car;
		}
		str = str + "]";
		return str;
	}

	// remplit le chevalet avec des lettres du sac.
	// pb : lorsqu'une lettre est tirée elle ne s'enlève pas du sac
	void remplirChevalet(SacDeLettres S) {
		int indiceSac = 0;
		for (int i = 0; i < 7; i++) {
			if (chevalet[i].car == '.') {
				indiceSac = hasardo(0, 99);
				if (S.sac[indiceSac].car == '.') {
					remplirChevalet(S);
				} else {
					chevalet[i] = new Lettre(S.sac[indiceSac].car);
					S.viderSac(indiceSac);
					
				}
			}
		}
	}

}