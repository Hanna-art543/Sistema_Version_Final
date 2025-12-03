public class ExcepcionDatoInvalido extends Exception {
    // ATRIBUTOS
    private int tipoError; // 1: CUI, 2: Nota, 3: Opción de Menú

    // CONSTRUCTOR DE INSTANCIA
    public ExcepcionDatoInvalido(String mensaje, int tipoError) {
        super(mensaje);
        this.tipoError = tipoError;
    }

    // GETTER
    public int getTipoError() {
        return tipoError;
    }
}