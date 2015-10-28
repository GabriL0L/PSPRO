/**
 * Created by Usuario on 28/10/2015.
 */
public class Alumno implements Runnable{

    private Clase clase;
    private int numero;

    public Alumno(Clase clase, int numero){
        this.clase = clase;
        this.numero = numero;
    }

    public void run(){
        clase.ocuparAsiento();
    }

    public int getNumero(){
        return numero;
    }

}
