package fbd.practica2;

import java.io.*;

/**
 * Faker para poblar los archivos a manera de demo
 */
public class Datos{
    /**
     * Este método crea un archivo con 90 Empleado y otro con 1 Sucursal
     * Esta clase sólo sirve para crear un Empleados.csv y Sucursales.csv demo.
     */
    public static void testCSV(){
        Empleado[] aa = new Empleado[90];
        for(int k = 0; k < 90; ++k){
            String p = String.valueOf(k);
            while(p.length() < 4)
                p = "0" + p;
            aa[k] = new Empleado("John", "Doe", p, "DummyRole", 0.01, 0);
        }
        try(
            FileWriter ff = new FileWriter("empleados.csv", false); 
            FileWriter tt = new FileWriter("sucursales.csv", false)
            ){
            for(int k = 0; k < 90; ++k){
                ff.write(aa[k].toCSV());
                ff.write("\n");
            }
            tt.write("Sucursal_placeholder0, 0");
            tt.write("\n");
        }catch(IOException e){
            System.out.println("Algo salió mal :(");
            e.printStackTrace();
        }
    }
    
}
