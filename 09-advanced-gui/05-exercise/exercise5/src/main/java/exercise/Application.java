
package exercise;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
	Events events = new Events();
	events.setSize(440, 500);
	events.setLocationRelativeTo(null);
	events.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	events.setResizable(false);
	events.setVisible(true);
}
}
