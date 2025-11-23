package ejericio3_tema3.copy;

import java.util.Random;

/*public class Escritor extends Thread{
	private RecursoCompartido recurso1;
	private RecursoCompartido recurso2;
	private int dato;
	private Random rand = new Random();
	
	public Escritor(RecursoCompartido recurso1, RecursoCompartido recurso2, int dato) {
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
		this.dato = dato;
	}
	
	@Override
	public void run() {
		try {
            Thread.sleep(rand.nextInt(1000)); 
        } catch (InterruptedException e) {}
        
        
        if (rand.nextBoolean()) {
        	recurso1.escribir(dato);
            System.out.println("Escritor escribe en recurso 1: " + dato);
        } else {
        	recurso2.escribir(dato);
            System.out.println("Escritor escribe en recurso 2: " + dato);
        }
	}
}
*/
public class Escritor extends Thread {
    private final RecursoCompartido r1;
 //   private final RecursoCompartido r2;
    private final String nombre;
    private Random rand = new Random();

    public Escritor(RecursoCompartido r1, RecursoCompartido r2, String nombre) {
        this.r1 = r1;
   //     this.r2 = r2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Intenta escribir en el recurso
        //	if(rand.nextBoolean()) {
                r1.escribir(nombre);
        /*	}
        	else {
        		r2.escribir(nombre);
        	}
       */ } catch (InterruptedException e) {}
    }
}