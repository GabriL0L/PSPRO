import java.io.Serializable;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Persona implements Serializable{
    private String nombre;
    private int telefono;
    private String direccion;
    private int cod_postal;
    private boolean debo;
    private float deber;

    public Persona(String nombre, int telefono, String direccion, int cod_postal,boolean debo,float deber){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cod_postal = cod_postal;
        this.debo = debo;
        this.deber = deber;
    }

    public String toString(){
        return String.format("Nombre: %s\nTeléfono: %d\nDirección: %s\nCódigo Postal: %d\n¿Le debo dinero? %s\nDinero a deber: %.1f",
                nombre,telefono,direccion,cod_postal,debo?"Si":"No",deber);
    }
}
