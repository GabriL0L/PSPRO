import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 04/11/2015.
 */
public class ColaImpresion {

    private final int NUM_IMPRESORAS = 3;
    private final Semaphore semaforo;
    private boolean disponible[];
    private ReentrantLock cerrojo;
    private Random rnd;

    public ColaImpresion(){
        semaforo = new Semaphore(NUM_IMPRESORAS);
        disponible = new boolean[NUM_IMPRESORAS];
        Arrays.fill(disponible, true);
        cerrojo = new ReentrantLock();
        rnd = new Random();
    }

    public void imprimir(){
        int impresora;

        try {
            // Obtengo el semáforo.
            semaforo.acquire();
            // Obtengo el número de impresora a usar.
            impresora = seleccionarImpresora();
            System.out.printf("Impresora %d ocupada por %s\n", impresora+1, Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(rnd.nextInt(5));
            // Libero la impresora
            System.out.printf("Impresora %d liberada por %s\n", impresora+1, Thread.currentThread().getName());
            disponible[impresora] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Libero el semáforo.
            semaforo.release();
        }

    }

   private int seleccionarImpresora(){
        int impresora = -1;
        boolean salir = false;
        int i = 0;

        try {
            // Obtengo el cerrojo de sincronización para el array.
            cerrojo.lock();
            // Recorro el array y obtengo la primera impresora disponible.
            for (i = 0; i < disponible.length && !salir; i++) {
                if (disponible[i]){
                    impresora = i;
                    disponible[i] = false;
                    salir = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Libero el acceso al array
            cerrojo.unlock();
        }

        return impresora;
    }

}
