/**
 * Created by Usuario on 19/10/2015.
 */
public class Antonio extends Thread{

    private PilaPlatos platosSecos;

    public Antonio(PilaPlatos platosSecos){
        super();
        this.platosSecos = platosSecos;
    }

    public void run(){
        Integer elemento;
        while (true) {
            try {
                elemento = platosSecos.sacar();
                System.out.println("Cogido y guardado plato seco: " + elemento);
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
