import java.util.List;

public class Nota {
    private double valor;
    
    // Constantes
    public static final double NOTA_MINIMA = 0.0;
    public static final double NOTA_MAXIMA = 20.0;
    private static final double NOTA_APROBATORIA = 11.0;

    // CONSTRUCTOR
    public Nota(double valor) {
        this.asignarValor(valor);
    }

    public double getValor() {
        return valor;
    }

    // SETTER con validacion 
    public void asignarValor(double v) {
        if (v < NOTA_MINIMA || v > NOTA_MAXIMA) {
            throw new IllegalArgumentException("La nota debe estar entre " + NOTA_MINIMA + " y " + NOTA_MAXIMA);
        }
        this.valor = v;
    }

    public boolean esAprobado() {
        return this.valor >= NOTA_APROBATORIA;
    }

    // Método estático para promedio
    public static double calcularPromedio(List<Nota> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }
}
