package ejercicio3_3_tema2;

public class Whatever {
	public static long calcular (int n) {
		long contador = 0;
		for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++) {
		contador++;
		}
		}
		return contador;
		}
	public static int metodoLog (int n) {
		int a = 0;
		for (int i = 0; i < n; i++) {
		for (int j = 1; j < n; j *= 2) {
		a++;
		}
		}return a;
		}
	public static void main(String[] args) {
		//System.out.println(calcular(5));
		
		System.out.print(metodoLog(10));

	}
}
