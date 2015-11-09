import java.util.concurrent.CyclicBarrier;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        final int CORREDORES = 5;
        int i,numero;
        Salida salida = new Salida();
        CyclicBarrier barrera = new CyclicBarrier(CORREDORES,salida);
        Thread hilos[] = new Thread[CORREDORES];

        for(i=0;i<CORREDORES;i++){
            numero = i+1;
            hilos[i] = new Thread(new Ciclista(barrera),"Ciclista " + numero);
            hilos[i].start();
        }

        for(i=0;i<CORREDORES;i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Los corredores han llegado a la meta.");

    }
}
