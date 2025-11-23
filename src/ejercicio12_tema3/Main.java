package ejercicio12_tema3;

import java.util.Random;

public class Main {
	static Random r = new Random();
	static boolean rand = r.nextBoolean();
	public static void main(String[] args) throws InterruptedException {
		
		GestorMuseo g = new GestorMuseo();
		Termometro t = new Termometro(g);
		t.start();
		
		for(int i = 0; i < 100; i++) {
			if(i%10 == 0) {
				Personas p = new Personas(i,true,g);
				p.start();
				Thread.sleep(100);
			} else {
				Personas p = new Personas(i,false,g);
				p.start();
				Thread.sleep(100);
			}
		}
		
	}
}
