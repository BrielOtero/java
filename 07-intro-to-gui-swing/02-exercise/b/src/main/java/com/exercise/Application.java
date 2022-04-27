
package com.exercise;

import javax.swing.*;

public class Application {
  public static void main(String[] args) {
    Events frame = new Events();

    frame.setLocationRelativeTo(null);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(500,500);

    frame.setVisible(true);
  }
}
