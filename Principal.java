import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date; // Necesario para MatriculaEspecial

public class Principal {

    private static Scanner scanner = new Scanner(System.in);
    private static Universidad universidad;
    private static GestorNotas gestorNotas;
    

    public static void main(String[] args) {
        // Inicializar datos
        universidad = new Universidad("Universidad Global");
        gestorNotas = new GestorNotas();
        
        cargarDatosIniciales();
        
        int opcion;
        boolean continuar = true;
        
        while (continuar) {
            try {
                mostrarMenu();
                System.out.print("Ingrese una opción (1-5): ");
                
                if (!scanner.hasNextInt()) {
                    scanner.next(); 
                    throw new ExcepcionDatoInvalido("Opción de menú inválida. Se esperaba un número.", 3);
                }
                
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcion) {
                    case 1:
                        gestionarAlumno();
                        break;
                    case 2:
                        gestionarNotas();
                        break;
                    case 3:
                        gestionarMatricula();
                        break;
                    case 4:
                        mostrarReportes();
                        break;
                    case 5:
                        System.out.println("¡Saliendo del sistema!");
                        continuar = false;
                        break;
                    default:
                        throw new ExcepcionDatoInvalido("Opción fuera del rango permitido (1-5).", 3);
                }
            } catch (ExcepcionDatoInvalido e) {
                // Maneja la excepción personalizada y pide reingreso
                System.out.println("🛑 ERROR DE DATO INVÁLIDO: " + e.getMessage());
                manejarReingreso(e.getTipoError());
            } catch (InputMismatchException e) {
                // Maneja si se ingresa texto cuando se esperaba un número (ej: double)
                scanner.nextLine(); 
                System.out.println("🛑 ERROR DE FORMATO: Se esperaba un dato numérico.");
                manejarReingreso(0); // Pide reingresar en general
            } catch (IllegalArgumentException e) {
                // Captura la excepción lanzada desde la clase Nota
                System.out.println("🛑 ERROR DE VALOR: " + e.getMessage());
                manejarReingreso(2); // Tipo de error: Nota fuera de rango [0.0 - 20.0]
            } catch (Exception e) {
                System.out.println("🛑 ERROR INESPERADO: " + e.getMessage());
                manejarReingreso(0);
            }
        } 
    }

    // FUNCIONES DEL MENÚ

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL DE LA UNIVERSIDAD ===");
        System.out.println("1. Matricular Curso a Alumno");
        System.out.println("2. Registrar Nota de Curso");
        System.out.println("3. Registrar Matrícula (Demo)");
        System.out.println("4. Mostrar Reportes de Alumno (Demo)");
        System.out.println("5. Salir");
    }
    
    private static void gestionarAlumno() throws ExcepcionDatoInvalido {
        System.out.println("\n--- 1. MATRICULAR CURSO ---");
        
        System.out.print("Ingrese CUI del alumno: ");
        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new ExcepcionDatoInvalido("El CUI debe ser un número entero.", 1);
        }
        int cui = scanner.nextInt();
        scanner.nextLine();

        Alumno alumno = universidad.buscarAlumnoPorCUI(cui);
        if (alumno == null) {
            System.out.println("Alumno con CUI " + cui + " no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el código del curso a matricular (Ej: CS201): ");
        String codigoCurso = scanner.nextLine().trim();

        Carrera carrera = universidad.listarSucursales().get(0).listarFacultades().get(0).listarCarreras().get(0);
        Curso curso = carrera.buscarCurso(codigoCurso);
        
        if (curso == null) {
             System.out.println("Curso con código " + codigoCurso + " no encontrado en la carrera.");
             return;
        }
        
        alumno.matricularCurso(curso, gestorNotas); 
    }

    private static void gestionarNotas() throws ExcepcionDatoInvalido {
        System.out.println("\n--- 2. REGISTRAR NOTA ---");
        
        System.out.print("Ingrese CUI del alumno: ");
        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new ExcepcionDatoInvalido("El CUI debe ser un número entero.", 1);
        }
        int cui = scanner.nextInt();
        scanner.nextLine();

        Alumno alumno = universidad.buscarAlumnoPorCUI(cui);
        if (alumno == null) {
            System.out.println("Alumno con CUI " + cui + " no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el nombre del curso (Ej: Algoritmos): ");
        String nombreCurso = scanner.nextLine().trim();
        
        // Buscar el curso en la lista de matriculados del alumno
        Curso curso = alumno.getCursos().keySet().stream()
                             .filter(c -> c.getNombre().equalsIgnoreCase(nombreCurso))
                             .findFirst().orElse(null);

        if (curso == null) {
             System.out.println("El alumno no está matriculado en el curso: " + nombreCurso);
             return;
        }
        
        System.out.print("Ingrese el valor de la nota (0.0 a 20.0): ");
        if (!scanner.hasNextDouble()) {
            scanner.next();
            throw new ExcepcionDatoInvalido("La nota debe ser un número decimal.", 2);
        }
        double valorNota = scanner.nextDouble();
        scanner.nextLine();

        // Esta llamada puede lanzar IllegalArgumentException 
        gestorNotas.registrarNota(alumno, curso, valorNota); 
    }
    
    private static void gestionarMatricula() {
        System.out.println("\n--- 3. GESTIÓN DE MATRÍCULA (DEMO) ---");
        Alumno a = universidad.buscarAlumnoPorCUI(1001);
        Carrera c = universidad.listarSucursales().get(0).listarFacultades().get(0).listarCarreras().get(0);
        
        if (a != null && c != null) {
             MatriculaRegular mr = new MatriculaRegular("REG001", "2025-03-01", null, "2025-I", 12, a.creditosMaximos());
             mr.registrarMatricula(a, c);
             
             MatriculaEspecial me = new MatriculaEspecial("ESP002", "2025-03-10", a, "Cambio de Carrera", "Doc. Aprobación", new Date(), "Director");
             me.mostrarDetalle();
        } else {
             System.out.println("No se pudieron cargar datos de ejemplo para la matrícula.");
        }
    }

    private static void mostrarReportes() {
        System.out.println("\n--- 4. REPORTES DE ALUMNO (DEMO) ---");
        Alumno a = universidad.buscarAlumnoPorCUI(1001);
        if (a != null) {
            a.mostrarInformacion();
            System.out.println("Pago Anual Estimado: S/. " + String.format("%.2f", a.calcularPago()));
            System.out.println("Promedio General: " + String.format("%.2f", gestorNotas.calcularPromedioGeneral(a)));
            
            String cursosAprobados = gestorNotas.obtenerCursosAprobados(a).stream()
                .map(Curso::getNombre)
                .reduce((n1, n2) -> n1 + ", " + n2).orElse("Ninguno");
                
            System.out.println("Cursos Aprobados: " + cursosAprobados);
        } else {
             System.out.println("No hay datos de ejemplo cargados para reportes.");
        }
    }
    
    //-------------------------------------------------------------
    // MANEJO DE EXCEPCIONES: switch para reingreso
    
    private static void manejarReingreso(int tipoError) {
        System.out.println("\n====================================");
        switch (tipoError) {
            case 1:
                System.out.println("🔄 Solicitud: Por favor, REINGRESE el CUI (Número entero).");
                break;
            case 2:
                System.out.println("🔄 Solicitud: Por favor, REINGRESE la NOTA (Decimal entre 0.0 y 20.0).");
                break;
            case 3:
                System.out.println("🔄 Solicitud: Por favor, REINGRESE la OPCIÓN de Menú (Número entre 1 y 5).");
                break;
            default:
                System.out.println("🔄 Solicitud: Error no específico. Volviendo al menú.");
        }
        System.out.println("====================================\n");
    }

    // DATOS DE EJEMPLO
    
    private static void cargarDatosIniciales() {
        // Crear estructura básica (Sucursal -> Facultad -> Carrera)
        Sucursal s = new Sucursal("Sede Central", "Principal", "Lima", "Av. Principal 123");
        Facultad f = new Facultad("Ingeniería y Arquitectura");
        Carrera c = new Carrera("Ingeniería de Sistemas", "CS", 10);
        s.agregarFacultad(f);
        f.agregarCarrera(c);
        universidad.agregarSucursal(s);

        // Crear alumnos
        AlumnoPregrado ap = new AlumnoPregrado(1001, "Ana López", "ana.l@uni.edu", 3, 40, false);
        AlumnoPosgrado apo = new AlumnoPosgrado(2001, "Pedro Díaz", "pedro.d@uni.edu", "Data Science", "Maestría", "Dr. Guzmán");
        c.agregarAlumno(ap);
        c.agregarAlumno(apo);

        // Crear cursos
        CursoTeorico ct1 = new CursoTeorico("Algoritmos", "CS101", 4, 1);
        CursoPractico cp1 = new CursoPractico("Programación I", "CS102", 5, 1);
        CursoTeorico ct2 = new CursoTeorico("Estructuras de Datos", "CS201", 4, 3);
        c.agregarCurso(ct1);
        c.agregarCurso(cp1);
        c.agregarCurso(ct2);

        // Establecer pre-requisito (Estructuras de Datos requiere Programación I)
        PreRequisito pr = new PreRequisito("PR-CS201", 11.0, cp1);
        ct2.agregarPreRequisito(pr);
        
        // Matricular alumno en cursos iniciales
        ap.getCursos().put(ct1, new ArrayList<>());
        ap.getCursos().put(cp1, new ArrayList<>());

        // Registrar notas para que haya datos para los pre-requisitos
        gestorNotas.registrarNota(ap, ct1, 14.0);
        gestorNotas.registrarNota(ap, cp1, 15.0); // Nota de Programación I para Ana
        
        System.out.println("Datos de ejemplo cargados (Alumno 1001 y 2001, Cursos CS101, CS102, CS201).");
        System.out.println();
    }
}