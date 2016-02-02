import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 30/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        Tarea tarea = new Tarea(1, 10);
        ForkJoinPool ejecutor = new ForkJoinPool();

        ejecutor.execute(tarea);

        do {
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!tarea.isDone());

        /*try {
            ejecutor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ejecutor.shutdown();

        if(tarea.isCompletedNormally()){
            System.out.println("La tarea se ha completado sin problemas.");
        }else{
            System.out.println("La tarea ha tenido problemas.");
        }

    }
}
