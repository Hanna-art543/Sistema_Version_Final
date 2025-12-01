public class MatriculaExtraordinaria extends matricula {
    private String motivo;
    private double recargo;
    public MatriculaExtraordinaria(String ID, String fecha, Alumno alumno,
                                   String motivo, double recargo) {
        super(ID, fecha, alumno);
        this.motivo = motivo;
        this.recargo = recargo;
    }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public double getRecargo() { return recargo; }
    public void setRecargo(double recargo) { this.recargo = recargo; }
    public void registrarMatricula(Alumno a, Carrera c) {
        if (a == null || c == null) {
            System.out.println("Datos inválidos para matrícula extraordinaria.");
            return;
        }
        this.alumno = a;
        this.estado = true;
        System.out.println("Matrícula Extraordinaria registrada.");
        System.out.println("Motivo: " + motivo);
        System.out.println("Recargo aplicado: S/. " + recargo);
    }
    public void mostrarDetalle() {
        System.out.println("=== Matrícula Extraordinaria ===");
        System.out.println("ID: " + ID);
        System.out.println("Fecha: " + fecha);
        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Motivo: " + motivo);
        System.out.println("Recargo: " + recargo);
        System.out.println("Estado: " + (estado ? "Activa" : "Inactiva"));
    }
}
