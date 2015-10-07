/**
 * Created by Usuario on 28/09/2015.
 */
public class GeneradorPrimos extends Thread{

    public void run(){
        int numero=1;
        System.out.println("Números primos: \n");
        while(true){
             try{
                mostrarPrimo(numero);
            }catch(InterruptedException e){
                return;
            }
            numero++;
        }

    }

    private boolean esPrimo(int numero){
        int i;

        if(numero <= 2){
            return true;
        }

        for(i=2;i<numero ;i++){
            if((numero%i)==0)
                return false;
        }

        return true;
    }

    private void mostrarPrimo(int numero) throws InterruptedException{
        if(esPrimo(numero)){
            System.out.printf("El número %d es primo.\n",numero);
        }

        if(isInterrupted()){
            System.out.println("El hilo está interrumpido.\n");
            throw new InterruptedException();
        }
    }

}
