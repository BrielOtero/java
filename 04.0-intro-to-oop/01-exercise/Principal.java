public class Principal {

    public static void intercambiaRadios(Pelota pelota1, Pelota pelota2) {
        double aux = pelota1.getRadio();
        pelota1.setRadio(pelota2.getRadio());
        pelota2.setRadio(aux);
    }

    public static void main(String[] args) {
        // Creación Pelota 1
        Pelota pelota1 = new Pelota();
        // Asignación de valores Pelota 1
        pelota1.tipo = "Baloncesto";
        pelota1.setRadio(20);
        // Lo mostramos en pantalla.
        System.out.printf("El radio de Pelota 1 es %.2f y es de tipo %s\n", pelota1.getRadio(), pelota1.tipo);
        // Creación Pelota 2 y asignación de valores.
        Pelota pelota2 = new Pelota();
        // Lo mostramos en pantalla.
        System.out.printf("El radio de Pelota 2 es %.2f y es de tipo %s\n", pelota2.getRadio(), pelota2.tipo);
        // Creación Pelota 3 y asignación de valores.
        Pelota pelota3 = new Pelota("F?tbol", 22);
        // Lo mostramos en pantalla.
        System.out.printf("El radio de Pelota 3 es %.2f y es de tipo %s\n", pelota3.getRadio(), pelota3.tipo);

        pelota1.inflar();
        pelota2.inflar(10);
        System.out.printf("El radio de Pelota 1 es %.2f y es de tipo %s\n", pelota1.getRadio(), pelota1.tipo);
        System.out.printf("El radio de Pelota 2 es %.2f y es de tipo %s\n", pelota2.getRadio(), pelota2.tipo);

        intercambiaRadios(pelota1, pelota2);
        System.out.printf("El radio de Pelota 1 es %.2f y es de tipo %s\n", pelota1.getRadio(), pelota1.tipo);
        System.out.printf("El radio de Pelota 2 es %.2f y es de tipo %s\n", pelota2.getRadio(), pelota2.tipo);

    }
}
