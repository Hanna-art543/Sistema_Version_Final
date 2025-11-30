import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorNotas {

    private Map<Alumno, Map<Curso, List<Nota>>> registroNotas;
    private static final double NOTA_APROBATORIA_CURSO = 11.0;

    public GestorNotas() {
        this.registroNotas = new HashMap<>();
    }

    // Nota para un alumno en un curso específico
    public void registrarNota(Alumno alumno, Curso curso, double valor) {
        registroNotas.computeIfAbsent(alumno, k -> new HashMap<>())
                     .computeIfAbsent(curso, k -> new ArrayList<>())
                     .add(new Nota(valor));
        System.out.println("Nota de " + valor + " registrada para " + alumno.getNombre() + " en el curso " + curso.getNombre());
    }

    // Todas las notas de un alumno en un curso
    public List<Nota> obtenerNotasDeAlumno(Alumno alumno, Curso curso) {
        Map<Curso, List<Nota>> cursosAlumno = registroNotas.get(alumno);
        if (cursosAlumno != null) {
            return cursosAlumno.getOrDefault(curso, new ArrayList<>());
        }
        return new ArrayList<>();
    }

    // Notas de todos los alumnos de un curso
    public List<Nota> obtenerNotasDeCurso(Curso curso) {
        List<Nota> todasLasNotasDelCurso = new ArrayList<>();
        for (Map<Curso, List<Nota>> cursosAlumno : registroNotas.values()) {
            List<Nota> notas = cursosAlumno.get(curso);
            if (notas != null) {
                todasLasNotasDelCurso.addAll(notas);
            }
        }
        return todasLasNotasDelCurso;
    }

    // Calcular el promedio de un alumno en un curso
    public double calcularPromedio(Alumno alumno, Curso curso) {
        List<Nota> notas = obtenerNotasDeAlumno(alumno, curso);
        return Nota.calcularPromedio(notas);
    }

    // Promedio general de un alumno
    public double calcularPromedioGeneral(Alumno alumno) {
        Map<Curso, List<Nota>> cursosAlumno = registroNotas.get(alumno);
        if (cursosAlumno == null || cursosAlumno.isEmpty()) {
            return 0.0;
        }

        double sumaPromedios = 0;
        for (Curso curso : cursosAlumno.keySet()) {
            sumaPromedios += calcularPromedio(alumno, curso);
        }
        return sumaPromedios / cursosAlumno.size();
    }

    // Verificar si un alumno aprobó un curso
    public boolean cursoAprobado(Alumno alumno, Curso curso) {
        return calcularPromedio(alumno, curso) >= NOTA_APROBATORIA_CURSO;
    }

    // Lista de cursos aprobados
    public List<Curso> obtenerCursosAprobados(Alumno alumno) {
        List<Curso> aprobados = new ArrayList<>();
        Map<Curso, List<Nota>> cursosAlumno = registroNotas.get(alumno);
        if (cursosAlumno != null) {
            for (Curso curso : cursosAlumno.keySet()) {
                if (cursoAprobado(alumno, curso)) {
                    aprobados.add(curso);
                }
            }
        }
        return aprobados;
    }

    // Lista de cursos desaprobados
    public List<Curso> obtenerCursosDesaprobados(Alumno alumno) {
        List<Curso> desaprobados = new ArrayList<>();
        Map<Curso, List<Nota>> cursosAlumno = registroNotas.get(alumno);
        if (cursosAlumno != null) {
            for (Curso curso : cursosAlumno.keySet()) {
                if (!cursoAprobado(alumno, curso)) {
                    desaprobados.add(curso);
                }
            }
        }
        return desaprobados;
    }
}
