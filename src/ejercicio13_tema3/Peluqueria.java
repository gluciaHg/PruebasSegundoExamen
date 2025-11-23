package ejercicio13_tema3;

import java.util.Random;

public class Peluqueria {
	private int sofasOcupados =0;
	private boolean sillaOcupada = false;
	private Random rand = new Random();
	
	public synchronized boolean entrarPeluqueria() throws InterruptedException{
		if(sofasOcupados == 5 && sillaOcupada) {
			irseEnfadado();
			return false;
		} 
		if(!sillaOcupada) {
			sillaOcupada = true;
			System.out.println("La persona "+ Thread.currentThread().getName() + " se sienta para que le corten");
			return true;
		}
		if(sofasOcupados < 5) {
			sofasOcupados++;
			System.out.println("La persona "+ Thread.currentThread().getName() + " se sienta en el SOFÁ (Sofás: " + sofasOcupados + ")");
		
			while(sillaOcupada) {
				wait();
			}
			sofasOcupados--; 
			System.out.println("La persona "+ Thread.currentThread().getName() + " procede a que le corten el pelo (Sofás: " + sofasOcupados + ")");
			sillaOcupada = true;
			return true;
		}
		return false;
		
	}
	
	public void irseEnfadado() {
		System.out.println("La persona "+ Thread.currentThread().getName() + " abandona sin corte");
	}
	public synchronized void salirPeluqueria() {
		sillaOcupada = false;
		System.out.println("La persona " + Thread.currentThread().getName() + " sale cortado");
		notifyAll();
	}
	public void corteDePelo() throws InterruptedException {
		Thread.sleep(rand.nextInt(401));
	}
	
}
