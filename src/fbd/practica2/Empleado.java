package fbd.practica2;

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
    String puesto, double salario, int sucursal) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.salario = salario;
        numSucursal = sucursal;
        //registros.put(proxNumEmpleado, this);
        proxNumEmpleado += 1;
    }

    public String toCSV(){
        return nombre + ", " + apellidoPaterno + ", " + apellidoMaterno + ", " + puesto + ", "
        + String.valueOf(salario) + ", " + String.valueOf(salario) + ", " + String.valueOf(salario) 
        + ".";
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

    public int getNumSucursal(){
        return numSucursal;
    }

    public void setNumSucursal(int nuevaSucursal){
        numSucursal = nuevaSucursal;
    }

    public int getNumeroEmpleado(){
        return numeroEmpleado;
    }
    
    /**Documentación.
    Esto es una breve descripción.
    @param g - una cosa.
    @param f - otra cosa.
    @return o - cosa de resultado descrito arriba.
    */
    public static void setNumeroEmpleados(int a){
        proxNumEmpleado = a;
    }
    
    public static int getNumeroEmpleados(){
        return proxNumEmpleado;
    }
}
