package fbd.practica2;

import java.io.*;

public class Datos{
    
    //Este método crea un archivo con 90 Empleado y otro con 1 Sucursal
    //Esta clase sólo sirve para crear un Empleados.csv y Sucursales.csv demo.
    public static void testCSV(){
        Empleado[] aa = new Empleado[90];
        for(int k = 0; k < 90; ++k){
            String p = String.valueOf(k);
            while(p.length() < 4)
                p = "0" + p;
            aa[k] = new Empleado("John", "Doe", p, "DummyRole", 0.01, 0);
        }
        try(
            FileWriter ff = new FileWriter("Empleados.csv", false);
            ){
            ff.write("Nombre, apellidoP, apellidoM, rol, salario, numSucursal, numEmpleado\n");
            for(int k = 0; k < 90; ++k){
                ff.write(aa[k].toCSV());
                ff.write("\n");
            }
            FileWriter ff = new FileWriter("Sucursales.csv", false);
            ){
            ff.write("Nombre, numSucursal\n");
                ff.write("Sucursal_placeholder0, 0");
                ff.write("\n");
            }
        }catch(IOException e){
            System.out.println("Algo salió mal :(");
            e.printStackTrace();
        }
    }
    
}
