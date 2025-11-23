package ejercicio1_tema2;

public class Archivo {
	// Representa un archivo con un tamaño específico
	private String nombre;
	private double pesoMB; // Tamaño en Megabytes
	public Archivo (String nombre, double peso) { 
		this.nombre = nombre;
		this.pesoMB = peso;
	}
	public double getPesoMB () { 
		return this.pesoMB;
	}
}

