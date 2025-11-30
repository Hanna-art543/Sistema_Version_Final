import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Sucursal> sucursales;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal s) {
        this.sucursales.add(s);
    }

    public boolean eliminarSucursal(String nombre) {
        return sucursales.removeIf(s -> s.getNombre().equals(nombre));
    }

    public List<Sucursal> listarSucursales() {
        return this.sucursales;
    }

    public Alumno buscarAlumnoPorCUI(int CUI) {
        for (Sucursal s : sucursales) {
            for (Facultad f : s.listarFacultades()) {
                for (Carrera c : f.listarCarreras()) {
                    Alumno a = c.buscarAlumno(CUI);
                    if (a != null) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    public void mostrarInformacion() {
        System.out.println(nombre);
    }
}