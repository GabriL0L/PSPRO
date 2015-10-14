/**
 * Created by Usuario on 14/10/2015.
 */
public class Banco implements Runnable{

    private Cuenta cuenta;

    public Banco(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        int i=0;

        for(i=0;i<10;i++){
            cuenta.ingresar(10);
        }

    }
}
