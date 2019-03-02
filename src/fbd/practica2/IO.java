package fbd.practica2;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

/**
 * Clase para leer y escribr desde archivos a objetos en formato CSV
 */
public class IO {
    
    /**
    * Método que lee un archivo csv y recupera los datos de tipo correspondiente.
    * Busca el archivo con el nombre proporcionado y lo lee siguiendo el formato esperado.
    * en caso de que ocurra un error se crea un archivo en blanco y tegresa un HashMap vacio
    * @param nombrearchivo - String con el nombre del archivo a leer.
    * @param <T> El tipo de objeto que se va a leer. Tiene que tener implemetnar 
    * @see fbd.practica2.CSV
    * @return Map que contiene los datos con sus Id's como llaves ó null si ocurre algo.
    */
    @SuppressWarnings("unchecked")
    public static <T extends CSV> HashMap<Integer, T> leer(File nombrearchivo){
        HashMap<Integer, T> cosa = new HashMap<Integer, T>();
        String linea = "";
        try(
            BufferedReader ff = new BufferedReader(new FileReader(nombrearchivo));
            )
        {   
            while( (linea = ff.readLine()) != null){
                String[] parse = linea.split(", ");
                if(parse.length > 2){
                    Empleado.setNumeroEmpleados(Integer.parseInt(parse[6]) );
                    Empleado f = new Empleado(parse[0], parse[1], parse[2], parse[3], Double.parseDouble(parse[4]), Integer.parseInt(parse[5]));
                    cosa.put(f.getNumEmpleado(), (T) f );
                }else{
                    Sucursal.setProxNumSucursal(Integer.parseInt(parse[1]));
                    Sucursal k = new Sucursal(parse[0]);
                    cosa.put(k.getNumSucursal(), (T) k);
                }
            }
        }catch(IOException e){
            System.out.println("----Algo salió mal al intentar recuperar los datos----\n    se creará un nuevo archivo en blanco");
            new File("./database").mkdirs();
            escribir(nombrearchivo, cosa);
        }
        return cosa;
    }
    
    /**
    * Método que escribe un archivo con los datos CSV dados.
    * Escribe el archivo con el nombre proporcionado como parámetro. Toma los datos 
    * contenidos en el Map. Requiere que los valores del Map implementen "CSV".
    * @param nombrearchivo - nombre con el cual se quiere guardar los datos.
    * @param c - Map que contiene los datos como valores.
    * @param <T> El tipo de objeto que se va a eescribir. Tiene que tener implemetnar 
    * @return true si se logró reescribir el archivo de la base de datos (Datos.json)
    */
    public static <T extends CSV> boolean escribir(File nombrearchivo, HashMap<Integer, T> c){
        try(
            FileWriter ff = new FileWriter(nombrearchivo, false);
            )
        {
            Collection<T> e = c.values();
            for(T q: e){
                ff.write(q.toCSV());
                ff.write("\n");
            }
        }catch(IOException ex){
            System.out.println(" ---No fue posible escribir los cambios---");
            return false;
        }
    return true;
    }
    
}
