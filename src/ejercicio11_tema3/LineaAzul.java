package ejercicio11_tema3;

public class LineaAzul extends Thread{
	Fabrica f;
	public LineaAzul(Fabrica f) {
		this.f = f;
	}
	public void run() {
		try {
			while(true) {
				f.producirPiezaAzul();
			}
		} catch(InterruptedException e) {}
	}
	
}

