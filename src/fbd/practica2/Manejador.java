package fbd.practica2;

import java.util.HashMap;

public class Manejador {
    private HashMap<Integer, Sucursal> sucursales;
    private HashMap<Integer, Empleado> empleados;

    public Manejador() {
        sucursales = new HashMap<Integer, Sucursal>();
        empleados = new HashMap<Integer, Empleado>();
    }

    public void setSucursales(HashMap<Integer, Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public HashMap<Integer, Sucursal> getSucursales() {
        return sucursales;
    }

    public HashMap<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(HashMap<Integer, Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregaEmpleado(String nombre, String apellidoP, String apellidoM,
    String puesto, double salario, int numSucursal){
        Empleado e = new Empleado(nombre, apellidoP, apellidoM, puesto, salario,
        numSucursal);
        empleados.put(e.getNumEmpleado(), e);
    }

    public void agregaSucursal(String nombre) {
        Sucursal s = new Sucursal(nombre);
        sucursales.put(s.getNumSucursal(), s);
    }

    public void eliminaEmpleado(int numEmpleado) throws Exception{
        Empleado e = empleados.remove(numEmpleado);
        if (e == null) {
            throw new Exception("Número de empleado no válido");
        }
    }

    public void eliminaSucursal(int numSucursal) throws Exception{
        Sucursal s = sucursales.remove(numSucursal);
        if (s == null) {
            throw new Exception("Número de sucursal no válidos");
        }
    }

    public void modificaEmpleado(int numEmpleado, int t, String nuevoP)
    throws Exception{
        Empleado e = empleados.get(numEmpleado);
        if(e == null) {
            throw new Exception("Número de empleado no válido");
        }
        try {
            switch(t){
                case 1: e.setNombre(nuevoP);
                break;
                case 2: e.setApellidoPaterno(nuevoP);
                break;
                case 3: e.setApellidoMaterno(nuevoP);
                break;
                case 4: e.setPuesto(nuevoP);
                break;
                case 5: e.setSalario(Double.valueOf(nuevoP));
                break;
                case 6: e.setNumSucursal(Integer.valueOf(nuevoP));
                break;
            }
        } catch(Exception ex) {
            throw new Exception("Datos a modificar no válidos");
        }
    }

    public void modificaSucursal(int numSucursal, String nombre) throws Exception{
        Sucursal s = sucursales.get(numSucursal);
        if(s == null) {
            throw new Exception("Identificador no válido");
        }
        s.setNombre(nombre);
    }

    public Sucursal buscaPorEmpleado(int numEmpleado) throws Exception{
        Empleado e = empleados.get(numEmpleado);
        if(e == null) {
            throw new Exception("Indentificador no válido");
        }
        Sucursal s = sucursales.get(e.getNumSucursal());
        if(s == null) {
            throw new Exception("Sucursal no existente");
        }
        return s;
    }
}
