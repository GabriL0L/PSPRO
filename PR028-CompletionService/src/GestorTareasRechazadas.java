import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Usuario on 30/11/2015.
 */
public class GestorTareasRechazadas implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("%s rechazada por %s\n", r.toString(),executor.toString());
        System.out.printf("Ejecutor terminando? %s\n", executor.isTerminating());
        System.out.printf("Ejecutor finalizado? %s\n", executor.isTerminated());
    }
}
