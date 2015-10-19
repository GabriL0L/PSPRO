/**
 * Created by Usuario on 19/10/2015.
 */
public class Main {
    public static void main(String[] args) {

        int salas[] = { 20, 20 };
        Cine cine = new Cine(salas);

        Thread hiloTaquilla1 = new Thread(new Taquilla1(cine), "Taquilla1");
        Thread hiloTaquilla2 = new Thread(new Taquilla2(cine), "Taquilla2");
        hiloTaquilla1.start();
        hiloTaquilla2.start();

        try {
            // Waits for the finalization of the threads
            hiloTaquilla1.join();
            hiloTaquilla2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numSalas = salas.length;
        for (int i = 0; i < numSalas; i++) {
            System.out.printf("Sala %d: %d butacas libres\n", i + 1,
                    cine.getLibres(i));
        }
    }
}
