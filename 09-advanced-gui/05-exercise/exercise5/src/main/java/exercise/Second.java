package exercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Second extends JDialog implements ActionListener {
	JLabel lblInfoName;
	JTextField txfName;
	String name;
	JButton btSave;
	int correctNumbers;

	public Second(Events e) {
		super();

		setLayout(new FlowLayout());

		lblInfoName = new JLabel("Insert your name");
		add(lblInfoName);

		txfName = new JTextField("", 20);
		txfName.addActionListener(this);
		add(txfName);

		btSave = new JButton("Save");
		btSave.addActionListener(this);
		add(btSave);
		correctNumbers = e.numberOfHits;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == txfName || e.getSource() == btSave) {
			
			if(name==null){
				
				name = txfName.getText();
				
				try (PrintWriter pw = new PrintWriter(
					new FileWriter(System.getProperty("user.home") + File.separator + ".records.txt", true))) {
						pw.println(String.format("%s %d", name, correctNumbers));
					} catch (IOException f) {
						System.err.println("Can't save");
					}
					
					dispose();
				
			}
		}

	}
}
