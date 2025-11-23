package ejercicio11_tema3;

public class Fabrica {
	private int cestaR = 0;
	private int cestaA = 0;
	
	public synchronized void producirPiezaRoja() throws InterruptedException {
		while(cestaR >= 50) {
			wait();
		}
		Thread.sleep((int)(Math.random()*300) + 50);
		cestaR++;
		System.out.println("Se produce una pieza roja y hay "+ cestaR);
		notifyAll();
	}
	public synchronized void producirPiezaAzul() throws InterruptedException{
		while(cestaA >= 50) {
			wait();
		}
		Thread.sleep((int)(Math.random()*300) + 50);
		cestaA++;
		System.out.println("Se produce una pieza azul y hay "+ cestaA);
		notifyAll();
	}
	public synchronized void extraerPiezas(int rojas, int azules) throws InterruptedException{
		if(rojas > 50 || azules > 50) {
			throw new IllegalArgumentException("No puede pedir más de 50 piezas de cada color");
		}
		while(rojas > cestaR || azules > cestaA) {
			wait();
		}
		cestaR -= rojas;
		cestaA -= azules;
		System.out.println("Quedan "+ cestaR + " piezas rojas y "+ cestaA + " piezas azules");
		notifyAll();
	}
	
}
