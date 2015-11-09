/**
 * Created by Usuario on 04/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_HILOS = 5;
        int i = 0, numero = 0;
        ColaImpresion colaImpresion = new ColaImpresion();
        Thread hilos[] = new Thread[NUM_HILOS];
        for (i = 0; i < NUM_HILOS; i++){
            numero = i+1;
            hilos[i] = new Thread(new Trabajo(colaImpresion), "Impresión " + numero);
        }

        for (i = 0; i < NUM_HILOS; i++){
            hilos[i].start();
        }
    }
}
