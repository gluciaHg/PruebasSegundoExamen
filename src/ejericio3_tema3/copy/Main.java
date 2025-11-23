package ejericio3_tema3.copy;

import java.util.Random;

/*public class Main {
	public static void main(String[] args) {
		//Creamos un dato
		RecursoCompartido r1 = new RecursoCompartido(0);
		RecursoCompartido r2 = new RecursoCompartido(0);
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			new Lector(r1,r2).start();
			new Escritor(r1,r2, rand.nextInt(1000)).start();
		}
	}
}
*/
public class Main {
	// Configuración del número de hebras
	private static final int NUM_LECTORAS = 30;
	private static final int RATIO_LECTORAS_ESCRITORAS = 10;

	public static void main(String[] args) {
		// Recurso compartido (monitor)
		RecursoCompartido r1 = new RecursoCompartido();
		RecursoCompartido r2 = new RecursoCompartido();


		System.out.println("Iniciando: " + NUM_LECTORAS + " lectoras y " +
							NUM_LECTORAS / RATIO_LECTORAS_ESCRITORAS + " escritoras.");
		try {
			// Crear y arrancar hebras
			for (int i = 0; i < NUM_LECTORAS; i++) {
				Thread t = new Lector(r1,r2, "L" + i);
				t.start();
				// 1 escritora por cada N lectoras
				if (i % RATIO_LECTORAS_ESCRITORAS == 0) {
					Thread t2 = new Escritor(r1,r2, "E" + i);
					t2.start();
				}
				// Esperar hasta 500 ms entre creación de hebras.
				Thread.sleep((long) (Math.random() * 500));
			}
		} catch (InterruptedException e) {}
	}
}