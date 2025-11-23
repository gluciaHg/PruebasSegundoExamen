package ejercicio12_tema3;

public class Personas extends Thread{
	private int id;
	private boolean jubilado;
	GestorMuseo g;
	
	public Personas(int id, boolean jubilado, GestorMuseo g) {
		this.id = id;
		this.jubilado = jubilado;
		this.g= g;
	}
	
	public int getIdent() {
		return id;
	}
	
	public void run() {
		try {
			if(jubilado) {
				g.entrarSalaJubilados(this);
				Thread.sleep(1000);
				g.salirSala(this);
			} else {
				g.entrarSala(this);
				Thread.sleep(1000);
				g.salirSala(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
