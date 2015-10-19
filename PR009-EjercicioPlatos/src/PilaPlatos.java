import java.util.ArrayList;

/**
 * Created by Usuario on 19/10/2015.
 */
public class PilaPlatos {

    private ArrayList<Integer> lista = new ArrayList<Integer>();
    private Object candado = new Object();

    public void meter(Integer elemento) throws InterruptedException{
        synchronized(candado) {
                lista.add(elemento);
                System.out.println("Almacenado: " + elemento);
                candado.notifyAll();
        }
    }

    public Integer sacar() throws InterruptedException{
        Integer elemento;
        synchronized(candado){
            while(lista.isEmpty()){
                candado.wait();
            }
            elemento = lista.remove(lista.size()-1);
            System.out.println("Extraido: " + elemento);
            candado.notifyAll();
            return elemento;
        }
    }
}
