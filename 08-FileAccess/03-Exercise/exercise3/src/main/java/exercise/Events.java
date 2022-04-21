package exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Events extends JFrame implements ActionListener {
	JButton btnSelectFilOrDir;

	JTextArea txaShowContent;

	JLabel lblShowImage;
	JLabel lblShowOther;

	JFileChooser fc;

	JScrollPane scroll;

	int selected;

	String fileContent;
	String anotherContent;
	String dirContent;

	public Events() {
		super("Exercise 3");
		setLayout(null);

		btnSelectFilOrDir = new JButton("Select file");
		btnSelectFilOrDir.addActionListener(this);
		btnSelectFilOrDir.setSize(380, 50);
		btnSelectFilOrDir.setLocation(50, 50);
		add(btnSelectFilOrDir);

		txaShowContent = new JTextArea(5, 20);
		scroll = new JScrollPane(txaShowContent);
		scroll.setLocation(50, btnSelectFilOrDir.getHeight() + 50);
		scroll.setSize(btnSelectFilOrDir.getWidth(), 150);
		scroll.setVisible(false);
		add(scroll);

		lblShowImage = new JLabel();
		lblShowImage.setSize(btnSelectFilOrDir.getWidth(), 250);
		lblShowImage.setLocation(50, btnSelectFilOrDir.getHeight() + 50);
		lblShowImage.setVisible(false);

		add(lblShowImage);

		lblShowOther = new JLabel();
		lblShowOther.setSize(btnSelectFilOrDir.getWidth(), 250);
		lblShowOther.setLocation(50, btnSelectFilOrDir.getHeight() + 50);
		lblShowOther.setVisible(false);
		add(lblShowOther);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		scroll.setVisible(false);
		lblShowImage.setVisible(false);
		lblShowOther.setVisible(false);

		if (e.getSource() == btnSelectFilOrDir) {

			FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text", "txt");
			FileNameExtensionFilter filterImage = new FileNameExtensionFilter("Image", "jpg", "jpeg", "gif", "png");
			fc = new JFileChooser();

			fc.addChoosableFileFilter(filterTxt);
			fc.addChoosableFileFilter(filterImage);
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			selected = fc.showOpenDialog(this);

			if (selected == JFileChooser.APPROVE_OPTION) {

				if (fc.getSelectedFile().isFile()) {
					System.err.println("Is File");

					if (filterTxt.accept(fc.getSelectedFile())) {

						System.err.println("Is Txt");

						try (Scanner s = new Scanner(fc.getSelectedFile())) {
							while (s.hasNext()) {
								this.fileContent += s.nextLine() + "\n";
							}
							txaShowContent.setText(fileContent);
						} catch (IOException o) {
							System.err.println();
						}

						scroll.setVisible(true);

					} else if (filterImage.accept(fc.getSelectedFile())) {

						System.err.println("Is Image");

						ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getPath());
						lblShowImage.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
						lblShowImage.setIcon(imageIcon);
						lblShowImage.setVisible(true);
					} else {
						System.err.println("Is Another");
						anotherContent = String.format(
								"<html>Name: %s<br>Path: %s<br>Size: %.0f KB<br>Permissions:<br> - Read:%b<br> - Write:%b<br> - Execute:%b</html>",
								fc.getSelectedFile().getName(), fc.getSelectedFile().toPath().toString(),
								fc.getSelectedFile().getTotalSpace() * 0.000977, fc.getSelectedFile().canRead(),
								fc.getSelectedFile().canWrite(), fc.getSelectedFile().canExecute());
						lblShowOther.setText(anotherContent);
						lblShowOther.setVisible(true);

					}

				} else {
					System.err.println("Is Directory");

					for (int i = 0; i < fc.getSelectedFile().listFiles().length; i++) {
						if (fc.getSelectedFile().listFiles()[i].isDirectory()) {
							dirContent += String.format("D %-100s\n", fc.getSelectedFile().listFiles()[i].getName());

						} else {
							dirContent += String.format("%-100s\n", fc.getSelectedFile().listFiles()[i].getName());
						}
					}

					txaShowContent.setText(dirContent);
					scroll.setVisible(true);
				}
			}

		}
	}

}
