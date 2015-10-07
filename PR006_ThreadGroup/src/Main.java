import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup grupoCorredores = new ThreadGroup("Corredores");
        Marca marca = new Marca();
        Corredor corredor = new Corredor(marca);
        Thread[] arrayHilos = new Thread[10];
        int i,n;

        for(i = 0; i < 10; i++){
            Thread hilo = new Thread(grupoCorredores,corredor);
            n = i+1;
            hilo.setName("Corredor " + n);
            arrayHilos[i] = hilo;
        }

        for(i = 0; i < arrayHilos.length;i++){
            arrayHilos[i].start();
        }

        while(grupoCorredores.activeCount() == 10){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        grupoCorredores.interrupt();

    }
}
