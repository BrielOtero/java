
package exercise;

import javax.swing.*;

public class Application {
  public static void main(String[] args) {
    Events events = new Events();
	events.setLocationRelativeTo(null);
	events.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	events.setSize(600,200);
	events.setVisible(true);
  }
}
