package domain;

import java.util.List;
import java.util.Scanner;

public class SedeOlimpica {

    private static int lastId = 1;
    private String nombre;
    private String ubicacion;
    private int idSedeOlimpica;
    
    List<ComplejoDeportivo> complejosDeportivos;

    public SedeOlimpica(String nombre, String ubicacion) {
        this.idSedeOlimpica = lastId;
        lastId++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getIdSedeOlimpica() {
        return idSedeOlimpica;
    }

    public void setIdSedeOlimpica(int idSedeOlimpica) {
        this.idSedeOlimpica = idSedeOlimpica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ComplejoDeportivo> getComplejosDeportivos() {
        return complejosDeportivos;
    }

    public void setComplejosDeportivos(List<ComplejoDeportivo> complejosDeportivos) {
        this.complejosDeportivos = complejosDeportivos;
    }

    
    
    Scanner lector = new Scanner(System.in);
    
    public void gestionarMenuComplejoDeportivo(){
        
        while (true) {
            mostrarMenuComplejoDeportivo();

            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1:
                    ComplejoDeportivo complejoADD = agregarComplejoDeportivo();
                    if (!(complejoADD == null) && complejosDeportivos.size()!=5) {
                        complejosDeportivos.add(complejoADD);
                        System.out.println("El Complejo ha sido creada con exito");
                    }
                    else{
                        System.out.println("Ha llegado al limite de complejos a agregar");
                    }
                    break;
                case 2:
                    int idElim;
                    System.out.println("Ingrese el ID a eliminar:");
                    idElim=lector.nextInt();
                    ComplejoDeportivo complejoDEL = eliminarComplejoDeportivo(idElim);
                    if (!(complejoDEL == null)) {
                        complejosDeportivos.remove(complejoDEL);
                        System.out.println("El Complejo Deportivo ha sido eliminada con exito");
                    }
                    break;
                case 3:
                    int idMod;
                    System.out.println("Ingrese el ID a modificar: ");
                    idMod=lector.nextInt();
                    modificarComplejoDeportivo(idMod);
                    System.out.println("El Complejo Deportivo ha sido modificada con exito");
                    break;
                case 4:
                    readAllComplejoDeportivo();
                    break;
                case 5:
                    int idBus;
                    System.out.println("Ingrese el ID a buscar: ");
                    idBus=lector.nextInt();
                    readIdComplejoDeportivo(idBus);
                    break;
                case 6:
                    System.out.println("Ingrese el ID del Complejo a Administrar: ");
                    int idCompleDeporAdm= lector.nextInt();
                    
                    complejosDeportivos.get(idCompleDeporAdm).gestionarMenuDeportes();
                    break;
                case 7:
                    System.out.println("Ingrese el ID del Evento a Administrar: ");
                    int idEvento= lector.nextInt();
                    
                    complejosDeportivos.get(idEvento).gestionarMenuEvento();
                    break;
                case 8:
                    Main.main(new String[]{});
                    break;      
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        
    }
    
    public static void mostrarMenuComplejoDeportivo() {
        System.out.println("=============================================");
        System.out.println("Bienvenido al Gestor de Complejos Deportivos");
        System.out.println("=============================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Adicionar");
        System.out.println("2. Modificar");
        System.out.println("3. Consultar Todos");
        System.out.println("4. Consultar por Id");
        System.out.println("5. Eliminar");
        System.out.println("6. Gestionar Deportes");
        System.out.println("7. Gestionar Eventos");
        System.out.println("8. Retornar");
        System.out.print("Ingrese la opción: ");
    } 
    
    public ComplejoDeportivo agregarComplejoDeportivo() { 
        
        System.out.println("Adición de Complejos Deportivos");
        System.out.println("===============================");

        System.out.print("Ingrese el nombre: ");
        String nombreN = lector.nextLine();
        for (ComplejoDeportivo complejoDeportivo : complejosDeportivos) {
            if (complejoDeportivo.getNombre().equals(nombreN)) {
                System.out.println("ERROR! Existe una sede con dicho nombre");
                return null;
            }
        }
        
        System.out.print("Ingrese la Localizacion (Norte, Centro, Sur, Este u Oeste ): ");
        String localizacion = lector.nextLine();
        
        if ((localizacion.equals("Centro") == true) || (localizacion.equals("Norte") == true) || 
            (localizacion.equals("Sur") == true) || (localizacion.equals("Este") == true) || (localizacion.equals("Oeste") == true)) {
                System.out.println("ERROR! Existe un Complejo Deportivo con dicho nombre");
                return null;
            }
        
        System.out.print("Ingrese el Jefe de Organizacion ");
        String jefeOrganizacion = lector.nextLine();
        
        ComplejoDeportivo complejo = new ComplejoDeportivo(nombre, localizacion, jefeOrganizacion);
        return complejo;
    }
    
    
    
    public ComplejoDeportivo eliminarComplejoDeportivo(int identificador) { 
        
        for (ComplejoDeportivo complejoDeportivo : complejosDeportivos) {
            if (complejoDeportivo.getIdComplejoDeportivo()== identificador) {
                return complejoDeportivo;
            }
        }
        return null;
    }
    
    public ComplejoDeportivo readIdComplejoDeportivo(int identificador) {
        
        System.out.println("\nConsulta de Complejo Deportivo por Id");
        System.out.println("=======================================");
        
        for (ComplejoDeportivo complejoDeportivo : complejosDeportivos) {
            if (complejoDeportivo.getIdComplejoDeportivo() == identificador) {
                
            String idConRelleno = String.format("%03d", complejoDeportivo.getIdComplejoDeportivo());  // Relleno de ceros
            System.out.printf("%13s   %-23s   %-33s  %-33s  %15s\n", "Identificador", "Nombre", "Localizacion", "Jefe Organizacional", "Sede Olimpica");
            System.out.printf("%13s   %-23s   %-33s  %-33s  %15s\n", idConRelleno, complejoDeportivo.getNombre(), complejoDeportivo.getLocalizacion(), complejoDeportivo.getJefeOrganizacion(), getNombre());
            }
        }
        return null;
    }
    
    public ComplejoDeportivo readAllComplejoDeportivo() {
        System.out.println("\nConsulta de Todos Complejo Deportivo");
        System.out.println("======================================");
        
        System.out.printf("%13s   %-23s   %-33s  %-33s  %15s\n", "Identificador", "Nombre", "Localizacion", "Jefe Organizacional", "Sede Olimpica");
        for (ComplejoDeportivo complejoDeportivo : complejosDeportivos) {
            String idConRelleno = String.format("%03d", complejoDeportivo.getIdComplejoDeportivo());  // Relleno de ceros
            System.out.printf("%13s   %-23s   %-33s  %-33s  %15s\n", idConRelleno, complejoDeportivo.getNombre(), complejoDeportivo.getLocalizacion(), complejoDeportivo.getJefeOrganizacion(), getNombre());
        }
        return null;
    }
    
    public void modificarComplejoDeportivo(int identificador){
        Scanner scanner = new Scanner(System.in);
        for (ComplejoDeportivo complejoDeportivo : complejosDeportivos) {
            if (complejoDeportivo.getIdComplejoDeportivo()== identificador) {
                System.out.println("Sede encontrada  \n Ingrese el nuevo nombre: ");
                
                String nuevoNombre = scanner.next();
                System.out.println(nuevoNombre);
                complejoDeportivo.setNombre(nuevoNombre);
            }
        }
    }
    
}
