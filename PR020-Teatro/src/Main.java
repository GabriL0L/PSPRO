import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 16/11/2015.
 */
/*
* Haciendo uso de un ejecutor simular la entrada de 50 clientes a un teatro donde cada uno de los clientes deben ser acomodados en su butaca por un acomodador. Realizar el ejercicio de dos maneras distintas suponiendo que:
* a) el teatro puede disponer de un número infinito de acomodadores.
* b) el teatro puede disponer como máximo de 3 acomodadores.
 */
public class Main {
    public static void main(String[] args) {
        Acomodador acomodador = new Acomodador();
        int i,num;

        for(i=0;i<50;i++){
            num = i+1;
            Cliente cliente = new Cliente(String.valueOf(num));
            acomodador.sentarCliente(cliente);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        acomodador.cerrarTeatro();
    }
}
