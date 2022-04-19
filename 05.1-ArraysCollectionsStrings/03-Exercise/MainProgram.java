import java.util.ArrayList;

public class MainProgram {

    public static ArrayList<Integer> a(int n) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int position = 0; position < n; position++) {
            numbers.add(position, (int) (Math.random() * 4001 + 1000));
        }
        /*
         * System.out.println(numbers.size());
         * System.out.println(numbers.get(2));
         */
        return numbers;
    }

    public static void b(ArrayList<Integer> numbersInts) {
        /*
         * System.out.println(numbersInts.size());
         * System.out.println(numbersInts.get(2));
         */
        for (int item : numbersInts) {
            System.out.println(item);
        }
    }

    public static int c(ArrayList<Integer> numbersInts) {
        int maximum = numbersInts.get(0);

        for (int position = 0; position < numbersInts.size(); position++) {
            if (numbersInts.get(position) > maximum) {
                maximum = numbersInts.get(position);
            }
        }
        return maximum;

    }

    public static int d(ArrayList<Integer> numbersInts) {
        int minimum = numbersInts.get(0);

        for (int position : numbersInts) {
            if (position < minimum) {
                minimum = position;
            }
        }
        return minimum;

    }

    public static boolean e(ArrayList<Integer> vectors, int index1, int index2) {
        int memory;

        // System.out.println(vectors.size());

        if (vectors.size() <= index1 || vectors.size() <= index2 || index1 < 0 || index2 < 0) {
            return false;
        } else {

            memory = vectors.get(index1);
            vectors.set(index1, vectors.get(index2));
            vectors.set(index2, memory);
            return true;
        }
    }

    public static ArrayList<Integer> neg(int n) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int position = 0; position < n - 1; position++) {
            numbers.add(position, (int) (Math.random() * 10001 + -5000));
        }
        /*
         * System.out.println(numbers.size());
         * System.out.println(numbers.get(2));
         */
        return numbers;
    }

    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<Integer>();
        test = a(30);

        ArrayList<Integer> testNeg = new ArrayList<Integer>();
        testNeg = neg(100);

        System.out.println("Exercise A");
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
