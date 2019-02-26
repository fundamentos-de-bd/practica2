package fbd.practica2;

import java.util.HashMap;

public class Sucursal implements CSV{
    private static int proxNumSucursal;
    private int numSucursal;
    private HashMap<Integer, Empleado> empleados;

    public Empleado buscaEmpleado(int numEmpleado) {
        return empleados.get(numEmpleado);
    }

    public String toCSV() {
        return "";
    }
}
