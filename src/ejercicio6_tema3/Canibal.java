package ejercicio6_tema3;

public class Canibal extends Thread{
	private int id;
	private Marmita m;
	
	public Canibal(int id, Marmita m) {
		this.id = id;
		this.m = m;
	}
	
	public void run() {
			try {
				while(true) {
				Thread.sleep((int)(Math.random()*800));
				m.comer(id);
				}
			}
			 catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	
	
}
