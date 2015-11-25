import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Enviar implements Callable{
    private String nombreSolicitante;
    private String titulo;


    public Enviar(String nombreSolicitante, String titulo) {
        this.nombreSolicitante = nombreSolicitante;
        this.titulo = titulo;
    }

    @Override
    public String call() throws Exception {
        Random rnd = new Random();

        try {
            System.out.printf("%s del cliente %s ha llegado a la oficina.\n", this.titulo, this.nombreSolicitante);
            TimeUnit.SECONDS.sleep(rnd.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String informe = titulo + " de " + nombreSolicitante;
        return informe;
    }
}
