package ejercicio9_tema3;

import java.util.LinkedList;

public class Oficina {
	
	private LinkedList<Ciudadano> cola1 = new LinkedList<>();
	private LinkedList<Ciudadano> cola2 = new LinkedList<>();

	public synchronized void esperarVentanilla1(Ciudadano c) throws InterruptedException {
		if(cola1.isEmpty() && cola2.isEmpty()) {
			notify();
		}
		cola1.add(c);
		System.out.println("Ciudadano "+ c.getIdent() + " se pone a la cola 1");
		wait();
	}
	public synchronized void esperarVentanilla2(Ciudadano c) throws InterruptedException {
		if(cola1.isEmpty() && cola2.isEmpty()) {
			notify();
		}
		cola2.add(c);
		System.out.println("Ciudadano "+ c.getIdent() + " se pone a la cola 2");
		wait();
	}
	
	
	public synchronized void atenderCiudadano() throws InterruptedException {
		while(cola1.isEmpty() && cola2.isEmpty()) {
			System.out.println("Esperando...");
			wait();
		}
		if((cola1.size()>cola2.size()) || (cola1.size() == cola2.size())){
			System.out.println("Atendiendo a ciudadano "+ cola1.getFirst().getIdent() + " de cola 1");
			Thread.sleep(300);
			//cola1.getFirst().notify();
			notifyAll();
			System.out.println("Ciudadano "+ cola1.getFirst().getIdent() + " atendido");
			avanzarCola(cola1);
		} else {
			System.out.println("Atendiendo a ciudadano " + cola2.getFirst().getIdent() + " de cola 2");
			Thread.sleep(300);
			//cola2.getFirst().notify();
			notifyAll();
			System.out.println("Ciudadano "+ cola2.getFirst().getIdent() + " atendido");
			avanzarCola(cola2);	
		}
		
	}
	
	public void avanzarCola(LinkedList<Ciudadano> cola) {
		cola.removeFirst();
	}
	
}
