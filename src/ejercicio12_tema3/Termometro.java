package ejercicio12_tema3;

import java.util.Random;

public class Termometro extends Thread{
	private int temp;
	GestorMuseo g;
	Random rand = new Random();
	int c;
	
	public Termometro(GestorMuseo g) {
		this.g = g;
	}
	
	public void run() {
		try {
			while( c < 10) {
				Thread.sleep(1000);
				temp = 20+rand.nextInt(38-30+1);
				g.notificarTemperatura(temp);
				c++;
			}
		}catch (InterruptedException e) {}
	}
	
}
