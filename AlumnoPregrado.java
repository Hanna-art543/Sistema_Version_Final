public class AlumnoPregrado extends Alumno {
    private int ciclo;
    private int creditosAcumulados;
    private boolean estadoConvalidacion;
    public AlumnoPregrado(int CUI, String nombre, String email, int ciclo,
                          int creditosAcumulados, boolean estadoConvalidacion) {
        super(CUI, nombre, email);
        this.ciclo = ciclo;
        this.creditosAcumulados = creditosAcumulados;
        this.estadoConvalidacion = estadoConvalidacion;
    }
    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }
    public int getCreditosAcumulados() { return creditosAcumulados; }
    public void setCreditosAcumulados(int creditosAcumulados) { this.creditosAcumulados = creditosAcumulados; }
    public boolean isEstadoConvalidacion() { return estadoConvalidacion; }
    public void setEstadoConvalidacion(boolean estadoConvalidacion) { this.estadoConvalidacion = estadoConvalidacion; }
    public int creditosMaximos() {
        if (ciclo <= 2) return 18;     
        if (ciclo <= 8) return 20;      
        return 22;                       
    }
    public double calcularPago() {
        double base = 1200.0;
        double adicional = creditosAcumulados * 5.0;
        if (estadoConvalidacion) adicional -= 100;
        return base + adicional;
    }
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Ciclo: " + ciclo);
        System.out.println("Créditos acumulados: " + creditosAcumulados);
        System.out.println("Convalidación activa: " + estadoConvalidacion);
    }
}
