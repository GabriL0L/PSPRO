/**
 * Created by Usuario on 23/09/2015.
 */

public class Calculadora implements Runnable{
    private int num;

    public Calculadora(int num){
        this.num = num;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(int i = 1; i < 11; i++){
            System.out.printf("%d * %d = %d\n",num,i,num*i);
        }

    }

}