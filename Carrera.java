import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private String codigo;
    private int duracion;
    private List<Curso> cursos;
    private List<Alumno> alumnos;

    public Carrera(String nombre, String codigo, int duracion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.duracion = duracion;
        this.cursos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void agregarCurso(Curso c) {
        this.cursos.add(c);
    }

    public boolean eliminarCurso(String codigo) {
        return false;
    }

    public Curso buscarCurso(String nombre) {
        return null;
    }

    public List<Curso> listarCursos() {
        return this.cursos;
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public boolean eliminarAlumno(int CUI) {
        return false;
    }

    public List<Alumno> listarAlumnos() {
        return this.alumnos;
    }

    public Alumno buscarAlumno(int CUI) {
        return null;
    }

    public Alumno buscarAlumno() {
        return null;
    }

    public int obtenerDuracion() {
        return this.duracion;
    }

    public void mostrarInformacion() {
        System.out.println(nombre + " " + codigo);
    }
}
