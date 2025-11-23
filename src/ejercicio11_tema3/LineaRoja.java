package ejercicio11_tema3;

public class LineaRoja extends Thread{
	Fabrica f;
	public LineaRoja(Fabrica f) {
		this.f = f;
	}
	public void run() {
		try {
			while(true) {
				f.producirPiezaRoja();
			}
		} catch(InterruptedException e) {}
	}
	
}
