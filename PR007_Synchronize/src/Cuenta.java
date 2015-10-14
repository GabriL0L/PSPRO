/**
 * Created by Usuario on 14/10/2015.
 */
public class Cuenta {

    private double saldo;

    public Cuenta (double saldo){
        this.saldo = saldo;
    }


    public void ingresar(double cantidad){
        synchronized(this){
            saldo += cantidad;
            System.out.println("Ingreso realizado. Saldo actual: " + saldo);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void cargar(double cantidad){
        synchronized(this){
            saldo -= cantidad;
            System.out.println("Cargo realizado. Saldo actual: " + saldo);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*public synchronized void ingresar(double cantidad){
        saldo += cantidad;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ingreso realizado. Saldo actual: " + saldo);
    }

    public synchronized void cargar(double cantidad){
        saldo -= cantidad;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cargo realizado. Saldo actual: " + saldo);
    }*/

}
