/**
 * Created by Usuario on 28/09/2015.
 */
public class GeneradorFactorial extends Thread{

    public void run(){
        double numero=0;
        while (true){
            try{

                System.out.printf("El factorial de %.0f es: %.0f\n", numero, calcularFactorial(numero));

             }catch(InterruptedException e){

                return;

            }
            numero++;
        }
    }

    public double calcularFactorial(double numero)throws InterruptedException{
        double factorial;

        if(isInterrupted()){
            System.out.println("El hilo está interrumpido.\n");
            throw new InterruptedException();
        }
        if(numero>1){
            factorial = numero * calcularFactorial(numero-1);
        }else{
            factorial = 1;
        }

        return factorial;
    }

}
