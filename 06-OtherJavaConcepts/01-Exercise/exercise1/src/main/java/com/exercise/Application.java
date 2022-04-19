
package com.exercise;

class BufWhatLongException extends IllegalArgumentException {

    public BufWhatLongException(String message) {
        super(message);
    }
}

public class Application {
    /**
     * Display each letter on a different line.
     * 
     * @param exercise String used to display letters on each line.
     */
    public static void showOnLine(String exercise) {

        for (int i = 0; i < exercise.length(); i++) {
            System.out.println(exercise.charAt(i));
        }
    }

    /**
     * Returns the specified fragment.
     * 
     * @param exercise   String that is used to return the fragment.
     * @param position   Integer with the position that is used to return the
     *                   fragment.
     * @param characters Integer with the number of characters thas is used to
     *                   return the fragment.
     * @return Returns the selected fragment of a string.
     */
    public static String subChain(String exercise, int position, int characters) {
        String stringToReturn = "";
        if (characters + position > exercise.length() || position < 0 || characters < 1) {

            throw new IllegalArgumentException("");

        } else {
            for (int i = position; i < characters + position; i++) {
                stringToReturn = stringToReturn + exercise.charAt(i);
            }
            return stringToReturn;
        }
    }

    /**
     * Shows a centered string.
     * 
     * @param exercise String to be displayed centered.
     */
    public static void showCenter(String exercise) {

        if (exercise.length() > 79) {
            throw new BufWhatLongException("Cadena demasiado larga");
        } else {

            int spaces = (80 - exercise.length()) / 2;
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            System.out.println(exercise);
        }
    }

    /**
     * Converts a string to a vector.
     * 
     * @param exercise String to convert to a vector.
     * @return a vector converted from string.
     */
    public static char[] chainToVector(String exercise) {
        char[] vector = new char[exercise.length()];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = exercise.charAt(i);
        }
        return vector;

    }

    /**
     * Invert a string.
     * 
     * @param exercise String to be reversed.
     * @return a string inverted.
     */
    public static String upsideDown(String exercise) {
        String stringToReturn = "";
        for (int i = exercise.length() - 1; i >= 0; i--) {
            stringToReturn = stringToReturn + exercise.charAt(i);
        }
        return stringToReturn;
    }

    /**
     * Concatenates and converts to uppercase.
     * 
     * @param exercise Strings to be concatenates and converts to uppercase.
     * @return string with strings concatenates and uppercase.
     */
    public static String capitalization(String... exercise) {
        String stringToReturn = "";
        char charToSave;
        for (int i = 0; i < exercise.length; i++) {

            for (int j = 0; j < exercise[i].length(); j++) {

                if (exercise[i].charAt(j) > 96 && exercise[i].charAt(j) < 123) {

                    charToSave = exercise[i].charAt(j);
                    charToSave = (char) (charToSave - 'a' + 'A');

                    stringToReturn = stringToReturn + charToSave;
                } else {

                    if (exercise[i].charAt(j) == 95) {

                        stringToReturn = stringToReturn + " ";
                    } else {

                        charToSave = exercise[i].charAt(j);
                        stringToReturn = stringToReturn + charToSave;
                    }
                }
            }
        }
        return stringToReturn;
    }

    public static void main(String[] args) {
        String exercise = "This is a test message";

        System.out.println("Exercise A");
        showOnLine(exercise);
        System.out.println();

        System.out.println("Exercise B");

        try {
            System.out.println(subChain(exercise, -1, 4));
            System.out.println(subChain(exercise, 2, 0));
            System.out.println(subChain(exercise, 2, -1));
            System.out.println(subChain(exercise, 2, 4));
            System.out.println();
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            System.out.println("Error Subchain");
            System.out.println();
        }

        try {
            System.out.println("Exercise C");
            showCenter(exercise);
            showCenter(
                    "Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_Test_Message_");
            System.out.println();

        } catch (BufWhatLongException i) {
            // TODO: handle exception
            System.out.println("Error Center");
            System.out.println();

        }

        System.out.println("Exercise D");
        System.out.println(chainToVector("Method"));
        System.out.println();

        System.out.println("Exercise E");
        System.out.println(upsideDown(exercise));
        System.out.println();

        System.out.println("Exercise F");
        System.out.println(capitalization("This_", "is_", "a_", "test_", "message"));
        System.out.println();

    }
}
