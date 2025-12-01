import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public abstract class Alumno {
    private int CUI;
    private String nombre;
    private String email;
    private Map<Curso, List<Nota>> cursos;
    public Alumno(int CUI, String nombre, String email) {
        this.CUI = CUI;
        this.nombre = nombre;
        this.email = email;
        this.cursos = new HashMap<>();
    }
    public int getCUI() {
        return CUI;
    }
    public void setCUI(int CUI) {
        this.CUI = CUI;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Map<Curso, List<Nota>> getCursos() {
        return cursos;
    }

    public void setCursos(Map<Curso, List<Nota>> cursos) {
        this.cursos = cursos;
    }
    public void mostrarInformacion() {
        System.out.println("=== Información del Alumno ===");
        System.out.println("CUI: " + CUI);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Cantidad de cursos matriculados: " + cursos.size());
    }
    public abstract int creditosMaximos();
    public abstract double calcularPago();
    public void matricularCurso(Curso c) {
        if (c == null) {
            System.out.println("No se puede matricular en un curso nulo.");
            return;
        }
        if (!cursos.containsKey(c)) {
            cursos.put(c, new ArrayList<Nota>());
            System.out.println("Alumno " + nombre + " matriculado en el curso: " + c.getNombre());
        } else {
            System.out.println("El alumno ya está matriculado en este curso.");
        }
    }
}
