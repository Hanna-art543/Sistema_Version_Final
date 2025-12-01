public class MatriculaRegular extends matricula {
    private String periodoAcademico;
    private int creditosMinimos;
    private int creditosMaximosPermitidos;
    private boolean pagoMatricula;
    public MatriculaRegular(String ID, String fecha, Alumno alumno,
                            String periodoAcademico, int creditosMinimos,
                            int creditosMaximosPermitidos) {
        super(ID, fecha, alumno);
        this.periodoAcademico = periodoAcademico;
        this.creditosMinimos = creditosMinimos;
        this.credimitosMaximosPermitidos = creditosMaximosPermitidos;
        this.pagoMatricula = false;
    }
    public String getPeriodoAcademico() { return periodoAcademico; }
    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    public int getCreditosMinimos() { return creditosMinimos; }

    public void setCreditosMinimos(int creditosMinimos) {
        this.creditosMinimos = creditosMinimos;
    }
    public int getCreditosMaximosPermitidos() { return credimaximosPermitidos; }
    public void setCreditosMaximosPermitidos(int creditosMaximosPermitidos) {
        this.credimaximosPermitidos = creditosMaximosPermitidos;
    }
    public boolean isPagoMatricula() { return pagoMatricula; }

    public void setPagoMatricula(boolean pagoMatricula) {
        this.pagoMatricula = pagoMatricula;
    }
    public void registrarMatricula(Alumno a, Carrera c) {
        if (a == null || c == null) {
            System.out.println("Datos inválidos para registrar matrícula regular.");
            return;
        }
        int creditosCarrera = c.getCursos().size(); 
        if (creditosCarrera < creditosMinimos) {
            System.out.println("No cumple los créditos mínimos para matrícula regular.");
            return;
        }
        if (creditosCarrera > creditosMaximosPermitidos) {
            System.out.println("Excede los créditos máximos permitidos.");
            return;
        }
        this.alumno = a;
        this.estado = true;
        this.pagoMatricula = true;
        System.out.println("Matrícula Regular registrada correctamente.");
    }
    public void mostrarDetalle() {
        System.out.println("=== Matrícula Regular ===");
        System.out.println("ID: " + ID);
        System.out.println("Fecha: " + fecha);
        System.out.println("Periodo: " + periodoAcademico);
        System.out.println("Estado: " + (estado ? "Activa" : "Inactiva"));
        System.out.println("Pago: " + (pagoMatricula ? "Realizado" : "Pendiente"));
        System.out.println("Alumno: " + alumno.getNombre());
    }
}
