import java.util.concurrent.Callable;

/**
 * Created by Usuario on 16/11/2015.
 */
public class CalculadoraFactorial implements Callable<Integer>{

    private Integer numero;

    public CalculadoraFactorial(Integer numero){
        this.numero = numero;
    }

    @Override
    public Integer call() throws Exception {
        int factorial = 1,i;

        if(numero == 0 || numero == 1){
            factorial = 1;
        }else{
            for(i=2;i<=numero;i++){
                factorial *= i;
            }
        }

        return factorial;
    }
}
