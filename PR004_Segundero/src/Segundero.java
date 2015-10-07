import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 28/09/2015.
 */
public class Segundero implements Runnable{

    public void run(){
        Date fecha;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        while(true) {
            fecha = new Date();
            System.out.printf("%s",sdf.format(fecha));
            System.out.println();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("El hilo ha sido interrumpido.");
                return;
            }
        }
    }

}
