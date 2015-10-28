import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Trabajo implements Runnable{

    private Impresora impresora;

    public Trabajo(Impresora impresora){
        this.impresora = impresora;
    }

    public void run(){
        Random rnd = new Random();
        try{
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        impresora.imprimir("\"prueba\"");
    }
}
