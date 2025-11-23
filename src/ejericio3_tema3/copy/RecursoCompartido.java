package ejericio3_tema3.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*public class RecursoCompartido {
	private int numero;
	
	
	public RecursoCompartido(int numero) {
		this.numero = numero;
	}
	
	public int leer() {
		return numero;
	}
	
	public synchronized void escribir(int dato) {
	        numero = dato;
	}
}
*/

/**
 * Ejercicio 1: Monitor
 *
 * Gestiona el acceso concurrente a un recurso (un Integer).
 * El recurso se considera no inicializado si es 'null'.
 */
public class RecursoCompartido {

	// Recurso compartido
	private Integer entero = null; 
    
    private int numLectores = 0;
    private boolean escribiendo = false;

    private final LinkedList<Thread> cola = new LinkedList<>();
    private final Map<Thread, Prioridad> prioridad = new HashMap<>();
    private final Map<Thread, Boolean> esLector = new HashMap<>();
    private Random rand = new Random();
    
    public synchronized void registrar(Thread t, Prioridad p, boolean lector) {
    	prioridad.put(t, p);
    	esLector.put(t,lector);
    }
    
    private void insertarOrdenado(Thread t) {
    	int startIndex = -1;
    	int endIndex = -1;
    	for(int i = 0; i < cola.size(); i++) {
    		Thread t1 = cola.get(i);
    		Prioridad p = prioridad.get(t1);
    		boolean esLector = t instanceof Lector;
    	}
    	if(prioridad.get(t) == Prioridad.ALTA) {
    		if(esLector.get(t)) {
    			
    		}
    	}
    }
    
    /**
     * Lectura.
     */
    public void leer(String nombreLector) throws InterruptedException {
        // 1. Adquirir permiso de lectura
        this.accesoLectura(nombreLector);
        // 2. Acción de lectura (Fuera de sincronización) 
        Integer valorLeido = this.entero; // Se lee la referencia al objeto
        System.out.println("!!! Lector " + nombreLector + " está leyendo. Valor = " + valorLeido);
        // Espera hasta 500 ms
        Thread.sleep((long) (Math.random() * 500));
        // 3. Liberar permiso de lectura
        this.terminaLectura(nombreLector);        
    }
    
    private synchronized void accesoLectura(String nombreLector) throws InterruptedException {
    	Thread t = Thread.currentThread();
    	// Si el entero es null debe esperar
        while (escribiendo || entero == null) { 
            System.out.println("... Lector " + nombreLector + " espera para leer.");
            wait();
        }
        numLectores++;
        System.out.println(">>> Lector " + nombreLector + " ha empezado a leer.");
    }
    
    private synchronized void terminaLectura(String nombreLector) throws InterruptedException {
    	numLectores--;
        if (numLectores == 0) {
            notifyAll();
        }
        System.out.println("<<< Lector " + nombreLector + " ha terminado de leer.");
    }

    /**
     * Escritura.
     */
    public void escribir(String nombreEscritor) throws InterruptedException {
        // 1. Adquirir permiso de escritura
        this.accesoEscritura(nombreEscritor);
        // 2. Acción de escritura
        Integer valorAntiguo = this.entero;
        // El entero se genera aleatoriamente
        this.entero = (int) (Math.random() * 10001); 
        System.out.println("!!! Escritor " + nombreEscritor + " escribe. Valor antiguo = " + String.valueOf(valorAntiguo) + ", nuevo = " + this.entero);
        // Espera hasta 500 ms
        Thread.sleep((long) (Math.random() * 500));
        // 3. Liberar permiso de escritura
        this.terminaEscritura(nombreEscritor);
    }
    
    private synchronized void accesoEscritura(String nombreEscritor) throws InterruptedException {
    	while (numLectores > 0 || escribiendo) {
    		System.out.println("... Escritor " + nombreEscritor + " espera para escribir.");
            wait();
        }
        escribiendo = true;
        System.out.println(">>> Escritor " + nombreEscritor + " ha empezado a escribir.");
    }
    
    private synchronized void terminaEscritura(String nombreEscritor) throws InterruptedException {
    	escribiendo = false;
    	notifyAll();
    	System.out.println("<<< Escritor " + nombreEscritor + " ha terminado de escribir.");
    }
}