public class Principal {

    public static void main(String[] args) {

        Empleado empleado = new Empleado();
        IUEmpleado iuEmpleado = new IUEmpleado(empleado);
        System.out.println("--------EMPLEADO---------");
        iuEmpleado.pedir();
        System.out.println("--------SUS DATOS--------");
        iuEmpleado.mostrar();

        Directivo directivo = new Directivo();
        IUDirectivo iuDirectivo = new IUDirectivo(directivo);
        System.out.println("--------DIRECTIVO--------");
        iuDirectivo.pedir();
        System.out.println("--------SUS DATOS--------");
        iuDirectivo.mostrar();
    
       

    }
}
