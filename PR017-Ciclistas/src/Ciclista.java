import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Ciclista implements Runnable{
    private final CyclicBarrier barrera;

    public Ciclista(CyclicBarrier barrera){
        this.barrera = barrera;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        System.out.printf("%s inicia el camino.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(5));
            System.out.printf("%s llega a la salida.\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                barrera.await();
                System.out.println("Comienza la carrera.");
                TimeUnit.SECONDS.sleep(rnd.nextInt(5));
                System.out.printf("%s llega a la meta.\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
