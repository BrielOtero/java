public class Directivo {
    private String nombre;
    private String apellidos;
    private String dni;
    private String nombreDepartamento;
    private int edad;
    private double porcentajeBeneficios;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento.toUpperCase();
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPorcentajeBeneficios(double porcentajeBeneficios) {
        if (porcentajeBeneficios >= 0 && porcentajeBeneficios <= 100) {
            this.porcentajeBeneficios = porcentajeBeneficios;
        } else {
            this.porcentajeBeneficios = 0;
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

    public String getNombreDepartamento() {
        return "\"" + this.nombreDepartamento + "\"";
    }

    public int getEdad() {
        return this.edad;
    }

    public double getPorcentajeBeneficios() {
        return this.porcentajeBeneficios;
    }

    // Contructores

    public Directivo() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.nombreDepartamento = "";
        this.edad = 0;
        this.porcentajeBeneficios = 0;
    }

    public Directivo(String nombre, String apellidos, String dni, String nombreDepartamento, int edad,
            double porcentajeBeneficios) {
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        setNombreDepartamento(nombreDepartamento);
        setEdad(edad);
        setPorcentajeBeneficios(porcentajeBeneficios);

    }

    // Method
    public double ganancias(double dineroGlobalBeneficio) {
        double beneficios = (getPorcentajeBeneficios() * dineroGlobalBeneficio) / 100;
        if (beneficios > 0) {
            return beneficios;
        } else {
            return 0;
        }
    }

}
