package ejercicio6_tema3;

public class Cocinero extends Thread{
	private Marmita m;
	
	public Cocinero(Marmita m) {
		this.m = m;
	}
	
	public void run() {
		try {
			while(true) {
				m.rellenar();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
