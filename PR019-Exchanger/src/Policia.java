import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Policia implements Runnable{

    private ArrayList<String> buffer;
    private final Exchanger<ArrayList<String>> intercambiador;

    public Policia(ArrayList<String> buffer,Exchanger<ArrayList<String>> intercambiador){
        this.buffer = buffer;
        this.intercambiador = intercambiador;
    }

    @Override
    public void run() {
        int i,j;
        String rehen;

        for(i=0;i<10;i++){
            System.out.println("Terrorista -> fase " + i);

            try {
                System.out.println("Intercambio...");
                buffer = intercambiador.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(j=0;j<10;j++){
                rehen = buffer.get(0);
                System.out.println("Rescatado " + rehen);
                buffer.remove(0);
            }

        }

    }
}
