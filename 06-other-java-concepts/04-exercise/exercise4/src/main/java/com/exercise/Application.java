
package com.exercise;

public class Application {
  public static void main(String[] args) {
    Employee employee = new Employee("NameEmployeeQue", "LastNameEmployee", "7777777E", 22, 12000);
    employee.signatureMail();

    Executive executive = new Executive("NameExecutive12345678910111213141516", "LastNameExecutive", "7777777X", "Communication", 30, 17);
    executive.signatureMail();
  }
}
