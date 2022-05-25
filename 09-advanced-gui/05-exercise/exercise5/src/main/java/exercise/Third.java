package exercise;

import java.awt.FlowLayout;
import java.io.File;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Third extends JDialog {
	JTextArea txaRecords;
	JScrollPane scbScroll;
	String txtValue="";

	public Third(Events e) {
		super();

		setLayout(new FlowLayout());
		setTitle("RECORDS");

		txaRecords = new JTextArea(5,20);
		txaRecords.setEditable(false);
		scbScroll= new JScrollPane(txaRecords);
		add(scbScroll);

		
		try (Scanner s = new Scanner(new File(System.getProperty("user.home") + File.separator + ".records.txt"))) {
			while (s.hasNext()) {
				txtValue += s.nextLine()+"\n";
				System.err.println(txtValue);
				
			}
			
		} catch (Exception j) {
		}
		if(txtValue.trim().equals("")){
			txaRecords.setText("There aren't any game saved");

		}else{
			txaRecords.setText(txtValue);
		}
		
	}
}
