import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Main {

    public static final int NUMERO_TAREAS = 10;

    public static void main(String[] args) {
        ThreadPoolExecutor executer = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> listaResultados = new ArrayList<>();
        Integer numeros[] = new Integer[NUMERO_TAREAS];
        Integer valor = null;
        Future<Integer> resultado;
        Random rnd = new Random();
        int i;

        for(i=0;i< NUMERO_TAREAS;i++){
            numeros[i] = new Integer(i);  //rnd.nextInt(NUMERO_TAREAS)
            CalculadoraFactorial calculadora = new CalculadoraFactorial(numeros[i]);
            listaResultados.add(executer.submit(calculadora));
        }

        executer.shutdown();
        try {
            executer.awaitTermination(150, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
