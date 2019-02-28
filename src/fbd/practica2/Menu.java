package fbd.practica2;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Menu {
    private static Manejador manejador;
    private static Scanner s;

    private static final String nomArchivoEmpleados = "empleados.csv";
    private static final String nomArchivoSucursales = "sucursales.csv";

    public static void iniciaMenu(){
        try{
            HashMap<Integer, Empleado> empleados = IO.leer(nomArchivoEmpleados);
            HashMap<Integer, Sucursal> sucursales = IO.leer(nomArchivoSucursales);
            manejador = new Manejador();
            manejador.setEmpleados(empleados);
            manejador.setSucursales(sucursales);
        }catch(Exception e){
            System.out.println("Error al intentar cargar los archivos");
        }
        menuPrincipal();
        try {
            IO.escribir(nomArchivoEmpleados, manejador.getEmpleados());
            IO.escribir(nomArchivoSucursales, manejador.getSucursales());
        } catch(Exception e) {
            System.out.println("Error al intentar guardar los archivos");
        }
    }

    private static void menuPrincipal() {
        int opcionEntidad = -1;
        String bienvenida = "Bienvenido al sistema manejador\n";
        System.out.println(bienvenida);
        while(opcionEntidad != 3) {
            String opciones = "";
            opciones += "Elija una opción\n";
            opciones += "(1) Empleados\n";
            opciones += "(2) Sucursal\n";
            opciones += "(3) Salir";
            System.out.println(opciones);

            s = new Scanner(System.in);
            opcionEntidad = s.nextInt();

            switch(opcionEntidad) {
                case 1:
                case 2: menuAcciones(opcionEntidad);
                break;
                case 3:
                break;
                default : System.out.println("Opción no válida");
            }
        }
    }

    private static void menuAcciones(int entidad) {
        int opcion = -1;
        while(opcion != 5){
            String menu = "Elija una opción\n";
            menu += "(1) Agregar\n";
            menu += "(2) Eliminar\n";
            menu += "(3) Modificar\n";
            menu += "(4) Buscar sucursal por medio de empleado\n";
            menu += "(5) Salir\n";
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
                default : System.out.println("Opción no válida");
            }
        }
    }

    private static void menuElimina(int entidad){
        try {
            String menu = "";
            if(entidad == 1) {
                menu = "Ingrese número de empleado";
                System.out.println(menu);

                s = new Scanner(System.in);
                int numeroEmpleado = s.nextInt();
                manejador.eliminaEmpleado(numeroEmpleado);
                System.out.println("Empleado eliminado exitosamente");
            } else {
                menu = "Ingrese número de sucursal";
                System.out.println(menu);

                s = new Scanner(System.in);
                int numeroSucursal = s.nextInt();
                manejador.eliminaSucursal(numeroSucursal);
                System.out.println("Sucursal eliminada exitosamente");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
            System.out.println("Datos no válidos");
        }
    }

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

    private static void menuModifica(int entidad){
        try {
            String menu = "";
            menu = "Ingrese identificador";
            System.out.println(menu);

            s = new Scanner(System.in);
            int id = s.nextInt();
            if(entidad == 1) {
                menu = "Elige atrubuto a modificar\n";
                menu += "(1) Nombres\n";
                menu += "(2) Apellido paterno\n";
                menu += "(3) Apellido materno\n";
                menu += "(4) Puesto\n";
                menu += "(5) Salario\n";
                menu += "(6) Número de sucursal";
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
