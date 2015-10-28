import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        int numero,n=5,precio = 100;
        Producto producto = new Producto(precio);
        Thread hilosClientes[]= new Thread[n];
        Thread hiloTienda = new Thread(new Tienda(producto), "Tienda");


        for (int i = 0; i < n; i++) {
            numero = i+1;
            hilosClientes[i] = new Thread(new Cliente(producto), "Cliente " + numero);
        }

        hiloTienda.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++){
            hilosClientes[i].start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 2; i < n; i++){
            hilosClientes[i].start();
        }

    }

}
