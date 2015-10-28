/**
 * Created by Usuario on 28/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_ALUMNOS = 20;
        Clase clase = new Clase();
        Thread hilos[] = new Thread[NUM_ALUMNOS];
        int i=0,numero=0;

        for(i=0;i<NUM_ALUMNOS;i++){
            numero = i+1;
            hilos[i] = new Thread(new Alumno(clase,i+1),"Alumno " + numero);
        }

        for(i=0;i<NUM_ALUMNOS;i++){
            hilos[i].start();
        }

    }
}
