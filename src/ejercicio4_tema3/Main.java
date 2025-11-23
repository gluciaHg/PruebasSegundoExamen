package ejercicio4_tema3;



public class Main {
	private static final int NUM_PRODUCTORAS = 30;
	private static final int RATIO_PRODUCTORAS_CONSUMIDORAS = 4;

	public static void main(String[] args) {
		
			// Recurso compartido (monitor)
			Buffer b = new Buffer();


			System.out.println("Iniciando: " + NUM_PRODUCTORAS + " lectoras y " +
								NUM_PRODUCTORAS / RATIO_PRODUCTORAS_CONSUMIDORAS + " escritoras.");
			try {
				// Crear y arrancar hebras
				for (int i = 0; i < NUM_PRODUCTORAS; i++) {
					Thread t = new Productora(b);
					t.start();
					// 1 escritora por cada N lectoras
					if (i % RATIO_PRODUCTORAS_CONSUMIDORAS == 0) {
						Thread t2 = new Consumidora(b);
						t2.start();
					}
					// Esperar hasta 500 ms entre creación de hebras.
					Thread.sleep((long) (Math.random() * 500));
				}
			} catch (InterruptedException e) {}
		}
	}

