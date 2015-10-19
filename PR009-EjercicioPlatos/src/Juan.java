/**
 * Created by Usuario on 19/10/2015.
 */
public class Juan extends Thread{

    private PilaPlatos platosLimpios;
    private PilaPlatos platosSecos;

    public Juan(PilaPlatos platosLimpios,PilaPlatos platosSecos){
        super();
        this.platosLimpios = platosLimpios;
        this.platosSecos = platosSecos;
    }

    public void run(){
        Integer elemento;

        while (true) {
            try {
                elemento = platosLimpios.sacar();
                System.out.println("Cogido plato limpio: " + elemento);
                Thread.sleep(3000);
                System.out.println("Nuevo plato seco: " + elemento);
                platosSecos.meter(elemento);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
