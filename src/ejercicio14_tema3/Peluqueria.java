package ejercicio14_tema3;

import java.util.Random;

public class Peluqueria {
	private int sofasOcupados = 0;
	private boolean sillaOcupada = false;
	private int personasEnBarra = 0;
	Random rand = new Random();
	
	public synchronized boolean quiereUnCorte() throws Exception{
		if(personasEnBarra == 15 && sofasOcupados == 5 && sillaOcupada) {
			System.out.println("El cliente "+ Thread.currentThread().getName() + " sale sin corte");
			return false;
		}
		if(!sillaOcupada) {
			sillaOcupada = true;
			System.out.println("El cliente " + Thread.currentThread().getName() + " se sienta a que le corten");
			return true;
		}
		if(sofasOcupados < 5) {
			sofasOcupados++;
			System.out.println("El cliente " + Thread.currentThread().getName() + " espera en el sofá");
			while(sillaOcupada) {
				wait();
			}
			sofasOcupados--;
			sillaOcupada = true;
			System.out.println("El cliente " + Thread.currentThread().getName() + " pasa del sofá a la silla");
			return true;
		} 
		if(personasEnBarra < 15) {
			personasEnBarra++;
			System.out.println("El cliente " + Thread.currentThread().getName() + " espera en la barra");
			while(sofasOcupados == 5) {
				wait();
			} 
			personasEnBarra--;
			sofasOcupados++;
			while(sillaOcupada) {
				wait();
			}
			sofasOcupados--;
			sillaOcupada = true;
			System.out.println("El cliente " + Thread.currentThread().getName() + " pasa del sofá a la silla");
			return true; 
		}
		return false;
	}
	public synchronized void salir() {
		sillaOcupada = false;
		System.out.println("El cliente " + Thread.currentThread().getName() + " se va con corte");
		notifyAll();
	}
	public void cortar() throws InterruptedException {
		Thread.sleep(rand.nextInt(401));
	}
	
	
}
