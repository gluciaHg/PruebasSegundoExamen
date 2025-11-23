package ejercicio10_tema3;

public class Puente {
	private int numCoches = 0;
	private int pesoTotal = 0;
	private int ambulanciasEsperando = 0;
	
	
	public synchronized void entrarPuente(int peso, boolean ambulancia) throws InterruptedException {
		if(ambulancia){
			ambulanciasEsperando++;
			while(numCoches == 10 || (pesoTotal+peso) > 15000) {
				wait();
			}
			numCoches++;
			ambulanciasEsperando--;
			pesoTotal += peso;
		} else {
			while(numCoches == 10 || (pesoTotal+peso) > 15000 || ambulanciasEsperando!=0) {
				wait();
			}
			numCoches++;
			pesoTotal += peso;
		}
	}
		
	public synchronized void salirPuente(int peso) throws InterruptedException {
		Thread.sleep(1000);
		numCoches--;
		pesoTotal -= peso;
		notifyAll();
	}
	
}
