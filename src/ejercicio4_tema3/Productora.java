package ejercicio4_tema3;

import java.util.Random;

public class Productora extends Thread{
	private Random rand = new Random();
	private Buffer b = new Buffer();
	
	public Productora(Buffer b) {
		this.b = b;
	}
	
	public void run() {
	//	while(true) {
			try {
				int dato = rand.nextInt(10001);
				b.producir(dato);
				sleep(rand.nextInt(300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	//	}
		
	}
	
}
