
package exercise;

import javax.swing.JFrame;

public class Application {
	public static void main(String[] args) {
		Events events = new Events();
		events.setVisible(true);
		events.setLocationRelativeTo(null);
		events.setSize(350, 400);
		events.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
