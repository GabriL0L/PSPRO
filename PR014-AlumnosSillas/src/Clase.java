import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 28/10/2015.
 */
public class Clase {

    private final int NUM_ASIENTOS = 8;
    private final Semaphore semaforo = new Semaphore(NUM_ASIENTOS);
    private boolean disponible[];
    private ReentrantLock cerrojo = new ReentrantLock();
    private Random rnd;

    public Clase(){
        /*disponible = new boolean[NUM_ASIENTOS];
        Arrays.fill(disponible, true);*/
        rnd = new Random();
    }

    public void ocuparAsiento(){
        try {
            semaforo.acquire();
            System.out.printf("%s ha entrado en la clase. Asientos disponibles: %d\n", Thread.currentThread().getName(), semaforo.availablePermits());
            TimeUnit.SECONDS.sleep(rnd.nextInt(5));
            System.out.printf("%s ha salido de clase. Asientos disponibles: %d\n", Thread.currentThread().getName(), semaforo.availablePermits()+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
        }
    }

   /* public void ocuparAsiento(){
        int asiento;

        try {
            // Obtengo el semáforo.
            semaforo.acquire();
            // Obtengo el número de silla a ocupar por el alumno.
            asiento = getSilla();
            System.out.printf("Asiento %d ocupado por %s\n", asiento, Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
            // Libero el asiento
            disponible[asiento] = true;
            System.out.printf("Asiento %d liberado por %s\n", asiento, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Libero el semáforo.
            semaforo.release();
        }

    }*/

   /* private int getSilla(){
        int silla = -1;

        try {
            // Obtengo el cerrojo de sincronización para el array.
            cerrojo.lock();
            // Recorro el array y obtengo la primera impresora disponible.
            for (int i = 0; i < disponible.length; i++) {
                if (disponible[i]){
                    silla = i;
                    disponible[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Libero el acceso al array
            cerrojo.unlock();
        }

        return silla;
    }*/

}
