package ejercicio4_tema3;

import java.util.Random;

public class Consumidora extends Thread{
	private Buffer b = new Buffer();
	private Random rand = new Random();
	
	public Consumidora(Buffer b) {
		this.b = b;
	}
	
	public void run() {
	//	while(true) {
			try {
				b.consumir();
				sleep(rand.nextInt(300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	//	}
	}
	
	
}
