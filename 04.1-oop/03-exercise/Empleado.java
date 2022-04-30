public class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;
    private double salarioanual;
    private double irpf;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalarioAnual(double salarioanual) {
        this.salarioanual = salarioanual;
        
        if (salarioanual < 6000) {
            this.irpf= 7.5;
        } else {
            if (salarioanual > 30000) {
                this.irpf= 20;
            } else
            this.irpf= 15;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getDni() {
        return this.dni;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getSalarioAnual() {
        return this.salarioanual;
    }

    public double getIrpf() {
       return this.irpf;
    }

    // Constructores.

    public Empleado() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.edad = 0;
        this.salarioanual = 0;
        this.irpf = 7.5;

    }
    public Empleado(String nombre,String apellidos,String dni,int edad,double salarioanual){
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setEdad(edad);
        setSalarioAnual(salarioanual);
    }

    //Métodos.

    public double hacienda(){
        return getSalarioAnual()*getIrpf()/100;
    }
    

}