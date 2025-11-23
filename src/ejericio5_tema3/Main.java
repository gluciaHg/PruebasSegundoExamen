package ejericio5_tema3;

public class Main {
	
	
	public static void main(String[] args) {
		
		Tenedor t1 = new Tenedor();
		Tenedor t2 = new Tenedor();
		Tenedor t3 = new Tenedor();
		Tenedor t4 = new Tenedor();
		Tenedor t5 = new Tenedor();

		
		Filosofo f1 = new Filosofo(1, t1, t2, false);
		Filosofo f2 = new Filosofo(2, t2, t3, false);
		Filosofo f3 = new Filosofo(3, t3, t4, false);
		Filosofo f4 = new Filosofo(4, t4, t5, false);
		Filosofo f5 = new Filosofo(5, t5, t1, true);

		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();

		
		
	}
}
