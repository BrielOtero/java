package exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Events extends JFrame implements ActionListener {

	JFileChooser fcSelect;
	JFileChooser fcCreate;

	JLabel lblColumn1;
	JLabel lblColumn2;
	JLabel lblColumn3;

	String save = "";
	String[] splitSave;

	String textToPrint1 = "";
	String textToPrint2 = "";
	String textToPrint3 = "";
	int column1 = 0;
	double column2 = 0;
	double column3 = 0;

	int cont = 0;

	int selected;
	int rows;

	JButton btnSelect;
	JButton btnCreate;
	JLabel lblInfoRows;
	JTextField txfRows;

	boolean errValues = false;
	boolean err = false;

	public Events() {
		super("Exercise 5");
		setLayout(null);

		btnSelect = new JButton("Select File");
		btnSelect.setLocation(50, 50);
		btnSelect.setSize(250, 50);
		btnSelect.addActionListener(this);
		add(btnSelect);

		lblColumn1 = new JLabel();
		lblColumn1.setLocation(50, btnSelect.getY() + 70);
		lblColumn1.setSize(250, 25);
		lblColumn1.setVisible(false);
		add(lblColumn1);

		lblColumn2 = new JLabel();
		lblColumn2.setLocation(50, lblColumn1.getY() + 50);
		lblColumn2.setSize(250, 25);
		lblColumn2.setVisible(false);
		add(lblColumn2);

		lblColumn3 = new JLabel();
		lblColumn3.setLocation(50, lblColumn2.getY() + 50);
		lblColumn3.setSize(250, 25);
		lblColumn3.setVisible(false);
		add(lblColumn3);

		btnCreate = new JButton("Create file automatically");
		btnCreate.setLocation(50, btnSelect.getY() + 70);
		btnCreate.setSize(250, 50);
		btnCreate.addActionListener(this);
		add(btnCreate);

		lblInfoRows = new JLabel("Insert the number of rows");
		lblInfoRows.setLocation(50, btnCreate.getY() + 50);
		lblInfoRows.setSize(150, 25);
		add(lblInfoRows);

		txfRows = new JTextField(5);
		txfRows.setLocation(250, btnCreate.getY() + 50);
		txfRows.setSize(50, 25);
		add(txfRows);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		errValues = false;
		err = false;

		if (e.getSource() == btnSelect) {

			fcSelect = new JFileChooser();
			selected = fcSelect.showOpenDialog(this);

			if (selected == JFileChooser.APPROVE_OPTION) {

				try (Scanner s = new Scanner(fcSelect.getSelectedFile())) {
					while (s.hasNext()) {
						save += s.nextLine() + ",";
					}
				} catch (IOException o) {
					// TODO: handle exception
				}
				System.err.println(save);

				splitSave = save.split(",");
				try {

					for (int i = 0; i < splitSave.length; i += 3) {
						column1 += Integer.parseInt(splitSave[i]);
						column2 += Double.parseDouble(splitSave[i + 1]);
						column3 += Double.parseDouble(splitSave[i + 2]);
						cont++;
					}
				} catch (Exception o) {
					JOptionPane.showMessageDialog(null, "The values in the file are not valid", "Error",
							JOptionPane.ERROR_MESSAGE);
					errValues = true;
				}
				if (!errValues) {

					textToPrint1 = String.format("%d", column1 / cont);
					textToPrint2 = String.format("%.2f", column2 / cont);
					textToPrint3 = String.format("%.2f", column3 / cont);

					lblColumn1.setText("Average Column 1: " + textToPrint1);
					lblColumn2.setText("Average Column 2: " + textToPrint2);
					lblColumn3.setText("Average Column 3: " + textToPrint3);

					btnCreate.setLocation(btnCreate.getX(), lblColumn3.getY() + 50);
					lblInfoRows.setLocation(50, btnCreate.getY() + 50);
					txfRows.setLocation(250, btnCreate.getY() + 50);

					lblColumn1.setVisible(true);
					lblColumn2.setVisible(true);
					lblColumn3.setVisible(true);
				}
			}

		}

		if (e.getSource() == btnCreate) {
			
			if(txfRows.getText().length()>10){
				err=true;
			} else{	
				try {
					
					rows = Integer.parseInt(txfRows.getText());
				} catch (Exception o) {
					err = true;
				}
			}

			if (rows <= 0 || err) {

				JOptionPane.showMessageDialog(null, "Please insert a correct number for rows", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {

				try {
					fcCreate = new JFileChooser();
					fcCreate.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fcCreate.setDialogTitle("Select the directory to export the file");

					selected = fcCreate.showOpenDialog(this);

					if (fcCreate.getSelectedFile().isDirectory()) {

						System.err.println(fcCreate.getSelectedFile().getPath() + File.separator + "file.txt");

						try (PrintWriter p = new PrintWriter(
								fcCreate.getSelectedFile().getPath() + File.separator + "file.txt")) {

							for (int i = 0; i < rows; i++) {
								int rndColumn1 = (int) (Math.random() * 91 + 10);
								double rndColumn2 = (Double) (Math.random() * 1001);
								double rndColumn3 = (Double) (Math.random() * 9901 + 100);
								p.println(String.format("%d,%.3f,%.3f", rndColumn1, rndColumn2, rndColumn3));

							}
							p.close();

							JOptionPane.showMessageDialog(null, "The file was created successfully", "Created",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException a) {
							System.err.println("Err Writing File");

							JOptionPane.showMessageDialog(null, "The file was not created", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}

				} catch (Exception u) {
					System.err.println("Close");
				}

			}
		}
	}

}
