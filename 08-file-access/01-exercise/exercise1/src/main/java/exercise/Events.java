package exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Events extends JFrame implements ActionListener {
	JButton selectPath;
	JButton information;
	JButton createPath;
	JButton exit;

	Path pathFileTool;

	int contFiles;

	String path = "";
	String createPathValue = "";

	File f = new File("");

	public Events() {
		super("Exercise 1");

		setLayout(null);

		selectPath = new JButton("Select file or directory");
		selectPath.addActionListener(this);
		selectPath.setSize(250, 50);
		selectPath.setLocation(50, 50);
		add(selectPath);

		information = new JButton("Information");
		information.addActionListener(this);
		information.setSize(250, 50);
		information.setLocation(50, 150);
		add(information);

		createPath = new JButton("Create Path");
		createPath.addActionListener(this);
		createPath.setSize(250, 50);
		createPath.setLocation(50, 250);
		add(createPath);

		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setSize(250, 50);
		exit.setLocation(50, 350);
		add(exit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameSizeList = "";

		// Select Path
		if (e.getSource() == selectPath) {

			do {

				this.path = JOptionPane.showInputDialog(null, "Insert a path");

				System.err.println(path);

				if (this.path != null) {
					this.f = new File(path);

				}

			} while (!f.isFile() && !f.isDirectory() && !f.canRead() && this.path != null);

			if (f.isFile()) {
				this.pathFileTool = Paths.get(path);
			}

		}

		// See information
		if (e.getSource() == information) {

			if (this.f.exists()) {
				contFiles = 1;

				try {

					if (this.f.isFile()) {
						JOptionPane.showMessageDialog(null,
								"Name: " + this.f.getName() + "\nPath: " + this.pathFileTool.getParent(),
								"Information", JOptionPane.INFORMATION_MESSAGE);

					} else {

						for (int i = 0; i < f.listFiles().length; i++) {

							if (((File) f.listFiles()[i]).isFile()) {

								nameSizeList += String.format("%03d  Name: %-100s\n         Size: %o\n\n", contFiles,
										((File) f.listFiles()[i]).getName(), ((File) f.listFiles()[i]).getTotalSpace());
								contFiles++;
							}
						}

						JOptionPane.showMessageDialog(null, nameSizeList,
								"Information", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception m) {

					JOptionPane.showMessageDialog(null,
							"Unable to display information.\nThe program does not have the necessary permissions.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Please before insert an file or directory", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// Create Path
		if (e.getSource() == createPath) {
			this.createPathValue = JOptionPane.showInputDialog(null, "Insert the name of the new directory");
			System.err.println(createPathValue);

			this.f = new File(this.path + "\\" + this.createPathValue);

			if (f.mkdir()) {
				JOptionPane.showMessageDialog(null,
						"The directory " + "\"" + this.createPathValue + "\"" + " has been created successfully",
						"Success", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						"The directory " + "\"" + this.createPathValue + "\"" + " was not created", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// Exit
		if (e.getSource() == exit) {
			this.dispose();
		}

	}

}
