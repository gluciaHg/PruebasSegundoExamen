package ejercicio11_tema3;

import java.util.Random;

public class Main {
	static Fabrica f = new Fabrica();
	static LineaRoja r = new LineaRoja(f);
	static LineaAzul a = new LineaAzul(f);
	static Random rand = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		r.start();
		a.start();
		for(int i = 0; i < 30; i++) {
			GestorDePedidos g = new GestorDePedidos(rand.nextInt(51),rand.nextInt(51),i,f);
			Thread.sleep(500);
			g.start();
		}
		
	}
	
}
