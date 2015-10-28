import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 19/10/2015.
 */
public class PilaPlatos {

    private ArrayList<Integer> lista = new ArrayList<Integer>();
    private ReentrantLock candado = new ReentrantLock();
    private Condition hayPlatos = candado.newCondition();

    public void meter(Integer elemento){
        candado.lock();

        lista.add(elemento);
        System.out.println("Almacenado: " + elemento);
        hayPlatos.signalAll();

        candado.unlock();

    }

    public Integer sacar() throws InterruptedException{
        Integer elemento;

        candado.lock();

        while(lista.isEmpty()){
            hayPlatos.await();
        }
        elemento = lista.remove(lista.size()-1);
        System.out.println("Extraido: " + elemento);

        candado.unlock();

        return elemento;
    }
}
