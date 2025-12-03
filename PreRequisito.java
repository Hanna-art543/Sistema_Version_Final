import java.util.List;

public class PreRequisito {
    // ATRIBUTOS
    private String ID;
    private double notaMinima;
    private Curso cursoRequerido;

    // CONSTRUCTOR DE INSTANCIA
    public PreRequisito(String ID, double notaMinima, Curso cursoRequerido) {
        this.ID = ID;
        this.notaMinima = notaMinima;
        this.cursoRequerido = cursoRequerido;
    }

    // GETTERS
    public String getId() { return ID; }
    public Curso getCursoRequerido() { return cursoRequerido; }

    // FUNCION PARA VERIFICAR CUMPLIMIENTO
    public boolean verificarCumplimiento(Alumno a, GestorNotas gestor) { 
        if (a == null || cursoRequerido == null || gestor == null) {
            return false;
        }
        
        double promedio = gestor.calcularPromedio(a, cursoRequerido);
        
        return promedio >= notaMinima;
    }

    public void mostrarInformacion() {
        System.out.println("PreRequisito [" + ID + "]: Aprobar " + cursoRequerido.getNombre() + " con nota mínima de " + notaMinima);
    }
}
