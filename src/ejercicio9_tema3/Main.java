package ejercicio9_tema3;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Oficina o = new Oficina();
		Funcionario f = new Funcionario(o);
		f.start();
		
		for(int i = 0; i < 30; i++) {
			Ciudadano c = new Ciudadano(i, o);
			c.start();
			Thread.sleep(500);
		}
		
	}
}
