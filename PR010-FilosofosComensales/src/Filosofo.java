/**
 * Created by Usuario on 21/10/2015.
 */
public class Filosofo extends Thread{
    private int numero;
    private Palillo izquierda, derecha;

    public Filosofo(int numero, Palillo izquierda, Palillo derecha){
        this.numero = numero;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public void run(){

        while(true) {
            try {
                if (numero % 2 == 0) {
                    Thread.sleep(3000); //pensar
                    izquierda.coger(numero);
                    derecha.coger(numero);
                    Thread.sleep(5000); //comer
                    izquierda.dejar(numero);
                    derecha.dejar(numero);
                } else {
                    Thread.sleep(3000);
                    derecha.coger(numero);
                    izquierda.coger(numero);
                    Thread.sleep(5000);
                    derecha.dejar(numero);
                    izquierda.dejar(numero);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
