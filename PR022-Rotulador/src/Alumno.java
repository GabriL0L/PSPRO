import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Alumno implements Callable<String> {
    private String nombre;

    public Alumno(String nombre){
        this.nombre = nombre;
    }


    @Override
    public String call() throws Exception {
        Random rnd = new Random();

        System.out.printf("%s va a buscar un rotulador.\n",nombre);
        TimeUnit.SECONDS.sleep(rnd.nextInt(10));

        return nombre;
    }
}
