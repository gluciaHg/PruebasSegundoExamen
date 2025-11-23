package ejercicio14_tema3;

public class Cliente extends Thread{
	private Peluqueria p;
	
	public Cliente(Peluqueria p) {
		this.p = p;
	}
	
	public void run() {
		try {
			if(p.quiereUnCorte()) {
				p.cortar();
				p.salir();
			}
			
		} catch (Exception e) {}
	}
}
