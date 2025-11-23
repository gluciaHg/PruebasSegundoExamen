package ejercicio13_tema3;

import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int numClientes = 50;
		Peluqueria p = new Peluqueria();
		Random rand = new Random();
		
		for(int i = 0; i < numClientes; i++) {
			Thread.sleep(rand.nextInt(100));
			Persona a = new Persona(p);
			Thread threadp = new Thread(a, "Cliente-" + i);
            threadp.start();
		}
	}
}
