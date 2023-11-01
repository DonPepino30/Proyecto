package domain;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;    

class ComplejoDeportivo {
    
    private static int lastId = 1;
    private int idComplejoDeportivo;
    private String nombre;
    private String localizacion;
    private String jefeOrganizacion;
    
    List<String> deportes;
    List<Evento> eventos;

    public ComplejoDeportivo(String nombre, String localizacion, String jefeOrganizacion) {
        this.idComplejoDeportivo = lastId;
        lastId++;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.jefeOrganizacion = jefeOrganizacion;
    }

    public int getIdComplejoDeportivo() {
        return idComplejoDeportivo;
    }

    public void setIdComplejoDeportivo(int idComplejoDeportivo) {
        this.idComplejoDeportivo = idComplejoDeportivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getJefeOrganizacion() {
        return jefeOrganizacion;
    }

    public void setJefeOrganizacion(String jefeOrganizacion) {
        this.jefeOrganizacion = jefeOrganizacion;
    }

    public List<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<String> deportes) {
        this.deportes = deportes;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
    Scanner lector = new Scanner(System.in);
    
    public void gestionarMenuDeportes(){
        
        while (true) {
            mostrarMenuDeporte();

            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1:
                    String deporteADD = agregarDeportes();
                    if (!(deporteADD == null) && deportes.size()!=6) {
                        deportes.add(deporteADD);
                        System.out.println("El Complejo ha sido creada con exito");
                    }
                    else{
                        System.out.println("Ha llegado al limite de complejos a agregar");
                    }
                    break;
                case 2:
                    String deporteNom;
                    System.out.println("Ingrese el Nombre del Deporte a eliminar:");
                    deporteNom=lector.nextLine();
                    String deporteName = eliminarComplejoDeportivo(deporteNom);
                    if (!(deporteName == null)) {
                        deportes.remove(deporteName);
                        System.out.println("El Deporte ha sido eliminada con exito");
                    }
                    break;
                case 3:
                    readAllDeportes();
                    break;
                case 4:
                    String deporteN;
                    System.out.println("Ingrese el Nombre del Deporte a eliminar:");
                    deporteN = lector.nextLine();
                    readNombreDeporte(deporteN);
                    break;
                case 5:
                    Main.main(new String[]{});
                    break;      
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        
    }
    
     public static void mostrarMenuDeporte() {
        System.out.println("====================================");
        System.out.println("\nBienvenido al Gestor de Deportes");
        System.out.println("====================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Adicionar");
        System.out.println("2. Eliminar");
        System.out.println("3. Consultar Todos");
        System.out.println("4. Consultar por Id");
        System.out.println("5. Retornar");
        System.out.print("Ingrese la opción: ");
    }
    
    public String agregarDeportes() { 
        
        System.out.println("Adición de Deportes");
        System.out.println("===================");

        System.out.print("Ingrese el nombre: ");
        String nombreN = lector.nextLine();
        for (String deporte : deportes) {
            if (deporte.equals(nombreN)) {
                System.out.println("ERROR! Existe un deporte con dicho nombre");
                return null;
            }
        }
        return nombreN;
    }
    
    public String eliminarComplejoDeportivo(String nombre) { 
        
        for (String deporte : deportes) {
            if (deporte.equals(nombre)) {
                return deporte;
            }
        }
        return null;
    }
    
    public String readNombreDeporte(String nombre) {
        
        System.out.println("\nConsulta de Deporte por Nombre");
        System.out.println("================================");
        
        for (String deporte : deportes) {
            if (deporte.equals(nombre)) {
            System.out.printf("%13s   %15s\n", "Nombre", "Complejo Deportivo");
            System.out.printf("%13s   %15s\n", deporte,  getNombre());
            }
        }
        return null;
    }
    
    public String readAllDeportes() {
        System.out.println("\nConsulta de Todos Deportes");
        System.out.println("============================");
        
        System.out.printf("%13s\n", "Nombre");
        for (String deporte : deportes) {
            System.out.printf("%13s\n", deporte);
        }
        return null;
    }
    
    
    public void gestionarMenuEvento(){
        
        while (true) {
            mostrarMenuEvento();

            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1:
                    String deporteADD = agregarDeportes();
                    if (!(deporteADD == null) && deportes.size()!=6) {
                        deportes.add(deporteADD);
                        System.out.println("El Complejo ha sido creada con exito");
                    }
                    else{
                        System.out.println("Ha llegado al limite de complejos a agregar");
                    }
                    break;
                case 2:
                    String deporteNom;
                    System.out.println("Ingrese el Nombre del Deporte a eliminar:");
                    deporteNom=lector.nextLine();
                    String deporteName = eliminarComplejoDeportivo(deporteNom);
                    if (!(deporteName == null)) {
                        deportes.remove(deporteName);
                        System.out.println("El Deporte ha sido eliminada con exito");
                    }
                    break;
                case 3:
                    readAllDeportes();
                    break;
                case 4:
                    String deporteN;
                    System.out.println("Ingrese el Nombre del Deporte a eliminar:");
                    deporteN = lector.nextLine();
                    readNombreDeporte(deporteN);
                    break;
                case 5:
                    Main.main(new String[]{});
                    break;      
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        
    }
    
    public void mostrarMenuEvento(){
        System.out.println("===========================================");
        System.out.println("\nBienvenido al Gestor De Eventos");
        System.out.println("===========================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Adicionar");
        System.out.println("2. Modificar");
        System.out.println("3. Consultar Todos");
        System.out.println("4. Consultar por Id");
        System.out.println("5. Consultar por Fecha");
        System.out.println("6. Consultar por Nombre");
        System.out.println("7. Consultar por Parte Del Nombre");
        System.out.println("8. Consultar por Parte Inicio-Fin");
        System.out.println("9. Consultar por Tiempo De Duracion");
        System.out.println("10. Ordenar por Numero de Participantes");
        System.out.println("11. Eliminar");
        System.out.println("12. Gestor de Personas en Eventos");
        System.out.println("13. Gestor de Equipamiento en Eventos");
        System.out.println("14. Retornar");
        System.out.print("Ingrese la opción: ");
    }
    
    
}
