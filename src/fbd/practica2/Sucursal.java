package fbd.practica2;


public class Sucursal implements CSV{
    private static int proxNumSucursal = 0;
    private int numSucursal;
    private String nombre;
    //private HashMap<Integer, Empleado> empleados;
    
    public Sucursal(String a){
        nombre = a;
        numSucursal = proxNumSucursal;
        proxNumSucursal+=1;
    }

    /*public Empleado buscaEmpleado(int numEmpleado) {
        return empleados.get(numEmpleado);
    }*/
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String a){
        nombre = a;
    }    
    
    public static void setProxNumSucursal(int nuevoNum) {
        proxNumSucursal = nuevoNum;
    }
    
    public static int getProxNumSucursal(int nuevoNum) {
        return proxNumSucursal;
    }

    public int getNumSucursal() {
        return numSucursal;
    }

    public String toCSV() {
        return toString();
    }

    public String toString(){
        return nombre + ", " + numSucursal;
    }
}
