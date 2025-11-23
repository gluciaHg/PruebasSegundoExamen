package ejercicio14_tema3;

import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Peluqueria p = new Peluqueria();
		Random rand = new Random();
		for(int i = 0; i < 50; i++) {
			Cliente c = new Cliente(p);
			Thread ch = new Thread(c, "Cliente "+ i);
			Thread.sleep(rand.nextInt(100));
			ch.start();
		}
	}
}
