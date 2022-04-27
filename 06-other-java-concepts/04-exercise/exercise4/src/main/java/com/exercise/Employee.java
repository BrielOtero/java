package com.exercise;

public class Employee extends Person {
    private double salaryAnnual;
    private double irpf;

    /**
     * Sets the value of the property SalaryAnnual and sets the irpf.
     * 
     * @param salaryAnnual the value to set into the property SalaryAnnual.
     */
    public void setSalaryAnnual(double salaryAnnual) {
        this.salaryAnnual = salaryAnnual;

        if (salaryAnnual < 6000) {
            this.irpf = 7.5;
        } else {
            if (salaryAnnual > 30000) {
                this.irpf = 20;
            } else
                this.irpf = 15;
        }
    }

    /**
     * @return the value of the property SalaryAnnual.
     */
    public double getSalaryAnnual() {
        return this.salaryAnnual;
    }

    /**
     * @return the value of the property Irpf.
     */
    public double getIrpf() {
        return this.irpf;
    }

    /**
     * Initialize employee with basic values.
     */
    public Employee() {
        this("", "", "", 0, 0);
    }

    /**
     * Initialize employee with parameters.
     * 
     * @param name         the value for initialize name.
     * @param lastName     the value for initialize last name.
     * @param dni          the value for initialize dni.
     * @param age          the value for initialize age.
     * @param salaryAnnual the value for initialize salary annual.
     */
    public Employee(String name, String lastName, String dni, int age, double salaryAnnual) {
        super(name, lastName, dni, age);
        setSalaryAnnual(salaryAnnual);
    }

    /**
     * Calculate the tax's with salary annual and irpf.
     * 
     * @return the tax's for the employee.
     */
    public double tax() {
        return getSalaryAnnual() * getIrpf() / 100;
    }

    @Override
    /**
     * Show the name and the last name for employee.
     */
    public void signatureMail() {
        System.out.println("-- Employee --");
        System.out.printf("Name       --> %-10s\n", this.getName());
        System.out.printf("Last Name  --> %-10s\n", this.getLastName());
        System.out.println();

    }
}