public class Core {
    public int[][] matrix;

    /**
     * Initialize an array of size NxN with random values between 0 and 10.
     * 
     * @param value The N value to create the matrix.
     */
    public Core(int value) {
        this.matrix = new int[value][value];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = (int) (Math.random() * 11 + 0);
            }
        }
    }

    /**
     * Displays an array that is passed as a parameter in table format.
     * 
     * @param matrix The array to display.
     */
    public void showMatrix(int[][] matrix) {
        for (int[] is : matrix) {
            for (int i : is) {
                System.out.printf("%3s", i);

            }
            System.out.println();
        }

    }

    /**
     * Returns the sum of all elements in the array.
     * 
     * @return the sum of array.
     */
    public int add() {
        int add = 0;
        for (int[] is : this.matrix) {
            for (int i : is) {
                add = add + i;
            }
        }
        return add;
    }

    /**
     * If it is true, returns the sum of the elements of the main diagonal of the
     * matrix. If false the sum of the rest of the elementens.
     * 
     * @param choose to select an option.
     * @return If it true sum of diagonal, if it false sum of the rest.
     */
    public int add(boolean choose) {
        int add = 0;

        if (choose) {
            for (int i = 0; i < this.matrix.length; i++) {
                add = add + this.matrix[i][i];
            }
            return add;
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    if (i != j) {
                        add = add + this.matrix[i][j];
                    }
                }
            }

        }
        return add;
    }

    /**
     * Sum of the elements of the row indicated .
     * 
     * @param value Indicates the elements of the row.
     * @return the sum of the row but if this row does not exist, it returns -1.
     */
    public int add(int value) {
        int add = 0;
        if (value >= this.matrix.length || value < 0) {

            return -1;
        } else {
            for (int i = 0; i < this.matrix.length; i++) {
                add = add + this.matrix[value][i];
            }
            return add;
        }
    }

    /**
     * Delete a row of a matrix.
     * 
     * @param row the number of the row to delete.
     * @return the array without the row deleted.
     */
    public int[][] deleteRow(int row) {
        int[][] matrixToReturn = new int[this.matrix.length - 1][this.matrix.length];
        boolean change = false;

        if (row >= this.matrix.length || row < 0) {
            return this.matrix;
        } else {

            for (int i = 0; i < matrixToReturn.length; i++) {
                for (int j = 0; j < matrixToReturn[i].length; j++) {
                    if (row == i) {
                        change = true;
                    }
                    if (change) {
                        matrixToReturn[i][j] = this.matrix[i + 1][j];
                    } else {
                        matrixToReturn[i][j] = this.matrix[i][j];
                    }
                }
            }
            return matrixToReturn;
        }
    }
}
