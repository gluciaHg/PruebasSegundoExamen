package ejercicio4_tema3;


public class Buffer {
	private Integer[] buffer = new Integer[10];
	private int posOcupadas = 0;
	
	
	public Buffer() {
	}
	
	public synchronized void producir(int dato) throws InterruptedException {
		while(posOcupadas >= 10) {
			wait();
		}
		System.out.println("Se produce "+ dato);
		for(int i = 0; i < buffer.length; i++) {
			if(buffer[i] == null) {
				buffer[i] = dato;
				posOcupadas++;
				notifyAll();
				return;
			}
		}
	}
	
	public synchronized void consumir() throws InterruptedException {
		while(posOcupadas == 0) {
			wait();
		}
		System.out.println("Se lee "+ buffer[0]);
		for(int i = 0; i < buffer.length-1; i++) {
			buffer[i] = buffer[i+1];
			buffer[buffer.length-1] = null;
		}
		posOcupadas--;
		notifyAll();
	}
}







