package ejercicio6_tema3;

public class Marmita {
	private int nInicial;
	private int n;
	private boolean avisado= false;
	
	public Marmita(int nInicial) {
		this.nInicial = nInicial;
		this.n = nInicial;
	}
	
	public synchronized void comer(int id) throws InterruptedException {
			while(n == 0 && avisado == true) {
				wait();
			}
			if(n == 0 && avisado == false) {
				System.out.println("Canibal "+ id + " avisa al cocinero");
				avisado = true;
				notifyAll();
				while(n == 0) {
					wait();
				}
			}
			n--;
			System.out.println("Canibal "+ id + " se sirve. Quedan "+ n + "raciones");
			if(n == 0) {
				avisado = false;
			}
			
	}
	
	public synchronized void rellenar() throws InterruptedException {
		while(avisado == false) {
			wait();
		} 
			System.out.println("Cocinero rellena...");
			Thread.sleep(1000);
			n = nInicial;
			avisado = false;
			System.out.println("Marmita llena");
			notifyAll();
		
	}
	
	
}
