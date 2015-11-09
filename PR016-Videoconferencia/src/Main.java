/**
 * Created by Usuario on 04/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        Videoconferencia videoconferencia = new Videoconferencia(10);
        Thread hiloVideoconferencia = new Thread(videoconferencia);
        Thread hiloParticipante;
        Participante participante;
        hiloVideoconferencia.start();
        // Creo e inicio un hilo para cada uno de los diez participantes.
        for (int i = 0; i < 5; i++) {
            participante = new Participante(videoconferencia, "País " + i);
            hiloParticipante = new Thread(participante);
            hiloParticipante.start();
        }
    }
}
