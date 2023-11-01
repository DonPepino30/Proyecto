package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<SedeOlimpica> sedesOlimpicas = new ArrayList<>();
    
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args){
        while (true) {
            mostrarMenuPrincipal();

            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1:
                    SedeOlimpica sedeADD = agregarSedeOlimpica();
                    if (!(sedeADD == null)) {
                        sedesOlimpicas.add(sedeADD);
                        System.out.println("La sede ha sido creada con exito");
                    }
                    break;
                case 2:
                    int idElim;
                    System.out.println("Ingrese el ID a eliminar:");
                    idElim=lector.nextInt();
                    SedeOlimpica sedeDEL = eliminarSedeOlimpica(idElim);
                    if (!(sedeDEL == null)) {
                        sedesOlimpicas.remove(sedeDEL);
                        System.out.println("La sede ha sido eliminada con exito");
                    }
                    break;
                case 3:
                    int idMod;
                    System.out.println("Ingrese el ID a modificar: ");
                    idMod=lector.nextInt();
                    modificarSedeOlimpica(idMod);
                    System.out.println("La sede ha sido modificada con exito");
                    break;
                case 4:
                    readAllSedeOlimpica();
                    break;
                case 5:
                    int idBus;
                    System.out.println("Ingrese el ID a buscar: ");
                    idBus=lector.nextInt();
                    readIdSedeOlimpica(idBus);
                    break;
                case 6:
                    System.out.println("Ingrese el ID de la Sede a Administrar: ");
                    int idSedeAdm= lector.nextInt();
                    
                    sedesOlimpicas.get(idSedeAdm).gestionarMenuComplejoDeportivo();
                    break;
                case 7:
                    salir();
                    break;      
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
    
    public static void mostrarMenuPrincipal(){
        System.out.println("========================================");
        System.out.println("Bienvenido al Gestos de Sedes Olimpicas");
        System.out.println("========================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. |Agregar Sede Olimpica|");
        System.out.println("2. |Eliminar Sede Olimpica|");
        System.out.println("3. |Modificar Sede Olimpica|");
        System.out.println("4. |Consultar Todos Sede Olimpica|");
        System.out.println("5. |Consultar por ID Sede Olimpica|");
        System.out.println("6. |Gestion de Complejos Deportivos|");
        System.out.println("7. |Salir|");
        System.out.print("Ingrese la opción: ");   
    }
    
    public static void salir() {
        System.exit(0);
    }
    
    public static SedeOlimpica agregarSedeOlimpica() { 
        
        System.out.println("Adición de Sedes Olimpicas");
        System.out.println("==========================");

        System.out.print("Ingrese el nombre: ");
        String nombre = lector.nextLine();
        
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            if (sedeOlimpica.getNombre().equals(nombre)) {
                System.out.println("ERROR! Existe una sede con dicho nombre");
                return null;
            }
        }

        System.out.print("Ingrese la ubicacion: ");
        String ubicacion = lector.nextLine();
        
        SedeOlimpica sede = new SedeOlimpica(nombre,ubicacion);
        return sede;
    }
    
    
    
    public static SedeOlimpica eliminarSedeOlimpica(int identificador) { 
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            if (sedeOlimpica.getIdSedeOlimpica() == identificador) {
                return sedeOlimpica;
            }
        }
        return null;
    }    
    
    public static SedeOlimpica readIdSedeOlimpica(int identificador) {
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            if (sedeOlimpica.getIdSedeOlimpica() == identificador) {
                
                System.out.println("La sede ha sido modificada con exito \n");
                String idConRelleno = String.format("%03d", sedeOlimpica.getIdSedeOlimpica());  // Relleno de ceros
                System.out.printf("%13s   %-23s   %15s\n", "Identificador", "Nombre", "Ubicacion");
                System.out.printf("%13s   %-23s   %15s\n", idConRelleno, sedeOlimpica.getNombre(), sedeOlimpica.getUbicacion());
            }
        }
        return null;
    }
    
    public static SedeOlimpica readAllSedeOlimpica() {
        System.out.printf("%13s   %-23s   %15s\n", "Identificador", "Nombre", "Ubicacion");
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            String idConRelleno = String.format("%03d", sedeOlimpica.getIdSedeOlimpica());  // Relleno de ceros
            System.out.printf("%13s   %-23s   %15s\n", idConRelleno, sedeOlimpica.getNombre(), sedeOlimpica.getUbicacion());
        }
        return null;
    }
    
    public static void modificarSedeOlimpica(int identificador){
        Scanner scanner = new Scanner(System.in);
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            if (sedeOlimpica.getIdSedeOlimpica()== identificador) {
                System.out.println("Sede encontrada  \n Ingrese el nuevo nombre: ");
                
                String nuevoNombre = scanner.next();
                System.out.println(nuevoNombre);
                sedeOlimpica.setNombre(nuevoNombre);
            }
        }
    }
    
    /*public static SedeOlimpica readByNameSede(String nombre){
        for (SedeOlimpica sedeOlimpica : sedesOlimpicas) {
            if(sedeOlimpica.getNombre().equals(nombre)){
                return sedeOlimpica;
            }
        }
        return null;
    }*/
   
}