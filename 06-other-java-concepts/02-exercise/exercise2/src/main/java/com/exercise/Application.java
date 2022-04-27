/*-
 * =====LICENSE-START=====
 * Java 11 Application
 * ------
 * Copyright (C) 2020 - 2022 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */

package com.exercise;

import java.util.ArrayList;
import java.util.*;

import com.geometry.Circumference;
import com.geometry.Figure;
import com.geometry.Line;
import com.geometry.Point;
import com.geometry.Polygon;
import com.iu.*;

public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Figure> figures = new ArrayList<>();

    int menu;
    do {
      System.out.println();
      System.out.println("Choose an option: ");
      System.out.println();
      System.out.println("1. Insert a Line");
      System.out.println("2. Insert a Triangle");
      System.out.println("3. Insert a Square");
      System.out.println("4. Insert a Circumference");
      System.out.println("5. Show the elements of a collection");
      System.out.println("6. Show data of an element of a collection");
      System.out.println("7. Exit");
      System.out.print("--> ");
      menu = Library.askInt();
      sc.nextLine();
      System.out.println();
      switch (menu) {
        case 1:
          Line lines = new Line(new Point(), new Point(2, 4));
          figures.add(lines);
          break;
        case 2:
          Polygon polygonTriangle = new Polygon();
          figures.add(polygonTriangle);
          break;
        case 3:
          Point pointSquare = new Point(1, 2);
          Polygon polygonsSquare = new Polygon("SQUARE", pointSquare, 4);
          figures.add(polygonsSquare);
          break;
        case 4:
          Point pointCircumference = new Point();
          Circumference circumferences = new Circumference(pointCircumference, 2);
          figures.add(circumferences);
          break;
        case 5:
          for (Figure figure : figures) {
            System.out.println(figure.getName());
          }
          break;
        case 6:
          int index;
          System.out.println();
          for (int i = 0; i < figures.size(); i++) {
            System.out.printf("Figure %20s index %s\n", figures.get(i).getName(), i);
          }
          do {
            System.out.println();
            System.out.println("Insert the index to search: ");
            index = Library.askInt();
          } while (index > figures.size() - 1 || index < 0);

          figures.get(index).showData();

          break;
        case 7:
          break;
        default:
          System.out.println();
          System.out.println("+----------------+");
          System.out.println("| Invalid option |");
          System.out.println("+----------------+");
          System.out.println();
          break;
      }
    } while (menu != 7);

  }
}
