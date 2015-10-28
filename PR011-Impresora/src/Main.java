/**
 * Created by Usuario on 26/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        int i=0,n=10,hilo=0;
        Impresora impresora = new Impresora();
        Thread hilos[] = new Thread[n];

        for(i=0;i<n;i++ ){
            hilos[i] = new Thread(new Trabajo(impresora));
            hilo = i+1;
            hilos[i].setName("Hilo " + hilo);
        }

        for(i=0;i<n;i++){
            hilos[i].start();
        }
    }
}
