
package com.exercise;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.celestial.Planet;
import com.celestial.Star;

public class Application {

  /**
   * Ask for an int and check exceptions.
   * 
   * @return the int.
   */
  public static int askInt() {
    Scanner sc = new Scanner(System.in);
    int num = 0;

    boolean error;
    do {
      error = false;
      try {
        System.out.print("--> ");
        num = sc.nextInt();
        System.out.println();

      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Please introduce a correct number");
        error = true;
      }
    } while (error);

    return num;
  }

  /**
   * Ask for an double and check exceptions.
   * 
   * @return the double.
   */
  public static double askDouble() {
    Scanner sc = new Scanner(System.in);
    double num = 0;

    boolean error;
    do {
      error = false;
      try {
        System.out.print("--> ");
        num = sc.nextInt();
        System.out.println();

      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Please introduce a correct number");
        error = true;
      }
    } while (error);

    return num;
  }

  /**
   * Ask for an boolean and check exceptions.
   * 
   * @return the boolean.
   */
  public static boolean askBoolean() {
    Scanner sc = new Scanner(System.in);
    boolean value = false;

    boolean error;
    do {
      error = false;
      try {
        System.out.print("--> ");
        value = sc.nextBoolean();
        System.out.println();

      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Please introduce a correct value");
        error = true;
      }
    } while (error);

    return value;
  }

  /**
   * Ask for the name.
   * 
   * @return the name.
   */
  public static String askName() {
    Scanner sc = new Scanner(System.in);

    System.out.println();
    System.out.println("What is the Name");

    return sc.nextLine();
  }

  /**
   * Ask for the radio.
   * 
   * @return the radio.
   */
  public static double askRadio() {
    double radio;

    Scanner sc = new Scanner(System.in);
    do {

      System.out.println();
      System.out.println("What is the Radio");
      radio = askDouble();

    } while (radio < 0);

    return radio;
  }

  /**
   * Ask if is it gaseous.
   * 
   * @return if is it gaseous.
   */
  public static boolean askGaseous() {
    Scanner sc = new Scanner(System.in);
    boolean isGaseous = false;

    System.out.println();
    System.out.println("Is it gaseous?");

    isGaseous = askBoolean();

    return isGaseous;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Star> stars = new ArrayList<>();

    int menu;
    do {
      System.out.println();
      System.out.println("Choose an option: ");
      System.out.println();
      System.out.println("1. Add Planet");
      System.out.println("2. Add Star");
      System.out.println("3. Show Data");
      System.out.println("4. Delete repeated");
      System.out.println("5. Exit");
      menu = askInt();

      switch (menu) {
        case 1:
          int numberOfMoons;

          Planet planet = new Planet(askName(), askRadio(), askGaseous());
          stars.add(planet);

          do {
            System.out.println();
            System.out.println("How many moons does it have?");
            numberOfMoons = askInt();
          } while (numberOfMoons < 0);

          for (int i = 1; i <= numberOfMoons; i++) {
            System.out.println();
            System.out.printf("Values for -- %s -- moon", i);

            Planet moon = new Planet(askName(), askRadio(), false);
            planet.satellites.add(moon);
          }

          break;
        case 2:
          Star star = new Star(askName(),askRadio());
          stars.add(star);

          break;
        case 3:
          System.out.println();

          Planet moonShow;

          for (int i = 0; i < stars.size(); i++) {

            if (stars.get(i).getClass() == Star.class) {
              System.out.println();
              System.out.println("Star: " + stars.get(i).toString());

            } else {

              System.out.println();
              System.out.printf("Planet: %s %f\n", stars.get(i).getName('.'), stars.get(i).getRadio());
              moonShow = (Planet) stars.get(i);

              for (int j = 0; j < moonShow.satellites.size(); j++) {
                System.out.printf("- %s %f\n", moonShow.satellites.get(j).getName(),
                    moonShow.satellites.get(j).getRadio());
              }

            }
          }

          break;
        case 4:

          for (int i = 0; i < stars.size(); i++) {
            for (int j = stars.size()-1; j > i; j--) {
                if (stars.get(i).equals(stars.get(j))) {
                  stars.remove(j);
                }

            }
          }
          System.out.println("Repeated Stars or Planets are deleted");

          break;
        case 5:
          break;
        default:
          System.out.println();
          System.out.println("+----------------+");
          System.out.println("| Invalid option |");
          System.out.println("+----------------+");
          System.out.println();
          break;
      }
    } while (menu != 5);

  }
}
