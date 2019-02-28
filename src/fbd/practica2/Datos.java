package fbd.practica2;

import java.io.*;
import org.json.*;

public class Datos{
    
    //Este método crea 90empleados
    //Esta clase sólo sirve para crear un Empleados.json demo.
    public static void testJSON(){
        Sucursal S = null;
        Empleado[] aa = new Empleado[90];
        for(int k = 0; k < 90; ++k){
            String p = String.valueOf(k);
            while(p.length() < 4)
                p = "0" + p;
            aa[k] = new Empleado("John", "Doe", p, "DummyRole", 0.01, S);
        }
        try(
            FileWriter ff = new FileWriter("Empleados.json", false);
            ){
            ff.write("//Empleados 90\n");
            for(int k = 0; k < 90; ++k){
                new JSONWriter(ff)
                    .object()
                        .key("nombre")
                            .value(aa[k].getNombre())
                        .key("apellidoPaterno")
                            .value(aa[k].getApellidoPaterno())
                        .key("apellidoMaterno")
                            .value(aa[k].getApellidoMaterno())
                        .key("puesto")
                            .value(aa[k].getPuesto())
                        .key("salario")
                            .value(String.valueOf(aa[k].getSalario()))
                        .key("sucursal")
                            .value("null")
                    .endObject();
                    ff.write("\n");
            }
        }catch(IOException e){
            System.out.println("Algo salió mal :(");
            e.printStackTrace();
        }
    }
    
}
