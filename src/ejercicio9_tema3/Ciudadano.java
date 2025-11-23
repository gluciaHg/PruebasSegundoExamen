package ejercicio9_tema3;

import java.util.Random;

public class Ciudadano extends Thread{
	private int id;
	private Random rand = new Random();
	private Oficina o;
	
	public Ciudadano(int id, Oficina o) {
		this.id = id;
		this.o = o;
	}
	public int getIdent() {
		return id;
	}
	
	public void run() {
		try {
			if(rand.nextBoolean() == true) {
				o.esperarVentanilla1(this);
			}else {
				o.esperarVentanilla2(this);
			}
		} catch (InterruptedException e) {}
	}
	
}
