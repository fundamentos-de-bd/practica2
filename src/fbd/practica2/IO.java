package fbd.practica2;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class IO {

    
    /**
    * Método que lee un archivo csv y recupera los datos de tipo Sucursal.
    * Busca el archivo con el nombre proporcionado y lo lee siguiendo el formato esperado.
    * en caso de que ocurra un error se aborta la lectura y regresa null.
    * @param nombrearchivo - String con el nombre del archivo a leer.
    * @return Map que contiene los datos con sus Id's como llaves ó null si ocurre algo.
    */
    public static <T extends CSV> Map<Integer, T> leerSucursales(String nombrearchivo){
        HashMap<Integer, T> cosa = new HashMap<Integer, T>();
        String linea = "";
        try(
            BufferedReader ff = new BufferedReader(new FileReader(nombrearchivo));
            )
        {   
            while( (linea = ff.readLine()) != null){
                String[] parse = linea.split(", ");
                Sucursal.setProxNumSucursal(Integer.parseInt(parse[1]));
                Sucursal k = new Sucursal(parse[0]);
                cosa.put(k.getNumSucursal, k);
            }
        }catch(IOException e){
            System.out.println("----Algo salió mal al intentar recuperar los datos----");
            e.printStackTrace();
            return null;
        }
        return cosa;
    }
    
    /**
    * Método que lee un archivo csv y recupera los datos de tipo Empleado.
    * Busca el archivo con el nombre proporcionado y lo lee siguiendo el formato esperado.
    * en caso de que ocurra un error se aborta la lectura y regresa null.
    * @param nombrearchivo - String con el nombre del archivo a leer.
    * @return Map que contiene los datos con sus Id's como llaves ó null si ocurre algo.
    */
    public static <T extends CSV> Map<Integer, T> leerEmpleados(String nombrearchivo){
        HashMap<Integer, T> cosa = new HashMap<Integer, T>();
        String linea = "";
        try(
            BufferedReader ff = new BufferedReader(new FileReader(nombrearchivo));
            )
        {   
            while( (linea = ff.readLine()) != null){
                String[] parse = linea.split(", ");
                Empleado.setNumeroEmpleados(Integer.parseInt(parse[6]) );
                Empleado f = new Empleado(parse[0], parse[1], parse[2], parse[3], Double.parseDouble(parse[4]), Integer.parseInt(parse[5]));
                cosa.put(f.getNumEmpleado(), f);
            }
        }catch(IOException e){
            System.out.println("----Algo salió mal al intentar recuperar los datos----");
            e.printStackTrace();
            return null;
        }
        return cosa;
    }
    
    /**
    * Método que escribe un archivo con los datos CSV dados.
    * Escribe el archivo con el nombre proporcionado como parámetro. Toma los datos 
    * contenidos en el Map. Requiere que los valores del Map implementen "CSV".
    * @param nombrearchivo - nombre con el cual se quiere guardar los datos.
    * @param c - Map que contiene los datos como valores.
    * @return true si se logró reescribir el archivo de la base de datos (Datos.json)
    */
    public static <T extends CSV> boolean escribir(String nombrearchivo, Map<Integer, T> c){
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
            System.out.println("Algo salió mal :(");
            ex.printStackTrace();
            return false;
        }
    return true;
    }

}
