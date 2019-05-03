public class Chevalet{

		private Lettre[] chevalet;
		
		static int hasardo(int b1,int b2){
				return ((int) (Math.random() * (b2-b1+1))+b1);
		}
		
		Chevalet (){
				this.chevalet = new Lettre[7];
				for (int i =0; i<7;i++){
						
				}
		}

		String chevaletToString(){
				String str=("[");
				for (int i =0; i<7; i++){
					str=str+" "+chevalet[i].car;
				}
				str=str+"]";
				return str;
		}
		
		void remplirChevalet(SacDeLettres sac){
		int indiceSac = 0;
				for (int i = 0; i <7;i++){
						if (chevalet[i].car==' '){
								indiceSac= hasardo(0,100);
								if (sac.sac[indiceSac].car == ' '){
										remplirChevalet(sac);
								}
								else{
										chevalet[i].car = sac.sac[indiceSac].car;
										sac.sac[indiceSac] = new Lettre();
								}
						}
				}
		}
		
		
}