import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Cartero implements Runnable{

    private CompletionService<String> servicio;
    private boolean finalizar;

    public Cartero(CompletionService<String> servicio) {
        this.servicio = servicio;
        finalizar = false;
    }

    @Override
    public void run() {

        while (!finalizar) {
            try {
                Future<String> resultado = servicio.poll(20, TimeUnit.SECONDS);
                if (resultado != null) {
                    String informe = resultado.get();
                    System.out.printf("Cartero recibe %s\n", informe);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Cartero se va a entregar la carta...\n");
    }

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

}
