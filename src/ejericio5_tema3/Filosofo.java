package ejericio5_tema3;

public class Filosofo extends Thread{
	private int id;
	private Tenedor izd;
	private Tenedor dcho;
	private boolean invertido;
	
	public Filosofo(int id, Tenedor izd, Tenedor dcho, boolean invertido) {
		this.id = id;
		this.izd = izd;
		this.dcho = dcho;
		this.invertido= invertido;
		
	}
	
	public void run() {
		//while(true) {
			try {
				pensar();
				comer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}
	
	
	public void pensar() throws InterruptedException {
		System.out.println("Filósofo "+ id + " está pensando");
		Thread.sleep(500);
	}
	
	public void comer() throws InterruptedException{
		if(invertido == false) {
			System.out.println("Filósofo "+ id + " intenta coger tenedor izd");
			izd.coger();
			
			System.out.println("Filósofo "+ id + " intenta coger tenedor dcho");
			dcho.coger();
		} else {
			System.out.println("Filósofo "+ id + " intenta coger tenedor dcho");
			dcho.coger();
			
			System.out.println("Filósofo "+ id + " intenta coger tenedor izd");
			izd.coger();
		}
		System.out.println("Filósofo "+ id + " está comiendo");
		Thread.sleep(500);

		System.out.println("Filósofo "+ id + " deja tenedor izd");
		izd.dejar();
		
		System.out.println("Filósofo "+ id + " deja tenedor dcho");
		dcho.dejar();
		
		System.out.println("Filósofo "+ id + " ha terminado de comer");
	}
	
	
	
	
	
	
}
