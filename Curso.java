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
    public int getCreditos() {
        return creditos;
    }

    // FUNCION PARA PREREQUISITOS
    public void agregarPreRequisito(PreRequisito p) {
        this.preRequisitos.add(p);
    }

    public boolean eliminarPreRequisito(String id) {
        //Función lambda
        return this.preRequisitos.removeIf(p -> p.getId().equals(id));
    }

    // FUNCION PARA VERIFICAR REQUISITOS 
    public boolean cumpleRequisitos(Alumno a, GestorNotas gestor) {
        for (PreRequisito p : preRequisitos) {
            if (!p.verificarCumplimiento(a, gestor)) { 
                return false;
            }
        }
        return true;
    }

    // FUNCION PARA MOSTRAR INFORMACION
    public void mostrarInformacion() {
        System.out.println("Curso: " + nombre + " [" + codigo + "]");
        System.out.println("Créditos: " + creditos + ", Semestre: " + semestre);
    }

    // Método abstracto
    public abstract double calcularNotaFinal();
}
