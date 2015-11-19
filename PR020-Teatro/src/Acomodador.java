import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Acomodador {
    private ThreadPoolExecutor executer;

    public Acomodador(){
        //executer = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executer = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    }

    public void sentarCliente(Cliente cliente){
        executer.execute(cliente);
    }

    public void cerrarTeatro(){
        executer.shutdown();
    }

}
