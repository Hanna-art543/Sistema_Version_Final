public class AlumnoPosgrado extends Alumno {
    private String programa;
    private String grado;
    private String asesor;
    public AlumnoPosgrado(int CUI, String nombre, String email,
                          String programa, String grado, String asesor) {
        super(CUI, nombre, email);
        this.programa = programa;
        this.grado = grado;
        this.asesor = asesor;
    }
    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }
    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }
    public String getAsesor() { return asesor; }
    public void setAsesor(String asesor) { this.asesor = asesor; }
    public int creditosMaximos() {
        return 12;
    }
    public double calcularPago() {
        double base = 2000.0;
        if (grado.equalsIgnoreCase("maestría")) {
            base += 500;
        } else if (grado.equalsIgnoreCase("doctorado")) {
            base += 1000;
        }
        return base;
    }
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Programa: " + programa);
        System.out.println("Grado: " + grado);
        System.out.println("Asesor asignado: " + asesor);
    }
}
