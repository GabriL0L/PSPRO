/**
 * Created by Usuario on 28/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        Cargador cargador = new Cargador();
        Thread hilo_cargador = new Thread(cargador,"Hilo del cargador");
        Conector conector = new Conector();
        Thread hilo_conector = new Thread (conector,"Hilo del conector");
        hilo_cargador.start();
        hilo_conector.start();

        try{
            hilo_cargador.join();
            hilo_conector.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
