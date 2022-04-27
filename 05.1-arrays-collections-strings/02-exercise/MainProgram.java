// Hay que hacerlo con CHAR.
public class MainProgram {
    public static int[][] a(int x, int y) {
        int[][] number = new int[x][y];
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i].length; j++) {
                number[i][j] = (int) (Math.random() * 26 + 'A');
            }
        }
        return number;
    }

    public static void b(int[][] numbersInts) {
        for (int[] item : numbersInts) {
            for (int value : item) {
                System.out.printf("%3c", value);
            }
            System.out.println();
        }

    }

    public static int c(int[][] numbersInts) {
        int maximum = numbersInts[0][0];

        for (int i = 0; i < numbersInts.length; i++) {
            for (int j = 0; j < numbersInts[i].length; j++) {
                if (numbersInts[i][j] > maximum) {
                    maximum = numbersInts[i][j];
                }
            }
        }
        return maximum;

    }

    public static int d(int[][] numbersInts) {
        int minimum = numbersInts[0][0];

        for (int[] item : numbersInts) {
            for (int value : item) {
                if (value < minimum) {
                    minimum = value;
                }
            }
        }
        return minimum;

    }

    public static boolean e(int[][] vectors, int indX1, int indX2, int indY1, int indY2) {
        int memory = 0;

        if (vectors.length <= indX1 || vectors.length <= indX2 || indX1 < 0 || indX2 < 0 || vectors[0].length < indY1
                || vectors[0].length < indY2) {
            return false;
        } else {
            memory = vectors[indX1][indY1];
            vectors[indX1][indY1] = vectors[indX2][indY2];
            vectors[indX2][indY2] = memory;
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] test = a(5, 5);
        int[][] eArray = a(3, 4);

        System.out.println("Exercise A");
        System.out.println();

        System.out.println("Exercise B");
        b(test);
        System.out.println();

        System.out.println("Exercise C Maximum");
        System.out.printf("%c", c(test));
        System.out.println();

        System.out.println("Exercise D Minimum");
        System.out.printf("%c", d(test));
        System.out.println();

        System.out.println("Exercise E");
        System.out.println(e(eArray, 1, 2, 3, 1));
        System.out.println(e(eArray, 1, 3, 4, 1));
        System.out.println(e(eArray, -5, 4, 3, 1));
        System.out.println(e(eArray, 1, 2, 1, 10));

    }
}
