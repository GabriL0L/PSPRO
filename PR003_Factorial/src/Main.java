/**
 * Created by Usuario on 28/09/2015.
 */
public class Main {

    public static void main(String[] args) {
        Thread hilo = new GeneradorFactorial();
        hilo.start();

        try{
            hilo.sleep(300);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        hilo.interrupt();
    }

}
