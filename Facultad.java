import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombre;
    private List<Carrera> carreras;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.carreras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCarrera(Carrera c) {
        this.carreras.add(c);
    }

    public boolean eliminarCarrera(String codigo) {
        return carreras.removeIf(c -> c.getCodigo().equals(codigo));
    }

    public Carrera buscarCarrera(String nombre) {
        for (Carrera c : carreras) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public List<Carrera> listarCarreras() {
        return this.carreras;
    }

    public void mostrarInformacion() {
        System.out.println(nombre);
    }
}
