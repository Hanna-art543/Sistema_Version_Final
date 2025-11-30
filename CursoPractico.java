public class CursoPractico extends Curso {
    // Atributos
    private double notaLaboratorio;
    private double notaProyectoFinal;

    //Constructor de instancia
    public CursoPractico(String nombre, String codigo, int creditos, int semestre) {
        super(nombre, codigo, creditos, semestre);
    }

    // Setters 
    public void setNotaLaboratorio(double notaLaboratorio) { this.notaLaboratorio = notaLaboratorio; }
    public void setNotaProyectoFinal(double notaProyectoFinal) { this.notaProyectoFinal = notaProyectoFinal; }

    @Override
    public double calcularNotaFinal() {
        // Ejemplo de lógica: 60% laboratorio, 40% proyecto
        return (notaLaboratorio * 0.6) + (notaProyectoFinal * 0.4);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Práctico");
        System.out.println("Nota Laboratorio: " + notaLaboratorio + ", Nota Proyecto: " + notaProyectoFinal);
        System.out.println("Promedio Final: " + calcularNotaFinal());
    }
}
