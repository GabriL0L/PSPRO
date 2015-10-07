import java.io.*;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Agenda {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan",666554422,"C/ Falsa 123",11200,false,0);
        File fichero = new File("Agenda.data");
        Persona p2;
        try {
            ObjectOutputStream dataOS = new ObjectOutputStream(new FileOutputStream(fichero));
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
            dataOS.writeObject(p1);
            p2 = (Persona) dataIS.readObject();
            System.out.println(p2.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
