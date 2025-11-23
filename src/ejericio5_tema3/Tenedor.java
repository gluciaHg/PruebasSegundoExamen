package ejericio5_tema3;

public class Tenedor {
	private boolean ocupado = false;
	//private int posTenedor;
	
	/*public Tenedor(int posTenedor) {
		this.posTenedor= posTenedor;
	}
*/
	public synchronized void coger() throws InterruptedException {
		while(ocupado) {
			wait();
		}
		ocupado=true;
	}
	
	public synchronized void dejar() throws InterruptedException{
		ocupado=false;
		notify();
	}
}
