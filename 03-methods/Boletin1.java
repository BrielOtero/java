public class Boletin1 {

    /**
     * Deja lineas en blanco
     * 
     * @param numeroEspacios Número de lineas que queremos insertar
     */
    public static void espacios(int numeroEspacios) {
        for (int i = 1; i <= numeroEspacios; i++) {
            System.out.println();
        }
    }

    /**
     * Indica si un número es Par o Impar
     * 
     * @param numero Número del que veremos si es Par o Impar
     * @return Devuelve True si es par, False si es Impar
     */
    public static boolean par(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Indica si un número es Positivo o Negativo
     * 
     * @param numeroPositivoNegativo Número del que comprobaremos si es Positivo o
     *                               Negativo
     * @return Devuelve "P" si numeroPositivoNegativo es positivo, "N" Si no lo es.
     */
    public static char positivoNegativo(int numeroPositivoNegativo) {
        return (numeroPositivoNegativo > 0 ? 'P' : 'N');
    }

    public static void main(String[] args) {
        espacios(20);
        System.out.println(par(8));
        System.out.println(par(7));

        System.out.println(positivoNegativo(5));
        System.out.println(positivoNegativo(-5));
        System.out.println(positivoNegativo(0));

    }
}