package calculadora;

public class Main {

	public static void main(String[] args) {
		Thread hilo;
		
		for(int i=1;i<10;i++){
			hilo = new Thread(new Calculadora(i));
			hilo.start();
		}

	}

}
