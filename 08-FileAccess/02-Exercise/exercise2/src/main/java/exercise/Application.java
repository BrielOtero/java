
package exercise;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
	Events events = new Events();
	events.setSize(370, 700);
	events.setVisible(true);
	events.setResizable(false);
	events.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	events.setLocationRelativeTo(null);
	
  }
}
