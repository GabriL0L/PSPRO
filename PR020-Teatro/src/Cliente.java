import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Cliente implements Runnable{
    String nombre;
    Random rnd;

    public Cliente(String nombre){
        this.nombre = nombre;
        rnd = new Random();
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s acomoda al cliente %s\n",Thread.currentThread().getName(),nombre);
    }
}
