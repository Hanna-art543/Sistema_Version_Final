import java.util.Date;
public class MatriculaEspecial extends matricula {
    private String tipoEspecial;
    private String documentoJustificacion;
    private Date fechaSolicitud;
    private String aprobadoPor;
    public MatriculaEspecial(String ID, String fecha, Alumno alumno,
                             String tipoEspecial, String documentoJustificacion,
                             Date fechaSolicitud, String aprobadoPor) {
        super(ID, fecha, alumno);
        this.tipoEspecial = tipoEspecial;
        this.documentoJustificacion = documentoJustificacion;
        this.fechaSolicitud = fechaSolicitud;
        this.aprobadoPor = aprobadoPor;
    }
    public String getTipoEspecial() { return tipoEspecial; }
    public void setTipoEspecial(String tipoEspecial) { this.tipoEspecial = tipoEspecial; }
    public String getDocumentoJustificacion() { return documentoJustificacion; }
    public void setDocumentoJustificacion(String documentoJustificacion) { this.documentoJustificacion = documentoJustificacion; }
    public Date getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(Date fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public String getAprobadoPor() { return aprobadoPor; }
    public void setAprobadoPor(String aprobadoPor) { this.aprobadoPor = aprobadoPor; }
    public void registrarMatricula(Alumno a, Carrera c) {
        if (a == null || c == null) {
            System.out.println("Datos inválidos para matrícula especial.");
            return;
        }
        System.out.println("Matrícula Especial en proceso...");
        System.out.println("Tipo: " + tipoEspecial);
        System.out.println("Documento: " + documentoJustificacion);
        System.out.println("Aprobado por: " + aprobadoPor);
        this.alumno = a;
        this.estado = true;
        System.out.println("Matrícula Especial registrada.");
    }
    public void mostrarDetalle() {
        System.out.println("=== Matrícula Especial ===");
        System.out.println("ID: " + ID);
        System.out.println("Fecha: " + fecha);
        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Tipo especial: " + tipoEspecial);
        System.out.println("Justificación: " + documentoJustificacion);
        System.out.println("Fecha Solicitud: " + fechaSolicitud);
        System.out.println("Aprobado por: " + aprobadoPor);
        System.out.println("Estado: " + (estado ? "Activa" : "Inactiva"));
    }
}
