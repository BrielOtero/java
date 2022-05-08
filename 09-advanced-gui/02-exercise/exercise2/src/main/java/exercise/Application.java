
package exercise;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    System.out.println("Hello World!");

	Events events = new Events();
	events.setSize(250,400);
	events.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	events.setLocationRelativeTo(null);
	events.setVisible(true);
  }
}
