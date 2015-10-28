import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Impresora {

    //private ReentrantLock cerrojo = new ReentrantLock();
    private ReentrantLock cerrojo = new ReentrantLock(true);

    public void imprimir(String texto){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Random aleatorio = new Random();

        if (cerrojo.tryLock()) {

            //System.out.printf("%s: Impresión iniciada [%s]\n", Thread.currentThread().getName(), sdf.format(new Date()));
            try {
                System.out.printf("%s imprime %s [%s]\n", Thread.currentThread().getName(),texto, sdf.format(new Date()));
                TimeUnit.SECONDS.sleep(aleatorio.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("%s ha finalizado [%s]\n", Thread.currentThread().getName(), sdf.format(new Date()));

                cerrojo.unlock();
            }
        } else{
            System.out.printf("%s no ha podido imprimir. [%s]\n", Thread.currentThread().getName(),sdf.format(new Date()));
        }
    }

}
