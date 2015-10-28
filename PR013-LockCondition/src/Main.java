/**
 * Created by Usuario on 19/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        PilaPlatos platosLimpios = new PilaPlatos();
        PilaPlatos platosSecos = new PilaPlatos();
        Pedro pedro = new Pedro(platosLimpios);
        Juan juan = new Juan(platosLimpios,platosSecos);
        Antonio antonio = new Antonio(platosSecos);

        pedro.start();
        juan.start();
        antonio.start();

    }
}
