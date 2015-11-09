/**
 * Created by Usuario on 04/11/2015.
 */
public class Trabajo implements Runnable{

    private ColaImpresion colaImpresion;

    public Trabajo(ColaImpresion colaImpresion){
        this.colaImpresion = colaImpresion;
    }

    @Override
    public void run() {
        colaImpresion.imprimir();
    }

}
