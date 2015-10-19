/**
 * Created by Usuario on 19/10/2015.
 */
public class Cine {
    private int[] butacasSalas;
    private Object[] mutexSalas;

    public Cine(int[] butacasSalas) {
        this.butacasSalas = butacasSalas;
        mutexSalas = new Object[butacasSalas.length];
        for (int i = 0; i < mutexSalas.length; i++) {
            mutexSalas[i] = new Object();
        }
    }

    public boolean vender(int sala, int cuantas) {
        if (sala < 0 || sala >= butacasSalas.length) {
            return false;
        }
        synchronized (mutexSalas[sala]) {
            if (cuantas <= butacasSalas[sala]) {
                butacasSalas[sala] -= cuantas;
                System.out.printf("Sala %d: %d entradas vendidas\n", sala,
                        cuantas);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean devolver(int sala, int cuantas) {
        if (sala < 0 || sala >= butacasSalas.length) {
            return false;
        }
        synchronized (mutexSalas[sala]) {
            butacasSalas[sala] += cuantas;
            System.out
                    .printf("Sala %d: %d entradas devueltas\n", sala, cuantas);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public int getLibres(int sala) {
        return butacasSalas[sala];
    }
}
