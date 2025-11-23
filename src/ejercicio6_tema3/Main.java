package ejercicio6_tema3;

public class Main {
	
	
	public static void main(String[] args) {
		Marmita marmita = new Marmita(5);
		Cocinero cocinero = new Cocinero(marmita);
		cocinero.start();
		
		for(int i = 0; i < 10; i++) {
			Canibal canibal = new Canibal(i,marmita);
			canibal.start();
		}
		
	}
}
