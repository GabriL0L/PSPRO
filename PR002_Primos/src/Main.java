/**
 * Created by Usuario on 28/09/2015.
 */
public class Main {

    public static void main(String[] args) {
        Thread hilo = new GeneradorPrimos();
        hilo.start();

        try{
          hilo.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        hilo.interrupt();
    }
}
