package fbd.practica2;

import java.util.Map;

public class Empleado implements CSV{
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String puesto;
    private double salario;
    private int numSucursal;
    private int numeroEmpleado;
    private static int proxNumEmpleado = 0;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, 
    String puesto, double salario, Sucursal sucursal) {
        
    }

    public String toCSV() {
        return "";
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String nuevoApellido){
        apellidoPaterno = nuevoApellido;
    }

    public String getApellidoMaterno(){
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String nuevoApellido){
        apellidoMaterno = nuevoApellido;
    }

    public String getPuesto(){
        return puesto;
    }

    public void setPuesto(String nuevoPuesto){
        puesto = nuevoPuesto;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double nuevoSalario){
        salario = nuevoSalario;
    }

    public int getSucursal(){
        return numSucursal;
    }

    public void setSucursal(int nuevoNumSucursal){
        numSucursal = nuevoNumSucursal;
    }

    public int getNumeroEmpleado(){
        return numeroEmpleado;
    }

    public String toString() {
        
    }
}
