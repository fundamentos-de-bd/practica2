package fbd.practica2;

import java.util.Map;

public class Manejador {
    private Map<Integer, Sucursal> sucursales;
    private Map<Integer, Empleado> empleados;

    public void setSucursales(Map<Integer, Sucursal> _sucursales) {
        sucursales = _sucursales;
    }

    public void setEmpleados(Map<Integer, Empleado> _empleados) {
        empleados = _empleados;
    }

    public void agregaEmpleado(String nombre, String apellidoP, String apellidoM,
    String puesto, int numSucursal){}

    public void eliminaEmpleado(int numEmpleado){}

    public void modificaEmpleado(int numEmpleado, int t, String nuevoP){}

    public Sucursal buscaPorEmpleado(int numEmpleado){
        return  null;
    }
}
