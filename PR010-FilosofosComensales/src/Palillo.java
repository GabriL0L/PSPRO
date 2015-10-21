/**
 * Created by Usuario on 21/10/2015.
 */
public class Palillo {
    private int numero;
    private boolean disponible = true;

    public Palillo(int numero){
        this.numero = numero;
    }

    public synchronized void coger(int comensal) throws InterruptedException{
        while(!disponible){
            wait();
        }
        disponible = false;

        System.out.printf("El comensal %d ha cogido el palillo %d.\n",comensal+1,numero+1);
    }

    public synchronized void dejar(int comensal){
        disponible = true;
        notifyAll();
        System.out.printf("El comensal %d ha dejado el palillo %d.\n",comensal+1,numero+1);
    }

}
