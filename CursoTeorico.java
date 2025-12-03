public class CursoTeorico extends Curso {
    private double notaParcial;
    private double notaFinal;

    public CursoTeorico(String nombre, String codigo, int creditos, int semestre) {
        super(nombre, codigo, creditos, semestre);
    }

    // Setters 
    public void setNotaParcial(double notaParcial) { 
      this.notaParcial = notaParcial; 
    }
    public void setNotaFinal(double notaFinal) { 
      this.notaFinal = notaFinal; 
    }

    @Override
    public double calcularNotaFinal() {
        // Ejemplo de lógica: Promedio simple de parcial y final
        return (notaParcial + notaFinal) / 2.0;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Teórico");
        System.out.println("Nota Parcial: " + notaParcial + ", Nota Final: " + notaFinal);
        System.out.println("Promedio Final: " + calcularNotaFinal());
    }
}

