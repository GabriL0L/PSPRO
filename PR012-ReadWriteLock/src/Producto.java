import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Producto {

    private double precio;

    private ReadWriteLock cerrojo = new ReentrantReadWriteLock();



    public Producto(double precio){
        this.precio = precio;
    }


    public double getPrecio() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        cerrojo.readLock().lock();

        System.out.printf("%s -> %s - Consultando precio...\n", sdf.format(new Date()), Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            double valor = precio;

            System.out.printf("%s -> %s - Precio: %.2f\n", sdf.format(new Date()), Thread.currentThread().getName(), valor);

            cerrojo.readLock().unlock();
            return valor;
        }

    }

    public void setPrecio(double precio) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        cerrojo.writeLock().lock();

        System.out.printf("%s -> %s - Cambiando precio...\n", sdf.format(new Date()), Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            this.precio = precio;
            System.out.printf("%s -> %s - Nuevo Precio: %.2f\n", sdf.format(new Date()), Thread.currentThread().getName(), this.precio);
            cerrojo.writeLock().unlock();
        }

    }
}
