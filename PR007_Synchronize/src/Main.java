/**
 * Created by Usuario on 14/10/2015.
 */
public class Main {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000);
        Thread hilo1 = new Thread(new Banco(cuenta));
        Thread hilo2 = new Thread(new Empresa(cuenta));

        hilo1.start();
        hilo2.start();
    }

}
