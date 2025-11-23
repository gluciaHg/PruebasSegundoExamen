package ejercicio9_tema3;

public class Funcionario extends Thread{
	private Oficina o;
	
	public Funcionario(Oficina o) {
		this.o = o;
	}
	
	public void run() {
		try {
			while(true) {
				o.atenderCiudadano();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
