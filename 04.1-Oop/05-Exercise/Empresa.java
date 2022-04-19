public class Empresa {
    private double ganancias;
    private Directivo directivo;
    private Empleado empleado1;
    private Empleado empleado2;
    IUEmpleado iuEmpleado1;
    IUEmpleado iuEmpleado2;
    IUDirectivo iuDirectivo;

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public Directivo getDirectivo() {
        return directivo;
    }

    public void setDirectivo(Directivo directivo) {
        this.directivo = directivo;
    }

    public Empleado getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1) {
        this.empleado1 = empleado1;
    }

    public Empleado getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(Empleado empleado2) {
        this.empleado2 = empleado2;
    }

    public Empresa(Directivo directivo, Empleado empleado1, Empleado empleado2) {
        iuEmpleado1 = new IUEmpleado(empleado1);
        iuEmpleado2 = new IUEmpleado(empleado2);
        iuDirectivo = new IUDirectivo(directivo);

        setDirectivo(directivo);
        setEmpleado1(empleado1);
        setEmpleado2(empleado2);
    }

    public Empresa(Directivo directivo, Empleado empleado1, Empleado empleado2, double ganancias) {
        iuEmpleado1 = new IUEmpleado(empleado1);
        iuEmpleado2 = new IUEmpleado(empleado2);
        iuDirectivo = new IUDirectivo(directivo);

        setDirectivo(directivo);
        setEmpleado1(empleado1);
        setEmpleado2(empleado2);
        setGanancias(ganancias);
    }

}