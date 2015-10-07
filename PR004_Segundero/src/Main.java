import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 28/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        Segundero seg = new Segundero();
        Thread hilo = new Thread(seg);

        hilo.start();
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        hilo.interrupt();
    }
}
