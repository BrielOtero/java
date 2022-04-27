package com.exercise;

public class Executive extends Person {
    private String departmentName;
    private double profitPercentage;

    /**
     * Sets the value of the property DepartmentName in uppercase.
     * 
     * @param departmentName the value to set in property DepartmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName.toUpperCase();
    }

    /**
     * Sets the value of the property ProfitPercentage. If it less 0 or higher than
     * 100 set 0.
     * 
     * @param profitPercentage the value to set in property ProfitPercentage.
     */
    public void setProfitPercentage(double profitPercentage) {
        if (profitPercentage >= 0 && profitPercentage <= 100) {
            this.profitPercentage = profitPercentage;
        } else {
            this.profitPercentage = 0;
        }
    }

    /**
     * @return the value of the property DepartmentName between quotes.
     */
    public String getDepartmentName() {
        return "\"" + this.departmentName + "\"";
    }

    /**
     * @return the value of the property ProfitPercentage.
     */
    public double getProfitPercentage() {
        return this.profitPercentage;
    }

    /**
     * Initialize Executive with basic values.
     */
    public Executive() {
        this("", "", "", "", 0, 0);
    }

    /**
     * Initialize Executive with parameters.
     * 
     * @param name             the value for initialize name.
     * @param lastName         the value for initialize last name.
     * @param dni              the value for initialize dni.
     * @param departmentName   the value for initialize departmentName.
     * @param age              the value for initialize age.
     * @param profitPercentage the value for initialize profitPercentage.
     */
    public Executive(String name, String lastName, String dni, String departmentName, int age,
            double profitPercentage) {
        super(name, lastName, dni, age);
        setDepartmentName(departmentName);
        setProfitPercentage(profitPercentage);

    }

    /**
     * Returns the profits of the executive, calculates with profit percentage and
     * global money profit.
     * 
     * @param globalMoneyProfit the global amount of money profit.
     * @return the profits of the executive.
     */
    public double profits(double globalMoneyProfit) {
        double profits = (getProfitPercentage() * globalMoneyProfit) / 100;
        if (profits > 0) {
            return profits;
        } else {
            return 0;
        }
    }

    /**
     * Shorten an String
     * 
     * @param text the String to be shorter
     * @return the original String cutted
     */
    public static String shorten(String text) {
        if (text.length() > 20) {
            return text.substring(0, 19) + ".";
        } else {
            return text;
        }
    }

    @Override
    /**
     * Shows the name, last name and the name of the department of the Executive.
     */
    public void signatureMail() {

        System.out.println("-- Executive --");
        System.out.println();
        System.out.printf("***************************************\n");
        System.out.printf("* Name       --> %-20s *\n", shorten(this.getName()));
        System.out.printf("* Last Name  --> %-20s * \n", shorten(this.getLastName()));

        System.out.printf("* Department --> %-20s *\n", shorten(departmentName));
        System.out.printf("***************************************\n");

        System.out.println();
    }

}