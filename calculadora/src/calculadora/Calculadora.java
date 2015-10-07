package calculadora;

public class Calculadora implements Runnable{
	private int num;
	
	public Calculadora(int num){
		this.num = num;
	}
	
	public void run() {
		for(int i = 1; i < 10; i++){
			System.out.printf("%d * %d = %d\n",num,i,num*i);
		}
		
	}

}