
package exercise;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) throws IOException {
    System.out.println("Hello World!");

	Events events = new Events();
	events.setSize(330,530);
	events.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	events.setLocationRelativeTo(null);
	events.setVisible(true);
	
  }
}
