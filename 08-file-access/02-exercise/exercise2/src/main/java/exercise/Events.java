package exercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Events extends JFrame implements ActionListener {
	JButton btnSelectFile;
	JButton btnCreateFile;
	JButton btnShowFile;
	JButton btnAddContent;
	JButton btnDeleteFile;
	JButton btnExit;

	boolean isFileRead = false;
	boolean isPathCreate = false;

	String showFileValue;
	String addFileValue;
	String showFileHistory = "";
	String newFileName = "";
	String pathFile = "";
	String pathFileHistory = "";
	String contentToAdd = "";
	String pathFileCreate = "";

	Path pathToolSelect;
	Path pathToolCreate;

	int confirmDelete;
	int overwriteCreationFile;
	int selectOptionFile;
	int optionsCreate;
	int changeFileDirectory;

	File fDelete = null;
	File f = null;
	File fCreate = null;

	PrintWriter pwr = null;
	PrintWriter p = null;

	public Events() {
		super("Exercise 2");

		setLayout(null);

		btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(this);
		btnSelectFile.setSize(250, 50);
		btnSelectFile.setLocation(50, 50);
		add(btnSelectFile);

		btnCreateFile = new JButton("Create File");
		btnCreateFile.addActionListener(this);
		btnCreateFile.setSize(250, 50);
		btnCreateFile.setLocation(50, 150);
		add(btnCreateFile);

		btnShowFile = new JButton("Show File");
		btnShowFile.addActionListener(this);
		btnShowFile.setSize(250, 50);
		btnShowFile.setLocation(50, 250);
		add(btnShowFile);

		btnAddContent = new JButton("Add Content");
		btnAddContent.addActionListener(this);
		btnAddContent.setSize(250, 50);
		btnAddContent.setLocation(50, 350);
		add(btnAddContent);

		btnDeleteFile = new JButton("Delete File");
		btnDeleteFile.addActionListener(this);
		btnDeleteFile.setSize(250, 50);
		btnDeleteFile.setLocation(50, 450);
		add(btnDeleteFile);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setSize(250, 50);
		btnExit.setLocation(50, 550);
		add(btnExit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// #region Menu Select File
		if (e.getSource() == btnSelectFile) {
			try {

				do {
					this.pathFile = JOptionPane.showInputDialog(null,
							"Please insert the path of the file.\n\nLike this c:\\users\\downloads\\hi.txt\n",
							"Select the file", JOptionPane.QUESTION_MESSAGE);

					if (this.pathFile == null) {

						throw new CloseException();
					}

					System.err.println(pathFile);

					if (this.pathFile != null) {

						this.f = new File(this.pathFile);

						if (!this.f.isFile() && !this.f.canRead()) {
							isFileRead = false;

						} else {
							isFileRead = true;
						}

					}

				} while (!this.isFileRead && this.pathFile != null);

				if (isFileRead) {
					this.pathToolSelect = Paths.get(pathFile);
					this.pathFileHistory = this.pathFile;
					this.pathFile = "";

				} else {
					this.pathFile = "";
				}

			} catch (CloseException a) {
				System.err.println("Close Exception");

			} catch (Exception o) {
				System.err.println("Close Exception int");
			}

		}

		// #endregion

		// #region Menu Create File
		if (e.getSource() == btnCreateFile) {
			try {

				if (this.pathFileHistory != "" && this.pathFileHistory != null) {

					optionsCreate = JOptionPane.showConfirmDialog(null,
							"Do you want use the path of the selected file?", "Path",
							JOptionPane.YES_NO_OPTION);

					System.err.println(optionsCreate);

				} else {
					optionsCreate = 1;
				}

				if (optionsCreate == 0) {
					pathFileCreate = pathToolSelect.getParent().toString();

				} else {

					do {
						this.pathFileCreate = JOptionPane.showInputDialog(null,
								"Please insert a path.\n\nLike this c:\\users\\YourUserName\\downloads\nor this c:\\users\\YourUserName\\downloads\\\n ",
								"Insert Path",
								JOptionPane.QUESTION_MESSAGE);

						if (this.pathFileCreate == null) {

							throw new CloseException();
						}

						System.err.println(pathFileCreate);

						if (String.valueOf(pathFileCreate.charAt(pathFileCreate.length() - 1)) == File.separator) {

							pathFileCreate = (String) pathFileCreate.subSequence(0, pathFileCreate.length() - 1);
						}

						fCreate = new File(this.pathFileCreate);

					} while (!fCreate.isDirectory());

				}

				newFileName = JOptionPane.showInputDialog(null,
						"Insert the name of the file with the extension.\n\nLike this hi.txt\n", "Create a file",
						JOptionPane.QUESTION_MESSAGE);

				if (this.newFileName == null) {

					throw new CloseException();
				}

				this.pathFileCreate = this.pathFileCreate + File.separator + newFileName;

				if ((this.pathFileCreate).equals(this.pathFileHistory)) {

					this.overwriteCreationFile = JOptionPane.showConfirmDialog(null,
							"The new file match with the select file. Do you want overwrite?", "Overwrite",
							JOptionPane.YES_NO_OPTION);

					if (this.overwriteCreationFile == 0) {

						try (PrintWriter pw = new PrintWriter(new FileWriter(this.pathFileCreate, true))) {

						} catch (IOException a) {
							System.err.println("Error writer on Create File 1");
						}

					}

				} else {

					System.err.println(this.pathFileCreate);

					try (PrintWriter pw = new PrintWriter(new FileWriter(this.pathFileCreate, true))) {

					} catch (IOException a) {
						System.err.println("Error writer on Create File 2");
					}
				}

				changeFileDirectory = JOptionPane.showConfirmDialog(null,
						"Do you want to change the selected file with the new file?", "Change",
						JOptionPane.YES_NO_OPTION);

				if (changeFileDirectory == 0) {
					pathFile = pathFileCreate;
					pathFileHistory = pathFileCreate;
					pathToolSelect = Paths.get(pathFileCreate);
					pathToolCreate = Paths.get(pathFileCreate);

				}

			} catch (CloseException a) {
				System.err.println("Close Exception");
			} catch (Exception o) {
				System.err.println("Close Exception int");
			}
		}
		// #endregion

		// #region Menu Show File
		if (e.getSource() == btnShowFile)

		{
			if (this.pathFileHistory != "" && this.pathFileHistory != null) {

				this.showFileValue = "";

				try (Scanner s = new Scanner(new File(this.pathFileHistory))) {

					while (s.hasNext()) {
						this.showFileValue += s.nextLine() + "\n";
					}

					JOptionPane.showMessageDialog(null, this.showFileValue, "The content of the file",
							JOptionPane.DEFAULT_OPTION);

					this.showFileHistory = this.showFileValue;

				} catch (IOException u) {
					System.err.println("Error scanner on ShowFile");

					JOptionPane.showMessageDialog(null,
							"Unable to display the file.\nThe program does not have the necessary permissions.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Please, before this select a file", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// #endregion

		// #region Menu Add Content

		if (e.getSource() == btnAddContent) {
			try {

				if (this.pathFileHistory != "" && this.pathFileHistory != null) {

					this.contentToAdd = JOptionPane.showInputDialog(null,
							"Insert the text to add", "Add content to file",
							JOptionPane.QUESTION_MESSAGE);

					if (this.contentToAdd == null) {

						throw new CloseException();
					}

					this.addFileValue = "";

					// Uso de append
					// ----------------------------------------------------------------------------
					try {

						pwr = new PrintWriter(
								new FileWriter(this.pathFileHistory, true));
						pwr.println(contentToAdd);

					} catch (Exception a) {
						System.err.println("Error writer on AddContent");

						JOptionPane.showMessageDialog(null,
								"Unable to add content\nThe program does not have the necessary permissions.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} finally {

						if (pwr != null) {

							try {
								pwr.close();
							} catch (Exception a2) {
								System.err.println("Error Close");
							}
						}
					}

					this.showFileHistory = this.addFileValue;
					// ----------------------------------------------------------------------------

				} else {
					JOptionPane.showMessageDialog(null, "Please, before this select a file", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (CloseException a) {
				System.err.println("Close Exception");
			} catch (Exception o) {
				System.err.println("Close Exception int");
			}

		}
		// #endregion

		// #region Menu Delete File

		if (e.getSource() == btnDeleteFile) {
			try {

				if (this.pathFileHistory != "" && this.pathFileHistory != null) {

					this.confirmDelete = JOptionPane.showConfirmDialog(null,
							"The file will be deleted. Are you sure?", "Delete",
							JOptionPane.YES_NO_OPTION);

					if (this.confirmDelete == 0) {

						try {
							fDelete = new File(pathFileHistory);
							fDelete.delete();
							pathFile = "";
							pathFileHistory = "";

						} catch (Exception d) {
							System.err.println("Error on delete");

							JOptionPane.showMessageDialog(null,
									"Unable to delete file\nThe program does not have the necessary permissions.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}

						if (!fDelete.exists()) {
							JOptionPane.showMessageDialog(null,
									"The file has been deleted successfully", "Erased successfully",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please, before this select a file", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (CloseException a) {
				System.err.println("Close Exception");
			} catch (Exception o) {
				System.err.println("Close Exception int");
			}

		}
		// #endregion

		// #region Menu Exit
		if (e.getSource() == btnExit) {
			this.dispose();
		}
		// #endregion
	}

}
