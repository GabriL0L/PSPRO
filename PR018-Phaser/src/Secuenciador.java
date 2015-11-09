import java.util.concurrent.Phaser;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Secuenciador extends Phaser {

    public Secuenciador(int alumnos){
        super(alumnos);
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch(phase){
            case 0:
                return inicioExamen();
            case 1:
                return finalizarEjercicio(phase);
            case 2:
                return finalizarEjercicio(phase);
            case 3:
                return finalizarEjercicio(phase);
            case 4:
                return finalizarEjercicio(phase);
            case 5:
                return finalizarEjercicio(phase);
            case 6:
                return finalizarExamen();
            default:
                return true;
        }
    }

    public boolean inicioExamen(){
        System.out.println("Comienza el examen.");
        System.out.println("Entregando ejercicio 1.");

        return false;
    }

    public boolean finalizarEjercicio(int numero){
        int aux;

        System.out.println("Finalizado ejercicio " + numero + ".");
        aux = numero+1;
        System.out.println("Entregando ejercicio " + aux + ".");

        return false;
    }

    public boolean finalizarExamen(){
        System.out.println("Finaliza el examen.");
        return true;
    }

}
