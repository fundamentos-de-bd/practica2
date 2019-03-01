package fbd.practica2;

/**
Clase para modelar empleados
@version 0.1
@since 0.1
 */
public class Empleado implements CSV{
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String puesto;
    private double salario;
    private int numSucursal;
    private int numeroEmpleado;
    private static int proxNumEmpleado = 0;

    /**
    Constructor único
    @param nombre Nombre del alumno
    @param apellidoPaterno Primer apellido
    @param apellidoMaterno Primer apellido
    @param puesto Puesto del empleado
    @param salario Salario del empleado
    @param sucursal Número de sucursal donde trabaja el empleado
     */
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, 
    String puesto, double salario, int sucursal) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.salario = salario;
        numSucursal = sucursal;
        numeroEmpleado = proxNumEmpleado;
        proxNumEmpleado += 1;
    }

    /**
    Implementación de la interfaz @see fbd.practica2.CSV
    @return Representación en formato CSV de la instancia del empleado.
     */
    public String toCSV(){
        return nombre + ", " + apellidoPaterno + ", " + apellidoMaterno + ", " 
        + puesto + ", " + String.valueOf(salario) + ", " 
        + String.valueOf(salario) + ", " + String.valueOf(salario);
    }

    /**
    Obtener el nombre del empleado
    @return Nombre del empleado
     */
    public String getNombre(){
        return nombre;
    }

    /**
    Asignar el nombre al empleado
    @param nuevoNombre Nombre a asignar
     */
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    /**
    Obtener el primer apellido
    @return Primer apellido del empleado
     */
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }

    /**
    Asignar el primer apellido del empleado
    @param nuevoApellido Primer apellido a asignar
     */
    public void setApellidoPaterno(String nuevoApellido){
        apellidoPaterno = nuevoApellido;
    }

    /**
    Obtener el segundo apellido
    @return Segundo apellido del empleado
     */
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }

    /**
    Asignar el segundo apellido del empleado
    @param nuevoApellido Segundo apellido a asignar
     */
    public void setApellidoMaterno(String nuevoApellido){
        apellidoMaterno = nuevoApellido;
    }
    /**
    Obtener el puesto del empleado
    @return El puesto del empleado
     */
    public String getPuesto(){
        return puesto;
    }

    /**
    Asignar el puesto del empleado
    @param nuevoPuesto Puesto a asignar
     */
    public void setPuesto(String nuevoPuesto){
        puesto = nuevoPuesto;
    }

    /**
    Obtener el salario del empleado
    @return El salario del empleado
     */
    public double getSalario(){
        return salario;
    }
    /**
    Asignar el salario del empleado
    @param nuevoSalario El salario a asignar
     */
    public void setSalario(double nuevoSalario){
        salario = nuevoSalario;
    }

    /**
    Obtener el identificador de la sucursal donde trabaja el empleado
    @return Identificador de la sucursal
     */
    public int getNumSucursal(){
        return numSucursal;
    }

    /**
    Asignar la sucursal donde el empleado trabaja
    @param nuervaSucursal El identificador de la sucursal 
     */
    public void setNumSucursal(int nuevaSucursal){
        numSucursal = nuevaSucursal;
    }

    /**
    Obtener el número identificador del empleado
    @return El identificador del empleado
     */
    public int getNumEmpleado(){
        return numeroEmpleado;
    }

    /**
    Asignar el número global de empleado.
    Esto para asignar un número de inicio al usar un archivo de datos no vacío.
    @param a El punto de inicio para los nuevo identificadores
     */
    public static void setNumeroEmpleados(int a){
        proxNumEmpleado = a;
    }
    
    /**
    Obtener el número global del indentificador de empleados
    Esto es, la cantidad total de empleados que han sido registrados.
    @return El máximo de los identificadores + 1
     */
    public static int getNumeroEmpleados(){
        return proxNumEmpleado;
    }
    
    /**
    Una representación para mostrar en consola
    @return Una representación en cadena del empleado
     */
    public String toString() {
        return "Empleado número: " + numeroEmpleado + "\n Nombre: " + nombre
        + " " + apellidoPaterno + " " + apellidoMaterno + "\n Puesto: " + 
        puesto + "\n Salario: " + salario + "\n Sucursal: " + numSucursal; 
        
    }
}
