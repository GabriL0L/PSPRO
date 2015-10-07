import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 28/09/2015.
 */
public class Cargador implements Runnable{
    public void run(){
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

        System.out.printf("%s -> Cargando datos... \n",
                formateador.format(new Date()));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s -> Carga de datos finalizada\n",
                formateador.format(new Date()));
    }
}
