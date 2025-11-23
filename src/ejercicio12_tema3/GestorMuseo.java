package ejercicio12_tema3;

import java.util.LinkedList;

public class GestorMuseo {
	private int personas=0;
	private int temperaturaActual = 25;
	private LinkedList<Personas> cola = new LinkedList<>();
	private LinkedList<Personas> colaVIP = new LinkedList<>();
	
	private int limite() {
        return (temperaturaActual > 30 ? 35 : 50);
    }
	
	public synchronized void entrarSala(Personas a) throws Exception{
		cola.add(a);
		//while(((temperaturaActual > 30) && (personas >= 35)) || ((temperaturaActual < 30) && (personas >= 50)) || (colaVIP.size() != 0)) {
		while(true)	{
			if(cola.peek() == a && personas < limite() && colaVIP.isEmpty()) {
				break;
			}
			wait();
		}
		System.out.println("Entra el usuario "+ a.getIdent());
		personas++;
		cola.remove(a);
	}
	public synchronized void entrarSalaJubilados(Personas a) throws Exception{
		colaVIP.add(a);
		//while(((temperaturaActual > 30) && (personas >= 35)) || ((temperaturaActual < 30) && (personas >= 50))) {
		while(true) {
			if(colaVIP.peek() == a && personas < limite()) {
				break;
			}
			wait();
		}
		System.out.println("Entra el usuario jubilado "+ a.getIdent());
		personas++;
		colaVIP.remove(a);
	}
	public synchronized void salirSala(Personas a) {
		System.out.println("Sale el usuario "+ a.getIdent());
		personas--;
		notifyAll();
	}
	public synchronized void notificarTemperatura(int temperatura) {
		temperaturaActual = temperatura;
		notifyAll();
		if(temperaturaActual >= 35) {
			System.out.println("Temperatura alta, límite 35 personas");
		} else {
			System.out.println("Temperatura normal, límite 50 personas");

		}
	}
	
	
}
