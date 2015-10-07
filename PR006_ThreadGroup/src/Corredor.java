import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Corredor implements Runnable{

    private static int num = 1;
    private Marca ganador;

    public Corredor(Marca ganador){
        this.ganador = ganador;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        try{
            TimeUnit.SECONDS.sleep(rnd.nextInt(30));
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " no ha llegado a la meta.");
            return;
        }

        ganador.setMarca(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " ha ganado la carrera.");
    }
}
