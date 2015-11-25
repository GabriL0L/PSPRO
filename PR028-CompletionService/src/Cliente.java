import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Cliente implements Runnable{
    private String nombre;
    private CompletionService<String> servicio;

    public Cliente(String nombre, CompletionService<String> servicio){
        this.nombre = nombre;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        String titulo = "carta";
        Enviar envio = new Enviar(nombre,titulo);

        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(5));
            System.out.printf("%s envia %s\n", nombre,titulo);
            servicio.submit(envio);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
