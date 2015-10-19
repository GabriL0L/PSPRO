import java.util.ArrayList;

/**
 * Created by Usuario on 19/10/2015.
 */
public class Pedro extends Thread{
    private PilaPlatos platosLimpios;
    private int contador=0;
    private static final int LIMITE = 10;

    public Pedro(PilaPlatos platosLimpios){
        super();
        this.platosLimpios = platosLimpios;
    }

    public void run(){
        Integer elemento;

        while (contador <= LIMITE) {
            try {
                elemento = new Integer(contador++);
                System.out.println("Nuevo plato limpio: " + elemento);
                platosLimpios.meter(elemento);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
