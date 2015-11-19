import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 18/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executer = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 5; i++) {
            Tarea tarea = new Tarea("Tarea " + i);
            System.out.printf("%s -> Enviada en: %s\n", "Tarea " + i, new Date());
            executer.schedule(tarea, i + 1, TimeUnit.SECONDS);
        }

        executer.shutdown();

        try {
            executer.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Todas las tareas finalizadas en: %s\n", new Date());
    }
}
