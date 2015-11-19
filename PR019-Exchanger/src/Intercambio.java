import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Intercambio {
    public static void main(String[] args) {

       ArrayList<String> buffer1 = new ArrayList<>();
        ArrayList<String> buffer2 = new ArrayList<>();

        Exchanger<ArrayList<String>> intercambiador = new Exchanger<>();

        Thread hiloTerrorista = new Thread(new Terrorista(buffer1, intercambiador));
        Thread hiloPolicia= new Thread(new Policia(buffer2, intercambiador));
        hiloTerrorista.start();
        hiloPolicia.start();
    }
}
