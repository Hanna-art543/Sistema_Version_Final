import java.util.ArrayList;
import java.util.List;

public class Carrera {
    // ATRIBUTOS
    private String nombre;
    private String codigo;
    private int duracion;
    private List<Curso> cursos;
    private List<Alumno> alumnos;

    // CONSTRUCTOR DE INSTANCIA
    public Carrera(String nombre, String codigo, int duracion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.duracion = duracion;
        this.cursos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public List<Curso> getCursos() { // Agregar Getter para Cursos
        return cursos;
    }
    
    // FUNCIONES PARA CURSOS
    public void agregarCurso(Curso c) {
        if (c != null) {
            this.cursos.add(c);
        }
    }

    public boolean eliminarCurso(String codigo) {
        return this.cursos.removeIf(c -> c.getCodigo().equals(codigo));
    }

    public Curso buscarCurso(String nombre) {
        for (Curso c : cursos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public List<Curso> listarCursos() {
        return this.cursos;
    }

    // FUNCIONES PARA ALUMNOS
    public void agregarAlumno(Alumno alumno) {
        if (alumno != null) {
            this.alumnos.add(alumno);
        }
    }

    public boolean eliminarAlumno(int CUI) {
        return this.alumnos.removeIf(a -> a.getCUI() == CUI);
    }

    public List<Alumno> listarAlumnos() {
        return this.alumnos;
    }

    public Alumno buscarAlumno(int CUI) { // Implementación correcta de búsqueda por CUI
        for (Alumno a : alumnos) {
            if (a.getCUI() == CUI) {
                return a;
            }
        }
        return null;
    }

    public int obtenerDuracion() {
        return this.duracion;
    }

    public void mostrarInformacion() {
        System.out.println("Carrera: " + nombre + " [" + codigo + "], Duración: " + duracion + " ciclos");
        System.out.println("Alumnos matriculados: " + alumnos.size());
        System.out.println("Cursos: " + cursos.size());
    }
}
