import java.time.LocalDate;

public class Sales {
    public int[] salesForMonth = new int[12];
    public int year;

    LocalDate currentdate = LocalDate.now();

    int currentYear = currentdate.getYear();

    /**
     * Sets the property value of year but checks if the year is greater than the
     * current one and if so, it set the previous one.
     * 
     * @param year the year to check an set.
     */
    public void setYear(int year) {
        if (year < currentYear) {
            this.year = year;
        } else {
            this.year = currentYear - 1;
        }
    }

    /**
     * Return the value of the property year.
     * 
     * @return the year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Initializes the vector with random numbers between 0 and 1000 and the year
     * with a parameter.
     * 
     * @param year Parameter to inicialize the year.
     */
    public Sales(int year) {
        for (int i = 0; i < salesForMonth.length; i++) {
            this.salesForMonth[i] = (int) (Math.random() * 1001 + 0);
        }
        setYear(year);
    }

    /**
     * Returns the mean of vector values.
     * 
     * @return The mean
     */
    public double average() {
        double sum = 0;

        for (int i = 0; i < salesForMonth.length; i++) {
            sum = this.salesForMonth[i] + sum;
        }
        return sum / 12;
    }

    /**
     * Displays a bar graph on the screen.
     */
    public void graphic() {
        System.out.printf("Year %d:\n", getYear());
        System.out.println();

        for (int i = 0; i < this.salesForMonth.length; i++) {

            System.out.printf("Month %2d %6s: ", i + 1, "(" + this.salesForMonth[i] + ")");

            for (int j = 0; j <= this.salesForMonth[i]; j = j + 100) {
                System.out.print("#");

            }
            System.out.println();
        }
    }
}