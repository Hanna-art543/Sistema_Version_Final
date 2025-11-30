import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private String tipoSede;
    private String ciudad;
    private String direccion;
    private List<Facultad> facultades;

    public Sucursal(String nombre, String tipoSede, String ciudad, String direccion) {
        this.nombre = nombre;
        this.tipoSede = tipoSede;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.facultades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarFacultad(Facultad f) {
        this.facultades.add(f);
    }

    public boolean eliminarFacultad(String nombre) {
        return facultades.removeIf(f -> f.getNombre().equals(nombre));
    }

    public Facultad buscarFacultad(String nombre) {
        for (Facultad f : facultades) {
            if (f.getNombre().equalsIgnoreCase(nombre)) {
                return f;
            }
        }
        return null;
    }

    public List<Facultad> listarFacultades() {
        return this.facultades;
    }

    public void mostrarInformacion() {
        System.out.println(nombre + " - " + ciudad);
    }
}