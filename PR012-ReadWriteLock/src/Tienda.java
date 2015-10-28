/**
 * Created by Usuario on 26/10/2015.
 */
public class Tienda implements Runnable {

    private Producto producto;

    public Tienda(Producto producto){
        this.producto = producto;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            producto.setPrecio(producto.getPrecio() + 50);
        }
    }

}


