package ejercicio13_tema3;

public class Persona extends Thread{
	private Peluqueria p;

	
	public Persona(Peluqueria p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		try {
			boolean esAtendido = p.entrarPeluqueria();
			if(esAtendido) {
				p.corteDePelo();
				p.salirPeluqueria();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

	
}
