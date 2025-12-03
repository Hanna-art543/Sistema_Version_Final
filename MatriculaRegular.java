public class MatriculaRegular extends Matricula {
    // ATRIBUTOS
    private String periodoAcademico;
    private int creditosMinimos;
    private int creditosMaximosPermitidos;
    private boolean pagoMatricula;

    // CONSTRUCTOR DE INSTANCIA
    public MatriculaRegular(String ID, String fecha, Alumno alumno,
                            String periodoAcademico, int creditosMinimos,
                            int creditosMaximosPermitidos) {
        super(ID, fecha, alumno);
        this.periodoAcademico = periodoAcademico;
        this.creditosMinimos = creditosMinimos;
        this.creditosMaximosPermitidos = creditosMaximosPermitidos; // CORREGIDO
        this.pagoMatricula = false;
    }

    // GETTERS
    public String getPeriodoAcademico() { return periodoAcademico; }
    public int getCreditosMinimos() { return creditosMinimos; }
    public int getCreditosMaximosPermitidos() { return creditosMaximosPermitidos; } // CORREGIDO
    public boolean isPagoMatricula() { return pagoMatricula; }

    // SETTERS
    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    public void setCreditosMinimos(int creditosMinimos) {
        this.creditosMinimos = creditosMinimos;
    }
    public void setCreditosMaximosPermitidos(int creditosMaximosPermitidos) {
        this.creditosMaximosPermitidos = creditosMaximosPermitidos; // CORREGIDO
    }
    public void setPagoMatricula(boolean pagoMatricula) {
        this.pagoMatricula = pagoMatricula;
    }

    // FUNCION PARA REGISTRAR MATRICULA
    @Override
    public void registrarMatricula(Alumno a, Carrera c) {
        if (a == null || c == null) {
            System.out.println("Datos inválidos para registrar matrícula regular.");
            return;
        }

        this.alumno = a;
        this.estado = true;
        this.pagoMatricula = true; 
        System.out.println("Matrícula Regular registrada correctamente para " + a.getNombre() + " en el periodo " + periodoAcademico + ".");
    }

    // FUNCION PARA MOSTRAR DETALLE
    @Override
    public void mostrarDetalle() {
        System.out.println("=== Matrícula Regular ===");
        System.out.println("ID: " + ID + ", Fecha: " + fecha);
        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Periodo: " + periodoAcademico);
        System.out.println("Créditos Mínimos: " + creditosMinimos + ", Créditos Máximos: " + creditosMaximosPermitidos);
        System.out.println("Estado: " + (estado ? "Activa" : "Inactiva"));
        System.out.println("Pago: " + (pagoMatricula ? "Realizado" : "Pendiente"));
    }
}
