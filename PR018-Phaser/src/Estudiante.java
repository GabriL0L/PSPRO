import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Estudiante implements Runnable{

    private Phaser phaser;
    private final int TAREAS = 5;

    public Estudiante(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        int i=0;
        Random rnd = new Random();

        System.out.printf("%s se ha sentado.\n",Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        for(i=0;i<TAREAS;i++){
            try {
                System.out.printf("%s empieza a hacer el ejercicio %d.\n",Thread.currentThread().getName(),i+1);
                TimeUnit.SECONDS.sleep(rnd.nextInt(5));
                System.out.printf("%s ha acabado de hacer el ejercicio %d.\n", Thread.currentThread().getName(), i+1);
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.printf("%s entrega el examen.\n", Thread.currentThread().getName());
        phaser.arriveAndDeregister();

    }
}
