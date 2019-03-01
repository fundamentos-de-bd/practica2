package fbd.practica2;

import java.util.HashMap;

/**
Clase para manipular los datos de Empleado y de Sucursal
 */
public class Manejador {
    private HashMap<Integer, Sucursal> sucursales;
    private HashMap<Integer, Empleado> empleados;

    /**
    Constructor único.
    Inicializa las estructuras sin datos.
     */
    public Manejador() {
        sucursales = new HashMap<Integer, Sucursal>();
        empleados = new HashMap<Integer, Empleado>();
    }

    /**
    Asigna la estrucutra de instancias de sucursales.
    @param sucursales Asinga la estrucutura de instancias de sucursales
     */
    public void setSucursales(HashMap<Integer, Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
    /**
    Obtener la estructura de instancia de sucursales
    @return Estrucuta de sucursales
     */
    public HashMap<Integer, Sucursal> getSucursales() {
        return sucursales;
    }

    /**
    Obtener la estructura de instancia de empleados
    @return Estrucuta de empleados 
     */
    public HashMap<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    /**
    Asigna la estrucutra de instancias de empleados.
    @param empleados Asinga la estrucutura de instancias de empleados
     */
    public void setEmpleados(HashMap<Integer, Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
    Agrega una nueva instancia de empleado a la estructura de empleados
    @param nombre Nombre del empleado
    @param apellidoP Primer apellido del empleado
    @param apellidoM Segundo apellido del empleado
    @param puesto Puesto del empleado
    @param salario Salario del empleado
    @param numSucursal Identificador de la sucursal donde labora el empleado
     */
    public void agregaEmpleado(String nombre, String apellidoP, String apellidoM,
    String puesto, double salario, int numSucursal){
        Empleado e = new Empleado(nombre, apellidoP, apellidoM, puesto, salario,
        numSucursal);
        empleados.put(e.getNumEmpleado(), e);
    }

    /**
    Añade una nueva instancia de sucursal a la estrucutura de sucursales
    @param nombre Nombre de la nueva sucursal
     */
    public void agregaSucursal(String nombre) {
        Sucursal s = new Sucursal(nombre);
        sucursales.put(s.getNumSucursal(), s);
    }

    /**
    Quita un empleado de la estructura de empleados
    @param numEmpleado Identificador del empleado a eliminar
    @throws Exception Si el identificador no está registrado
     */
    public void eliminaEmpleado(int numEmpleado) throws Exception{
        Empleado e = empleados.remove(numEmpleado);
        if (e == null) {
            throw new Exception("Número de empleado no válido");
        }
    }

    /**
    Quita una sucursal de la estructura de sucursales
    @param numSucursal Identificador de la sucursal a eliminar
    @throws Exception Si el identificador no está registrado
     */
    public void eliminaSucursal(int numSucursal) throws Exception{
        Sucursal s = sucursales.remove(numSucursal);
        if (s == null) {
            throw new Exception("Número de sucursal no válidos");
        }
    }
    /**
    Modifica los atributos de un empleado en particular
    @param numEmpleado Identificador del empleado a modificar
    @param t El número del atributo tal como aparecen en @see fbd.practica2.Menu#menuModifica()
    @param nuevoP El nuevo valor del atributo
    @throws Exception Si el identificador no es válido o los datos no son correctos
     */
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

    /**
    Modifica los atributos de una sucursal en particular
    @param numSucursal Identificador de la sucursal a modificar
    @param nombre El nuevo valor del atributo
    @throws Exception Si el identificador no es válido o los datos no son correctos
     */
    public void modificaSucursal(int numSucursal, String nombre) throws Exception{
        Sucursal s = sucursales.get(numSucursal);
        if(s == null) {
            throw new Exception("Identificador no válido");
        }
        s.setNombre(nombre);
    }

    /**
    Busca una sucursal en base a alguno de sus empleados
    @param numEmpleado Indentificador del empleado de la sucursal
    @return La sucursal donde trabaja el empleado dado
    @throws Exception Si el identificador no es válido o los datos no son correctos
     */
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
