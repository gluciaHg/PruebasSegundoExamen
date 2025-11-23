package ejercicio1_tema2;

import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Archivo> archivos; // Archivos directos en esta carpeta
	private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
	public Carpeta (String nombre) {
		this.nombre = nombre;
	}
	public List<Archivo> getArchivos () { return this.archivos; }
	public List<Carpeta> getSubcarpetas () {
		return this.subcarpetas;
	}
	
	
	public double getPesoTotal() {
	double peso = 0;
			for(int i = 0; i < archivos.size(); i++) {
				peso += archivos.get(i).getPesoMB();
			}
			for(int i = 0; i < subcarpetas.size(); i++) {
				peso += subcarpetas.get(i).getPesoTotal();
			}
		
		return peso;
	}
	
	
}


