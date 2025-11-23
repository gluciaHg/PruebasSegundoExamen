package ejercicio10_tema3;

public class Coche extends Thread{
	Puente p;
	private int peso;
	private boolean ambulancia;
	private int id;
	
	public Coche(Puente p, int peso, boolean ambulancia, int id) {
		this.p = p;
		this.peso = peso;
		this.ambulancia = ambulancia;
		this.id = id;
	}
	
	public void run() {
		try {
			//while (true) {
				System.out.println("Coche "+ id + " con peso "+ peso+ " es ambulancia = "+ambulancia+" intenta entrar");
				p.entrarPuente(peso, ambulancia);
				System.out.println("Coche "+ id +" con peso "+ peso+ " es ambulancia = "+ambulancia+" entra");
				p.salirPuente(peso);
				System.out.println("Coche "+ id +" con peso "+ peso+ " es ambulancia = "+ambulancia+" sale");
			//}
		}catch (InterruptedException e) {}
	}
}
