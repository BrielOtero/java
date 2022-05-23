package exercise;

import java.awt.FlowLayout;
import java.awt.geom.Arc2D.Float;
import java.io.File;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Third extends JDialog {
	JTextArea txaRecords;
	JScrollPane scbScroll;
	String txtValue;

	public Third(Events e) {

		setLayout(new FlowLayout());

		txaRecords = new JTextArea(5,20);
		scbScroll= new JScrollPane(txaRecords);
		add(scbScroll);

		//txaRecords.setEditable(false);


		try (Scanner s = new Scanner(new File(System.getProperty("user.home") + File.separator + ".records.txt"))) {
			while (s.hasNext()) {
				txtValue += s.nextLine()+"\n";
				System.err.println(txtValue);

			}

		} catch (Exception j) {
		}

		txaRecords.setText(txtValue);

	}
}
