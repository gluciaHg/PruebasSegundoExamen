package ejercicio10_tema3;

import java.util.Random;

public class Main {
	static Random r = new Random();
	public static void main(String[] args) throws InterruptedException {
		Puente p = new Puente();
		
		for(int i = 0; i < 30; i++) {
			if((i%5)==0) {
				Coche c = new Coche(p,(900 + r.nextInt(2000 - 900 + 1)), true, i);
				c.start();
			} else {
				Coche b = new Coche(p,(900 + r.nextInt(2000 - 900 + 1)), false, i);
				b.start();
			}
			Thread.sleep(100);
		}
		
	}
}
