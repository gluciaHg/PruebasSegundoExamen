
public class Tema2_1 {
	
	public static void ex232(int n) {
        if (n <= 0) return;
        System.out.println(n);
        ex232(n-2);
        ex232(n-3);
        System.out.println(n);
    }
	public static String ex233(int n) {
		 if (n <= 0) return "";
		 return ex233(n-3) + n + ex233(n-2) + n;
		}
	public static int misterio(int a, int b) {
		 if (b == 0) return 0;
		 if (b % 2 == 0) return misterio(a+a, b/2);
		 return misterio(a+a, b/2) + a;
		}
	
	public static void hanoi(int discos, String origen, String auxiliar, String destino) {
		if(discos == 1) {
			System.out.println("Mover el disco "+ discos + " de "+ origen + " a "+ destino);
			return;
		}
		hanoi(discos-1, origen, destino, auxiliar);
		System.out.println("Mover el disco "+ discos + " de "+ origen + " a "+ destino);
		hanoi(discos-1, auxiliar, origen, destino);
	}

	    // 15 posiciones: 0 a 14
	    // tablero[i] = 1 ficha, 0 hueco
	    static int[] tableroInicial = {
	        1, 
	        1, 1,
	        1, 1, 1,
	        1, 1, 1, 1,
	        1, 1, 1, 1, 1
	    };

	    // La posición inicial tendrá un hueco (por ejemplo, en 0)
	    static int mejorResultado = Integer.MAX_VALUE;

	    // Movimientos válidos (X salta sobre Y y cae en Z)
	    // Cada trío representa un salto posible
	    static int[][] movimientos = { 
	        {3, 1, 0}, {5, 2, 0},
	        {6, 3, 1}, {7, 4, 2},
	        {10,6, 3}, {11,7, 4}, {12,8,5},

	        // saltos hacia abajo
	        {0, 1, 3}, {0, 2, 5},
	        {1, 3, 6}, {2, 4, 7}, {3, 6,10},
	        {4, 7,11}, {5, 8,12},

	        // saltos diagonales derecha
	        {2, 4, 7}, {4, 7,11}, {7,11,14},

	        // saltos diagonales izquierda
	        {4, 3, 1}, {7, 6, 3}, {11,10,6},

	        // saltos hacia arriba
	        {12,8, 5}, {11,7, 4}, {10,6,3},
	        {7,4,2}, {6,3,1}
	    };

	    // Comprueba si se puede hacer el movimiento X -> Z saltando Y
	    static boolean esValido(int[] tab, int x, int y, int z) {
	        return tab[x] == 1 && tab[y] == 1 && tab[z] == 0;
	    }

	    // Ejecuta el movimiento
	    static void aplicar(int[] tab, int x, int y, int z) {
	        tab[x] = 0;
	        tab[y] = 0;
	        tab[z] = 1;
	    }

	    // Deshace el movimiento (backtracking)
	    static void deshacer(int[] tab, int x, int y, int z) {
	        tab[x] = 1;
	        tab[y] = 1;
	        tab[z] = 0;
	    }

	    // Cuenta cuántas fichas quedan
	    static int contarFichas(int[] tab) {
	        int c = 0;
	        for (int v : tab) c += v;
	        return c;
	    }

	    // Algoritmo recursivo de búsqueda (backtracking)
	    static void resolver(int[] tablero) {
	        boolean hayMovimiento = false;

	        for (int[] mov : movimientos) {
	            int x = mov[0], y = mov[1], z = mov[2];

	            if (esValido(tablero, x, y, z)) {
	                hayMovimiento = true;

	                aplicar(tablero, x, y, z);
	                resolver(tablero);
	                deshacer(tablero, x, y, z);
	            }
	        }

	        // Si no hay movimientos, evaluar solución
	        if (!hayMovimiento) {
	            int fichas = contarFichas(tablero);
	            if (fichas < mejorResultado) {
	                mejorResultado = fichas;
	            }
	        }
	    }
	
	
	public static void main(String[] args) {
	        
	    //ex232(6);
		//ex233(6);
		//hanoi(6, "A", "C", "B");
		// Hueco inicial (por ejemplo en la posición 0)
        int[] tablero = tableroInicial.clone();
        tablero[0] = 0;

        resolver(tablero); 

        System.out.println("Mínimas fichas restantes: " + mejorResultado);
    }
	

	    
}

