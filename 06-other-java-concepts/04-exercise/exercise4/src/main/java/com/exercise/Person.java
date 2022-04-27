package com.exercise;

abstract public class Person {
    private String name;
    private String lastName;
    private String dni;
    private int age;

    /**
     * Sets the value of property Name.
     * 
     * @param name the value to se in property Name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the value of property Last Name.
     * 
     * @param LastName the value to set in property Last Name.
     */
    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    /**
     * Sets the value of property Dni.
     * 
     * @param dni the value to set in property Dni.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Sets the value of the property Age.
     * 
     * @param age the value to set in property Age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the value of property Name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the value of property LastName.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return the value of property Dni.
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * @return the value of the property Age.
     */
    public int getAge() {
        return this.age;
    }

    public Person(String name, String lastName, String dni, int age){
        this.setName(name);
        this.setLastName(lastName);
        this.setDni(dni);
        this.setAge(age);
    }

    @Override
    /**
     * @return the name and the Last Name as a String.
     */
    public String toString() {
        return name + " " + lastName;
    }

    /**
     * Show values for signature.
     */
    abstract public void signatureMail();
}
