package fbd.practica2;

/**
Clase para modelar una sucursal de la cadena
 */
public class Sucursal implements CSV{
    private static int proxNumSucursal = 0;
    private int numSucursal;
    private String nombre;
    //private HashMap<Integer, Empleado> empleados;
    
    /**
    Constructor único
    @param a El nombre de la sucursal
     */
    public Sucursal(String a){
        nombre = a;
        numSucursal = proxNumSucursal;
        proxNumSucursal+=1;
    }

    /*public Empleado buscaEmpleado(int numEmpleado) {
        return empleados.get(numEmpleado);
    }*/
    
    /**
    Obtener el nombre de la sucursal
    @return El nombre de la sucursal
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
    Asignar el nombre a la sucursal
    @param a Nombre a asignar
     */
    public void setNombre(String a){
        nombre = a;
    }    
    
    /**
    Asigna el identificador máximo global de sucursales
    @param nuevoNum El nuevo inicio de los demás identificadores
     */
    public static void setProxNumSucursal(int nuevoNum) {
        proxNumSucursal = nuevoNum;
    }
    
    /**
    Obtiene en máximo número de identificadores de sucursales.
    @return El máximo identificador de las sucursales 
     */
    public static int getProxNumSucursal() {
        return proxNumSucursal;
    }

    /**
    Obtiene el identificador de la sucursal
    @return El identificador de la sucursal
     */
    public int getNumSucursal() {
        return numSucursal;
    }

    /**
    Obtiene la representación de la sucursal en formato CSV.
    @return Representación en formato CSV de la sucursal
     */
    public String toCSV() {
        return nombre + ", " + numSucursal;
    }

    /**
    Obtiene la representación de la sucursal.
    @return Representación en cadena de la sucursal
     */
    public String toString(){
        return "Nombre sucursal: " + nombre + "\n Número sucursal: " + numSucursal;
    }
}
