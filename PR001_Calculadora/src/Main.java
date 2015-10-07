/**
 * Created by Usuario on 23/09/2015.
 */
public class Main {

    public static void main(String[] args) {
        Thread hilo;

        for(int i=1;i<11;i++){
            hilo = new Thread(new Calculadora(i));
            hilo.setName(String.format("Tabla del %d", i));
            hilo.setPriority(i);
            hilo.start();
        }

    }

}
