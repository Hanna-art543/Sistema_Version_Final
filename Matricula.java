public abstract class Matricula {
    protected String ID;
    protected String fecha;
    protected boolean estado;
    protected Alumno alumno;
    public Matricula(String ID, String fecha, Alumno alumno) {
        this.ID = ID;
        this.fecha = fecha;
        this.alumno = alumno;
        this.estado = false; 
    }
    public String getID() { 
        return ID; 
    }
    public void setID(String ID) { 
        this.ID = ID; 
    }
    public String getFecha() { 
        return fecha; 
    }
    public void setFecha(String fecha) { 
        this.fecha = fecha; 
    }
    public boolean isEstado() { 
        return estado; 
    }
    public void setEstado(boolean estado) { 
        this.estado = estado; 
    }
    public Alumno getAlumno() { 
        return alumno; 
    }
    public void setAlumno(Alumno alumno) { 
        this.alumno = alumno; 
    }
    public abstract void registrarMatricula(Alumno a, Carrera c);
    public void cancelarMatricula() {
        if (estado) {
            estado = false;
            System.out.println("La matrícula " + ID + " ha sido CANCELADA.");
        } else {
            System.out.println("La matrícula ya estaba inactiva.");
        }
    }
    public boolean verificarEstado() {
        return estado;
    }
    public abstract void mostrarDetalle();
}
