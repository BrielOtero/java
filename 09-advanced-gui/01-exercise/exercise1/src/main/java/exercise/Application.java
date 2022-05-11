
package exercise;

import javax.swing.JFrame;

/**
 * It creates a new instance of the Events class, sets it to visible, sets the default close operation
 * to do nothing, sets the size to 500x300, sets it to not be resizable, and sets the location to the
 * center of the screen
 */
public class Application {
	public static void main(String[] args) {
		Events events = new Events();
		events.setVisible(true);
		events.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		events.setSize(500, 300);
		events.setResizable(false);
		events.setLocationRelativeTo(null);
	}
}
