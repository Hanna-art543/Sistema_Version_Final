import java.util.ArrayList;
import java.util.List;

public abstract class Curso {
    // Atributos 
    protected String nombre;
    protected String codigo;
    protected int creditos;
    protected int semestre;
    protected List<PreRequisito> preRequisitos;
    protected List<Alumno> alumnos;

    //Constructor de Instancia
    public Curso(String nombre, String codigo, int creditos, int semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.semestre = semestre;
        this.preRequisitos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    // Getters básicos
    public String getNombre() { 
        return nombre; 
    }
    public String getCodigo() { 
        return codigo; 
    }

    public void agregarPreRequisito(PreRequisito p) {
        this.preRequisitos.add(p);
    }

    public boolean eliminarPreRequisito(String id) {
        //Función lambda
        return this.preRequisitos.removeIf(p -> p.getId().equals(id));
    }

    public boolean cumpleRequisitos(Alumno a) {
        for (PreRequisito p : preRequisitos) {
            if (!p.verificarCumplimiento(a)) {
                return false;
            }
        }
        return true;
    }

    public void mostrarInformacion() {
        System.out.println("Curso: " + nombre + " [" + codigo + "]");
        System.out.println("Créditos: " + creditos + ", Semestre: " + semestre);
    }

    // Método abstracto para que las subclases definan cómo se calcula su nota final
    public abstract double calcularNotaFinal();
}
