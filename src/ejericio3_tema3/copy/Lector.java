package ejericio3_tema3.copy;

import java.util.Random;

/*public class Lector extends Thread{

    private RecursoCompartido recurso1;
    private RecursoCompartido recurso2;
    private Random rand = new Random();


    public Lector(RecursoCompartido recurso1, RecursoCompartido recurso2) {
        this.recurso1 = recurso1;
        this.recurso2 = recurso2;
    }
    
    @Override
    public void run() { 
    	try {
            Thread.sleep(rand.nextInt(1000)); 
        } catch (InterruptedException e) {}
        
        
        if (rand.nextBoolean()) {
            System.out.println("Lector lee: " + recurso1.leer() + " y " + recurso2.leer());
        } else {
            System.out.println("Lector lee: " + recurso2.leer() + " y " + recurso1.leer());
        }
        
    }
}
*/
public class Lector extends Thread {
    private final RecursoCompartido r1;
  //  private final RecursoCompartido r2;
    private final String nombre;
    private Random rand = new Random();

    public Lector(RecursoCompartido r1, RecursoCompartido r2, String nombre) {
        this.r1 = r1;
       // this.r2 = r2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Intenta leer del recurso
       // 	if(rand.nextBoolean()) {
                r1.leer(nombre);
        //        r2.leer(nombre);
       // 	}
        //	else {
        //		r2.leer(nombre);
        //        r1.leer(nombre);
        //	}
        } catch (InterruptedException e) {}
    }
}