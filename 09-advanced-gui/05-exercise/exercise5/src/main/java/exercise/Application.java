
package exercise;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
	Events events = new Events();
	events.setSize(450, 550);
	//events.setLocationRelativeTo(null);
	events.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	events.setVisible(true);
}
}
