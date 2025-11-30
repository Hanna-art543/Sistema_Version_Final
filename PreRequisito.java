import java.util.ArrayList;
import java.util.List;

public class PreRequisito {
    private String ID;
    private double notaMinima;
    private Curso cursoRequerido;

    public PreRequisito(String ID, double notaMinima, Curso cursoRequerido) {
        this.ID = ID;
        this.notaMinima = notaMinima;
        this.cursoRequerido = cursoRequerido;
    }

    public boolean verificarCumplimiento(Alumno a) {
        return false;
    }

    public void mostrarInformacion() {
        System.out.println(ID);
    }
}