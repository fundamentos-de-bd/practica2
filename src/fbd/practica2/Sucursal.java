package fbd.practica2;

import java.util.Set;

public class Sucursal implements CSV{
    private static int proxNumSucursal;
    private int numSucursal;
    private String nombre;
    //private HashMap<Integer, Empleado> empleados;

    public static void setNumSucursal(int nuevoNum) {
        proxNumSucursal = nuevoNum;
    }

    public Empleado buscaEmpleado(int numEmpleado) {
        return empleados.get(numEmpleado);
    }

    public int getNumSucursal() {
        return numSucursal;
    }

    public String toCSV() {
        return "";
    }

    public String toString() {

    }
}
