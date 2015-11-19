import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService ejecutor = (ExecutorService) Executors.newCachedThreadPool();
        int i;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        for (i = 0; i < 15; i++) {
            Alumno alumno = new Alumno("A" + i);
            listaAlumnos.add(alumno);
        }

        try {
           System.out.printf("%s entrega primero el rotulador y tendrá un 10 de nota.\n", ejecutor.invokeAny(listaAlumnos));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ejecutor.shutdown();

    }
}
