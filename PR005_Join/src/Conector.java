import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 28/09/2015.
 */
public class Conector implements Runnable{
    public void run(){

        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

        System.out.printf("%s -> Conectando...\n",
                formateador.format(new Date()));

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s -> Conexión establecida\n",
                formateador.format(new Date()));
    }
}
