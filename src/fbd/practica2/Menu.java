package fbd.practica2;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;

/**
Clase para mostrar y pedir información desde la terminal.
Es la vista.
 */
public class Menu {
    private static Manejador manejador;
    private static Scanner s;

    private static final File f = new File("./database/empleados.csv");
    private static final File t = new File("./database/sucursales.csv");
    //private static final String nomArchivoEmpleados = "empleados.csv";
    //private static final String nomArchivoSucursales = "sucursales.csv";

    /**
    Lee los archivos, crea un manejador con los datos obtenidos, e inicia los 
    menúes.
    Al acabar los menúes, guarda la información.
     */
    public static void iniciaMenu(){
        leerBD();
        menuPrincipal();
        guardarBD();
    }
    
    /**
    * Método que escribe los datos actuales del manejador en los archvios de BD.
    * Siempre sobreescribe los archivos empleados.csv y sucursales.csv.
    * Imprime un mensaje en consola en caso de algún error.
    * @return true - si se logró, false de otro modo.
    */
    public static boolean guardarBD(){
        try {
            IO.escribir(f, manejador.getEmpleados());
            IO.escribir(t, manejador.getSucursales());
        } catch(Exception e) {
            System.out.println(" --Error al intentar guardar los archivos");
            return false;
        }
        return true;
    }
    
    
    /**
    * Método que lee los datos actuales en los archivos de BD y los toma en en Manejador.
    * Se desechan los datos actuales del Manejador..
    * Imprime un mensaje en consola en caso de algún error.
    * @return true - si se logró, false de otro modo.
    */
    public static boolean leerBD(){
        try{
            HashMap<Integer, Empleado> empleados = IO.leer(f);
            HashMap<Integer, Sucursal> sucursales = IO.leer(t);
            manejador = new Manejador();
            manejador.setEmpleados(empleados);
            manejador.setSucursales(sucursales);
        }catch(Exception e){
            System.out.println(" --Error al intentar cargar los archivos");
            return false;
        }
        return true;
    }

    /**
    Da la bienvienida y pide el tipo de entidad con el que se quiere trabajar.
    Después llama a @see fbd.practica2.Menu#menuAcciones()
     */
    private static void menuPrincipal() {
        int opcionEntidad = -1;
        String bienvenida = "Bienvenido al sistema manejador\n";
        System.out.println(bienvenida);
        while(opcionEntidad != 5) {
            String opciones = "";
            opciones += "Elija una opción\n";
            opciones += "  (1) Empleados\n";
            opciones += "  (2) Sucursal\n";
            opciones += "  (3) Recargar datos (desecha datos actuales)\n";
            opciones += "  (4) Guardar los datos actuales (sobreescribe archivos)\n";
            opciones += "  (5) Salir";
            System.out.println(opciones);

            s = new Scanner(System.in);
            opcionEntidad = s.nextInt();

            switch(opcionEntidad) {
                case 1:
                case 2: menuAcciones(opcionEntidad);
                break;
                case 3: leerBD();
                break;
                case 4: guardarBD();
                break;
                case 5:
                break;
                default : System.out.println("  ----Opción no válida----");
            }
        }
    }

    /**
    Pide el tipo de acción que se quiere realizar. Y llama al menú que se 
    encargará de realizar esa acción.
     */
    private static void menuAcciones(int entidad) {
        int opcion = -1;
        while(opcion != 5){
            String menu = "Elija una opción\n";
            menu += "  (1) Agregar\n";
            menu += "  (2) Eliminar\n";
            menu += "  (3) Modificar\n";
            menu += "  (4) Buscar sucursal por medio de empleado\n";
            menu += "  (5) Salir\n";
            System.out.println(menu);

            s = new Scanner(System.in);
            int opcionAcciones = s.nextInt();

            switch(opcionAcciones) {
                case 1 : menuAgrega(entidad);
                break;
                case 2: menuElimina(entidad);
                break;
                case 3: menuModifica(entidad);
                break;
                case 4: menuBuscar(entidad);
                case 5: opcion = 5;
                break;
                default : System.out.println("  ----Opción no válida----");
            }
        }
    }

    /**
    Pide el identificar del ejemplar a eliminar y lo elimina.
     */
    private static void menuElimina(int entidad){
        try {
            String menu = "";
            if(entidad == 1) {
                menu = "Ingrese número de empleado";
                System.out.println(menu);

                s = new Scanner(System.in);
                int numeroEmpleado = s.nextInt();
                manejador.eliminaEmpleado(numeroEmpleado);
                System.out.println("\n ¡Empleado eliminado exitosamente!");
            } else {
                menu = "Ingrese número de sucursal";
                System.out.println(menu);

                s = new Scanner(System.in);
                int numeroSucursal = s.nextInt();
                manejador.eliminaSucursal(numeroSucursal);
                System.out.println("\n ¡Sucursal eliminada exitosamente!");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    Pide la información necesario para agregar cierta instanci y la agrega
     */
    private static void menuAgrega(int entidad) {
        try {
            String menu = "";
            if(entidad == 1) {
                menu += "Ingrese la información del nuevo con el formato\n";
                menu += "nombres, apellido1, apellido2, puesto, salario, numero de sucursal";

                System.out.println(menu);
                
                s = new Scanner(System.in);
                
                String[] datos = s.next().split(",");

                manejador.agregaEmpleado(datos[0], datos[1], datos[2], datos[3],
                Integer.valueOf(datos[4]), Integer.valueOf(datos[5]));
                
            } else {
                menu += "Ingrese la información de la nueva sucursal con el formato\n";
                menu += "nombre";

                System.out.println(menu);
                
                s = new Scanner(System.in);
                
                String nombre = s.next();

                manejador.agregaSucursal(nombre);
            }
        } catch(Exception e) {
            System.out.println(" --Operación abortada, datos no válidos");
        }
    }

    /**
    Pide el identificaor de algún empleado y devuelve la información de la
    sucursal donde trabaja
     */
    private static void menuBuscar(int entidad){
        try {
            String menu = "";
            menu = "Ingrese número de empleado";
            System.out.println(menu);

            s = new Scanner(System.in);
            int numeroEmpleado = s.nextInt();
            Sucursal sucursal = manejador.buscaPorEmpleado(numeroEmpleado);
            System.out.println(sucursal);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    Pide un identificador y el número de atributo que se desea modificar
     */
    private static void menuModifica(int entidad){
        try {
            String menu = "";
            menu = "Ingrese identificador";
            System.out.println(menu);

            s = new Scanner(System.in);
            int id = s.nextInt();
            if(entidad == 1) {
                menu = "Elige atrubuto a modificar\n";
                menu += "  (1) Nombres\n";
                menu += "  (2) Apellido paterno\n";
                menu += "  (3) Apellido materno\n";
                menu += "  (4) Puesto\n";
                menu += "  (5) Salario\n";
                menu += "  (6) Número de sucursal\n";
                System.out.println(menu);

                int atrMod = s.nextInt();
                menu = "Ingrese nuevo valor del atributo\n";
                System.out.println(menu);
                String nuevoAtr = s.next();
                manejador.modificaEmpleado(id, atrMod, nuevoAtr);
            } else {
                menu = "Ingrese nuevo nombre\n";
                System.out.println(menu);
                String nuevoAtr = s.next();
                manejador.modificaSucursal(id, nuevoAtr);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
