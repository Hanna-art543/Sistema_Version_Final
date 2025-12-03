import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class Alumno {
    // ATRIBUTOS
    private int CUI;
    private String nombre;
    private String email;
    private Map<Curso, List<Nota>> cursos;

    // CONSTRUCTOR DE INSTANCIA
    public Alumno(int CUI, String nombre, String email) {
        this.CUI = CUI;
        this.nombre = nombre;
        this.email = email;
        this.cursos = new HashMap<>();
    }
    
    // Setters y getters
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
    
    // FUNCION PARA MOSTRAR INFORMACION
    public void mostrarInformacion() {
        System.out.println("=== Información del Alumno ===");
        System.out.println("CUI: " + CUI);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Cantidad de cursos matriculados: " + cursos.size());
    }

    // MÉTODOS ABSTRACTOS
    public abstract int creditosMaximos();
    public abstract double calcularPago();
    
    // FUNCION PARA MATRICULAR CURSO 
    public void matricularCurso(Curso c, GestorNotas gestor) { 
        if (c == null) {
            System.out.println("ERROR: No se puede matricular en un curso nulo.");
            return;
        }

        // 1. Verificar si ya está matriculado
        if (cursos.containsKey(c)) {
            System.out.println("ERROR: El alumno ya está matriculado en el curso: " + c.getNombre());
            return;
        }

        // 2. Verificar Pre-requisitos
        if (!c.cumpleRequisitos(this, gestor)) {
            System.out.println("ERROR: El alumno " + nombre + " no cumple los pre-requisitos para el curso: " + c.getNombre());
            return;
        }
        
        // 3. Verificar Créditos Máximos 
        int creditosActuales = cursos.keySet().stream().mapToInt(Curso::getCreditos).sum();
        int creditosNuevos = c.getCreditos();
        
        if (creditosActuales + creditosNuevos > creditosMaximos()) {
             System.out.println("ERROR: El alumno " + nombre + " excede el máximo de créditos permitido (" + creditosMaximos() + ").");
             System.out.println("Créditos actuales: " + creditosActuales + ", Créditos del curso: " + creditosNuevos);
             return;
        }

        cursos.put(c, new ArrayList<Nota>());
        System.out.println("Matrícula exitosa: Alumno " + nombre + " matriculado en: " + c.getNombre() + ".");
    }
}
