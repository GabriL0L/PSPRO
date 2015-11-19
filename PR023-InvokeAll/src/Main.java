import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Main {

    public static final int NUMERO_TAREAS = 10;

    public static void main(String[] args) {
        ExecutorService executer = (ExecutorService) Executors.newCachedThreadPool();
        List<Future<Integer>> listaResultados = new ArrayList<>();
        ArrayList<CalculadoraFactorial> listaTareas = new ArrayList<>();
        Integer numeros[] = new Integer[NUMERO_TAREAS];
        Integer valor = null;
        Future<Integer> resultado;
        Random rnd = new Random();
        int i;

        for(i=0;i< NUMERO_TAREAS;i++){
            numeros[i] = new Integer(i);  //rnd.nextInt(NUMERO_TAREAS)
            CalculadoraFactorial calculadora = new CalculadoraFactorial(numeros[i]);
            listaTareas.add(calculadora);
        }

        try {
            listaResultados = executer.invokeAll(listaTareas);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executer.shutdown();

        for(i=0;i< NUMERO_TAREAS;i++){
           resultado = listaResultados.get(i);

            try {
                valor = resultado.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Factorial de %d = %d\n",numeros[i],valor);

        }

    }
}
