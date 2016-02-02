import java.util.concurrent.*;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        //ExecutorService ejecutor = (ExecutorService) Executors.newCachedThreadPool();
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        GestorTareasRechazadas gestor = new GestorTareasRechazadas();
        CompletionService<String> servicio = new ExecutorCompletionService<>(ejecutor);
        Thread cliente1 = new Thread(new Cliente("Cliente 1", servicio));
        Thread cliente2 = new Thread(new Cliente("Cliente 2", servicio));
        Cartero carterito = new Cartero(servicio);
        Thread cartero = new Thread(carterito);

        ejecutor.setRejectedExecutionHandler(gestor);
        cliente1.start();
        cliente2.start();
        cartero.start();

        try {
            cliente1.join();
            cliente2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ejecutor.shutdown();

        try {
            ejecutor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        carterito.setFinalizar(true);

    }
}
