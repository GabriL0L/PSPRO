/**
 * Created by Usuario on 26/10/2015.
 */
public class Cliente implements Runnable {

    private Producto producto;

    public Cliente (Producto producto){
        this.producto = producto;
    }

    public void run() {
        double precio = producto.getPrecio();
    }

}
