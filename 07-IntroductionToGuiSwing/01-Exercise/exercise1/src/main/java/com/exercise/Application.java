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

import javax.swing.*;

public class Application {
  public static void main(String[] args) {
    int repeat = 0;
    int sum = 0;
    boolean error = false;
    String value1 = "";
    String value2 = "";
    do {
      do {
        try {
          error = false;
          value1 = JOptionPane.showInputDialog("Introduce the first number");
          value2 = JOptionPane.showInputDialog("Introduce the second number");
          sum = Integer.parseInt(value1) + Integer.parseInt(value2);
        } catch (NumberFormatException e) {
          error = true;
          JOptionPane.showMessageDialog(null, "Please introduce int values");
        }
      } while (error);
      JOptionPane.showMessageDialog(null,
          "The result is " + sum,
          "Result",
          JOptionPane.PLAIN_MESSAGE);
      repeat = JOptionPane.showConfirmDialog(null, "Do you want repeat?",
          "Repeat", JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE);

    } while (repeat == 0);
  }
}
