import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 04/11/2015.
 */
public class Participante implements Runnable {

    // Videoconferencia.
    private Videoconferencia videoconferencia;
    // Nombre del participante.
    private String nombre;
    private int numeroParticipantes;
    // Generador de números aleatorios para simular la conexión.
    Random aleatorio = new Random();

    // Constructor. Recibe la videoconferencia y el nombre del participante.
    public Participante(Videoconferencia videoconferencia, String nombre) {
        this.videoconferencia = videoconferencia;
        this.nombre = nombre;
        numeroParticipantes = 2;
    }

    @Override
    public void run() {
        // Simulo la conexión al sistema de videoconferencia.
        int i;

        for(i=0;i< numeroParticipantes;i++){
            try {
                TimeUnit.SECONDS.sleep(aleatorio.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Me uno a la videoconferencia
            videoconferencia.unirse(nombre);
        }

    }

}
