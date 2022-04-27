import java.util.Arrays;

public class MainProgram {

    public static int[] a(int n) {
        int[] number = new int[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = (int) (Math.random() * 4001 + 1000);
        }
        return number;
    }

    public static void b(int[] numbersInts) {
        for (int item : numbersInts) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println();

    }

    public static int c(int[] numbersInts) {
        int maximum = numbersInts[0];

        for (int i = 1; i < numbersInts.length; i++) {
            if (numbersInts[i] > maximum) {
                maximum = numbersInts[i];
            }
        }
        return maximum;

    }

    public static int d(int[] numbersInts) {
        int minimum = numbersInts[0];

        for (int item : numbersInts) {
            if (item < minimum) {
                minimum = item;
            }
        }
        return minimum;

    }

    public static boolean e(int[] vectors, int index1, int index2) {
        int memory = 0;

        if (vectors.length <= index1 || vectors.length <= index2 || index1 < 0 || index2 < 0) {
            return false;
        } else {
            /*
             * System.out.println("Index Vector 1 " + vector[index1]);
             * System.out.println("Index Vector 2 " + vector[index2]);
             */
            memory = vectors[index1];
            vectors[index1] = vectors[index2];
            vectors[index2] = memory;
            /*
             * System.out.println("Index Vector 1 " + vector[index1]);
             * System.out.println("Index Vector 2 " + vector[index2]);
             */

            return true;
        }
    }

    public static int[] neg(int n) {
        int[] number = new int[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = (int) (Math.random() * 10001 + -5000);
        }
        return number;
    }

    public static void main(String[] args) {
        int[] test = a(10);
        int[] testNeg = neg(10);

        System.out.println("Exercise A");
        System.out.println(Arrays.toString(test));
        System.out.println();

        System.out.println("Exercise B");
        b(test);
        System.out.println();

        System.out.println("Exercise C Maximum");
        System.out.println(c(testNeg));
        System.out.println();

        System.out.println("Exercise D Minimum");
        System.out.println(d(testNeg));
        System.out.println();

        System.out.println("Exercise E");
        System.out.println(e(test, 31, 5));
        System.out.println(e(test, 30, 5));
        System.out.println(e(test, 29, 5));

    }
}
