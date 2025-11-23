package ejercicio11_tema3;

public class GestorDePedidos extends Thread{
	private int peticionesR;
	private int peticionesA;
	private int id;
	Fabrica f;
	
	public GestorDePedidos(int peticionesR, int peticionesA, int id, Fabrica f) {
		this.peticionesR = peticionesR;
		this.peticionesA = peticionesA;
		this.id = id;
		this.f = f;
	}
	
	public void run() {
		try {
			System.out.println("El gestor de pedidos "+ id + " pide "+ peticionesR + " piezas rojas y " + peticionesA + " piezas azules");
			f.extraerPiezas(peticionesR, peticionesA);
			System.out.println("El gestor "+id+" recibe sus piezas");
		} catch(InterruptedException e) {}
	}
	
	
}
