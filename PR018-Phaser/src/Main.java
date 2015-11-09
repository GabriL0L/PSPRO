import java.util.concurrent.Phaser;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_ALUMNOS = 10;
        Thread hilos[] = new Thread[NUM_ALUMNOS];
        //Phaser phaser = new Phaser(NUM_ALUMNOS);
        Secuenciador phaser = new Secuenciador(NUM_ALUMNOS);
        int i,numero;

        for(i=0;i<NUM_ALUMNOS;i++){
            numero = i+1;
            hilos[i] = new Thread(new Estudiante(phaser),"Estudiante " + numero);
            hilos[i].start();
        }

        for(i=0;i<NUM_ALUMNOS;i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los exámenes han sido entregados.");

    }
}
