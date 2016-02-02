import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Usuario on 30/11/2015.
 */
public class Tarea extends RecursiveAction {
    private int desde;
    private int hasta;

    public Tarea(int desde, int hasta){
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    protected void compute() {
        int mitad;

        if(hasta == desde){
            mostrarTabla();
        }else{
            mitad = (hasta + desde)/2;

            Tarea subtarea1 = new Tarea(desde, mitad);
            Tarea subtarea2 = new Tarea(mitad+1, hasta);

            invokeAll(subtarea1,subtarea2);
        }

    }

    private void mostrarTabla() {
        int i,j;

        System.out.printf("Tabla del %d\n",desde);

        for(i=1;i<11;i++){
            System.out.printf("%d x %d = %d\n",desde,i,desde*i);
        }

        /*for(i=desde;i<hasta;i++){
            System.out.printf("Tabla del %d\n",i);
            for(j=1;j<11;j++){
              System.out.printf("%d x %d = %d\n",i,j,i*j);
            }
        }*/
    }
}
