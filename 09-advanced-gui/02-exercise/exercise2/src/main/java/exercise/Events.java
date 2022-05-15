package exercise;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Events extends JDialog implements ActionListener, KeyListener {
	JTextField phoneNumber;

	// Format
	int size = 80;
	int sizeImg = 70;
	int separation = 15;
	int topLineSize = 50;
	int topLineImgSize = 45;
	int fontSize = 28;

	// Values
	int historyX = 0;
	Color[] colors = { Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.CYAN,
			Color.PINK };

	int contAnimation = 0;

	
	int selectedLabel = 999;
	
	int fcSelected;
	Point coordWindow = new Point(0, 0);
	
	boolean isAnySet = false;
	boolean pauseAni = false;
	
	String nameToFile = "";
	
	// Creating an array of ImageIcon objects.
	ImgFormat imgFormat = new ImgFormat();
	ImageIcon[] icons;

	// Components
	JLabel[] label;
	JLabel trash;
	Timer timeColor;
	Timer timeTrash;
	JFileChooser fc;

	// Creating a menu bar, a menu, and menu items.
	JMenuBar mnuMain;
	JMenu mnuFile;
	JMenuItem mnuSaveNum, mnuReadNum, mnuReset, mnuSplit, mnuExit, mnuAbout;
	JMenu mnuMobile;
	JMenu mnuOthers;

	public Events() throws IOException {

		setTitle("Phone");
		setLayout(null);
		setFocusable(true);
		setMinimumSize(new Dimension(330, 530));

		// Calling the function creatingMenu()
		creatingMenu();

		// Creating a new MouseHandler object.
		MouseHandler handler = new MouseHandler();

		// Creating a new timer object called timeColor. The timer is set to 300
		// milliseconds and the action
		// listener is set to the class that contains the code.
		timeColor = new Timer(300, this);
		timeColor.start();

		// Creating a text field that is not editable.
		phoneNumber = new JTextField("HI! ʘ‿ʘ");
		phoneNumber.setEditable(false);
		phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));
		phoneNumber.setSize(220, topLineSize);
		phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		phoneNumber.addMouseListener(handler);
		phoneNumber.addMouseMotionListener(handler);
		phoneNumber.setLocation(25, 25);
		add(phoneNumber);

		// Creating a new JLabel with the image of a trash can.
		trash = new JLabel(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
		trash.setLocation(phoneNumber.getWidth() + 30, 25);
		trash.setSize(topLineSize, topLineSize);
		trash.addMouseListener(handler);
		trash.addMouseMotionListener(handler);
		add(trash);

		// Creating a label that will display the number of the question.
		creatingNumberLabel(handler);

		// Setting the size of the frame to the size of the label plus 100.
		setSize(new Dimension(getWidth(), label[11].getY() + size + 100));

		// Adding a key listener and a mouse listener to the JFrame.
		addKeyListener(this);
		addMouseListener(handler);
		addMouseMotionListener(handler);

		// A listener that is listening for a change in the size of the window.
		addComponentListener(new ComponentAdapter() {

			public void componentResized(ComponentEvent e) {

				// Checking if the historyX is 0, if it is, it sets the historyX to the width of the content pane.
				if (historyX == 0) {
					historyX = getContentPane().getWidth();
				}

				// Resizing the buttons and labels.
				if (getContentPane().getWidth() != historyX) {

					size = (getContentPane().getWidth() - 75) / 3;
					sizeImg = ((getContentPane().getWidth() - 75) / 3) - 10;
					resizeIcons();
					resetPosition();

					phoneNumber.setSize(getWidth() - 120, topLineSize);

					trash.setLocation(phoneNumber.getWidth() + 30, 25);
					historyX = getContentPane().getWidth();
					revalidate();
					setSize(new Dimension(getWidth(), label[11].getY() + size + 100));
					// repaint();
				}
			}
		});
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
			// Getting the coordinates of the mouse pointer.
			coordWindow = new Point(e.getXOnScreen(), e.getYOnScreen());
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			
			// Calling the trashMP method and passing the value of e to it.
			trashMP(e);

			// Calling the method numberMP with the parameter e.
			numberMP(e);
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {

			// Looping through the array of JLabels and setting the icon to the colorized version of the image.
			for (int i = 0; i < label.length; i++) {
				if (i != selectedLabel) {
					if (e.getSource().equals(label[i])) {

						try {
							label[i].setIcon(imgFormat.colorizeIcon(sizeImg, i, Color.BLACK));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {

			// Looping through the array of labels and setting the icon to a grayed out version of the icon.
			for (int i = 0; i < label.length; i++) {
				if (i != selectedLabel) {
					try {
						label[i].setIcon(imgFormat.colorizeIcon(sizeImg, i, Color.LIGHT_GRAY));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Calling the colorAnimation function and passing the event object as a parameter.
		colorAnimation(e);

		//Menu Read and Save
		if (e.getSource() == mnuReadNum || e.getSource() == mnuSaveNum) {
			fc = new JFileChooser();

			// Menu Save. Calling the mnuSaveAlgo method.
			mnuSaveAlgo(e);

			// Menu Read. Calling the mnuReadAlgo() method.
			mnuReadAlgo(e);
		}

		// Menu Reset. Calling the mnuResetAlgo() method.
		mnuResetAlgo(e);

		// Menu Split. Calling the mnuSplitAlgo() method.
		mnuSplitAlgo(e);

		// Menu Exit
		if (e.getSource() == mnuExit) {
			System.err.println("mnuExit");
			dispose();
		}

		// Menu About. Creating a pop up window that says "App created by Gabriel ❤"
		if (e.getSource() == mnuAbout) {
			System.err.println("mnuAbout");
			JOptionPane.showMessageDialog(this, "App created by Gabriel ❤", "About", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		char keyValue = e.getKeyChar();
		int keyIndex;
		boolean validKey = false;

		if (keyValue >= '0' && keyValue <= '9') {
			validKey = true;
		} else if (keyValue == '*') {
			validKey = true;
		} else if (keyValue == '#') {
			validKey = true;
		}

		// A code snippet from a Java program that is used to create a phone number pad.
		if (validKey) {
			phoneNumber.setForeground(Color.BLACK);
			if (phoneNumber.getText().equals("CLEAN! ♥‿♥") || phoneNumber.getText().equals("HI! ʘ‿ʘ")) {
				phoneNumber.setText("");
			}

			if (keyValue == '*') {
				keyIndex = 9;
			} else if (keyValue == '#') {
				keyIndex = 11;
			} else {
				keyIndex = Character.getNumericValue(keyValue);
				keyIndex = converNumToIndex(keyIndex);
			}

			try {
				selectedLabel = 999;
				resizeIcons();
				resetPosition();
				label[keyIndex].setIcon(imgFormat.colorizeIcon(sizeImg + 10, keyIndex, Color.green));
				selectedLabel = keyIndex;
				phoneNumber.setText(phoneNumber.getText() + getIcoName(keyIndex));
				isAnySet = true;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			validKey = false;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * It takes the icons, colorizes them, and then sets them to the icons variable
	 */
	private void resizeIcons() {
		try {
			icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, selectedLabel, Color.GREEN, icons);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * It creates a menu bar with three menus: File, Mobile, and Others. The File
	 * menu has two menu items:
	 * Save and Read. The Mobile menu has three menu items: Reset, Split, and Exit.
	 * The Others menu has
	 * one menu item: About
	 */
	private void creatingMenu() {
		// Creating a menu item and adding it to the menu.
		mnuSaveNum = new JMenuItem("Save");
		mnuSaveNum.setMnemonic('S');
		mnuSaveNum.addActionListener(this);

		mnuReadNum = new JMenuItem("Read");
		mnuReadNum.setMnemonic('R');
		mnuReadNum.addActionListener(this);

		mnuFile = new JMenu("File");
		mnuFile.setMnemonic('F');
		mnuFile.add(mnuSaveNum);
		mnuFile.add(mnuReadNum);

		// Creating a menu item called "Mobile" and adding the menu items "Reset",
		// "Split", and "Exit" to it.
		mnuReset = new JMenuItem("Reset");
		mnuReset.setMnemonic('R');
		mnuReset.addActionListener(this);

		mnuSplit = new JMenuItem("Split");
		mnuSplit.setMnemonic('S');
		mnuSplit.addActionListener(this);

		mnuExit = new JMenuItem("Exit");
		mnuExit.setMnemonic('E');
		mnuExit.addActionListener(this);

		mnuMobile = new JMenu("Mobile");
		mnuMobile.setMnemonic('M');
		mnuMobile.add(mnuReset);
		mnuMobile.add(mnuSplit);
		mnuMobile.add(mnuExit);

		// Creating a menu item called "About" and adding it to the "Others" menu.
		mnuAbout = new JMenuItem("About");
		mnuAbout.setMnemonic('A');
		mnuAbout.addActionListener(this);

		mnuOthers = new JMenu("Others");
		mnuOthers.setMnemonic('O');
		mnuOthers.add(mnuAbout);

		// Adding the menu items to the menu bar.
		mnuMain = new JMenuBar();
		mnuMain.add(mnuFile);
		mnuMain.add(mnuMobile);
		mnuMain.add(mnuOthers);

		this.setJMenuBar(mnuMain);
	}

	/**
	 * It creates a JLabel array of 12 elements, then it sets the size and location
	 * of each element, and
	 * finally it adds a MouseListener and MouseMotionListener to each element
	 * 
	 * @param handler MouseHandler
	 */
	private void creatingNumberLabel(MouseHandler handler) throws IOException {

		label = new JLabel[12];
		icons = imgFormat.generateIcons(sizeImg);

		for (int i = 0; i < label.length; i++) {

			JLabel l = new JLabel(icons[i]);
			l.setSize(size, size);

			if (i == 0) {
				// 1
				l.setLocation(25, phoneNumber.getY() + phoneNumber.getHeight() + separation);
			} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
				// 2 3 5 6 8 9 Zero Pad
				l.setLocation(label[i - 1].getX() + size + separation, label[i - 1].getY());
			} else {
				// 4 7 Asterisk
				l.setLocation(25, label[i - 3].getY() + size + separation);
			}

			l.addMouseListener(handler);
			l.addMouseMotionListener(handler);
			label[i] = l;
		}

		for (int i = 0; i < label.length; i++) {
			this.add(label[i]);
		}
	}

	/**
	 * It sets the location of each label to the location of the previous label plus
	 * the size of the label
	 * plus the separation
	 */
	private void resetPosition() {
		for (int i = 0; i < label.length; i++) {
			label[i].setIcon(icons[i]);
			label[i].setSize(size, size);
			if (i == 0) {
				// 1
				label[i].setLocation(25, phoneNumber.getY() + phoneNumber.getHeight() + separation);
			} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
				// 2 3 5 6 8 9 Zero Pad
				label[i].setLocation(label[i - 1].getX() + size + separation, label[i - 1].getY());
			} else {
				// 4 7 Asterisk
				label[i].setLocation(25, label[i - 3].getY() + size + separation);
			}
		}
	}

	/**
	 * It returns a string representation of the number passed to it
	 * 
	 * @param i the index of the button
	 * @return The name of the icon.
	 */
	private String getIcoName(int i) {
		String iReturn = "";

		if (i >= 0 && i < 9) {
			iReturn = String.format("%d", i + 1);
		} else {
			switch (i) {
				case 9:
					iReturn = "*";
					break;
				case 10:
					iReturn = String.format("%d", 0);
					break;
				case 11:
					iReturn = "#";
					break;
			}
		}
		return iReturn;
	}

	/**
	 * It takes a number from 0 to 9 and returns the index of the corresponding
	 * image in the array
	 * 
	 * @param i The number to be converted to an index.
	 * @return The index of the array.
	 */
	private int converNumToIndex(int i) {
		int iReturn = 0;

		if (i >= 1 && i <= 9) {
			iReturn = i - 1;
		} else if (i == 0) {
			iReturn = 10;
		}

		return iReturn;
	}

	/**
	 * It takes the mouse event, checks if the source of the event is one of the
	 * labels, if it is, it sets
	 * the label's icon to a green version of the icon, and adds the icon's name to
	 * the phone number text
	 * field
	 * 
	 * @param e the mouse event
	 */
	private void numberMP(java.awt.event.MouseEvent e) {
		for (int i = 0; i < label.length; i++) {
			if (e.getSource().equals(label[i])) {
				try {
					phoneNumber.setForeground(Color.BLACK);
					if (phoneNumber.getText().equals("CLEAN! ♥‿♥") || phoneNumber.getText().equals("HI! ʘ‿ʘ")) {
						phoneNumber.setText("");
					}
					selectedLabel = 999;
					resizeIcons();
					resetPosition();
					label[i].setIcon(imgFormat.colorizeIcon(sizeImg + 10, i, Color.green));
					selectedLabel = i;
					phoneNumber.setText(phoneNumber.getText() + getIcoName(i));
					isAnySet = true;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * It resets the phone number to "CLEAN! ♥‿♥" and changes the color of the icons
	 * to light gray
	 * 
	 * @param e the mouse event
	 */
	private void trashMP(java.awt.event.MouseEvent e) {
		if (e.getSource() == trash) {
			phoneNumber.setForeground(Color.BLACK);
			phoneNumber.setText("CLEAN! ♥‿♥");
			try {
				icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, 13, Color.GREEN, icons);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			contAnimation = 0;
			selectedLabel = 999;
			resizeIcons();
			resetPosition();
			isAnySet = false;
		}
	}

	/**
	 * It's a function that changes the color of the buttons and the text of the
	 * phone number
	 * 
	 * @param e ActionEvent
	 */
	private void colorAnimation(ActionEvent e) {
		if (MouseInfo.getPointerInfo().getLocation().getY() == coordWindow.getY()
				&& MouseInfo.getPointerInfo().getLocation().getX() == coordWindow.getX()) {
			pauseAni = true;
		} else {
			pauseAni = false;
		}

		if (e.getSource() == timeColor && !isAnySet && !pauseAni) {
			contAnimation++;

			// Changing the color of the text and the icons.
			if (contAnimation > 20 && contAnimation <= 33) {
				int j = (int) (Math.random() * 7);

				if (contAnimation != 33) {

					try {
						phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize + 10));
						phoneNumber.setForeground(colors[j]);

						label[contAnimation - 21]
								.setIcon(imgFormat.colorizeIcon(sizeImg + 10, contAnimation - 21, colors[j]));

						trash.setIcon(imgFormat.colorizeIcon(topLineSize, 12, colors[j]));

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					System.err.println("Sleep Error");
					e2.printStackTrace();
				}

				try {
					if (contAnimation > 21) {

						label[contAnimation - 22]
								.setIcon(imgFormat.colorizeIcon(sizeImg, contAnimation - 22, Color.LIGHT_GRAY));
					}

					phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else if (contAnimation > 32) {
				phoneNumber.setForeground(Color.BLACK);
				phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));
				contAnimation = 0;
				try {
					trash.setIcon(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

		// Setting the color of the phone number to black and setting the font to JeBrains Mono.
		if (pauseAni) {
			phoneNumber.setForeground(Color.BLACK);
			phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));

			try {
				trash.setIcon(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
				if (contAnimation > 20 && contAnimation < 33) {
					label[contAnimation - 21]
							.setIcon(imgFormat.colorizeIcon(sizeImg, contAnimation - 21, Color.LIGHT_GRAY));
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			contAnimation = 0;

		}
	}

	/**
	 * It saves the text in the text field to a file
	 * 
	 * @param e ActionEvent
	 */
	private void mnuSaveAlgo(ActionEvent e) {
		if (e.getSource() == mnuSaveNum) {

			System.err.println("mnuSaveNum");
			boolean errorSave = false;
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			fc.setDialogTitle("Select the directory to save file");
			fcSelected = fc.showOpenDialog(this);

			if (fcSelected == JFileChooser.APPROVE_OPTION) {

				if (fc.getSelectedFile().isDirectory()) {

					nameToFile = JOptionPane.showInputDialog(this, "Please insert the n"
							+ "ame of the file", "Pick a name",
							JOptionPane.QUESTION_MESSAGE);

					try (PrintWriter pw = new PrintWriter(fc.getSelectedFile().getPath() + File.separator
							+ nameToFile + ".txt")) {

						if (!phoneNumber.getText().contains("!")) {
							pw.println(phoneNumber.getText());
						} else {
							pw.println("");
						}

					} catch (IOException j) {
						errorSave = true;
					}
					System.err.println("Exit");
				} else {
					errorSave = true;
				}

			} else {
				errorSave = true;
			}

			if (errorSave) {
				JOptionPane.showMessageDialog(this, "Could not create f"
						+ "ile", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "The file was creat"
						+ "ed successfully", "Good news",
						JOptionPane.INFORMATION_MESSAGE);

			}

		}
	}

	/**
	 * It reads a file and displays the content in a text area
	 * 
	 * @param e ActionEvent
	 */
	private void mnuReadAlgo(ActionEvent e) {
		if (e.getSource() == mnuReadNum) {
			System.err.println("mnuRead");
			boolean errorRead = false;
			String fileContent = "";

			FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Te"
					+ "xt", "txt");
			fc.addChoosableFileFilter(filterTxt);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			fc.setDialogTitle("Select the directory to save file");
			fcSelected = fc.showOpenDialog(this);

			if (fcSelected == JFileChooser.APPROVE_OPTION) {

				if (fc.getSelectedFile().isFile()) {

					try (Scanner s = new Scanner(fc.getSelectedFile())) {
						while (s.hasNext()) {
							fileContent += s.nextLine() + "\n";
						}

					} catch (IOException s) {
						System.err.println("Exit");
					}

				} else {
					errorRead = true;
				}

			} else {
				errorRead = true;
			}

			if (errorRead) {
				JOptionPane.showMessageDialog(this, "Could not read file", "Err"
						+ "or", JOptionPane.ERROR_MESSAGE);
			} else {
				phoneNumber.setText(fileContent);

			}

		}

	}

	/**
	 * It resets the algorithm
	 * 
	 * @param e ActionEvent
	 */
	private void mnuResetAlgo(ActionEvent e) {
		if (e.getSource() == mnuReset) {
			System.err.println("mnuReset");

			phoneNumber.setForeground(Color.BLACK);
			phoneNumber.setText("CLEAN! ♥‿♥");

			try {
				icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, 13, Color.GREEN, icons);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			contAnimation = 0;
			selectedLabel = 999;
			resizeIcons();
			resetPosition();
			isAnySet = false;

		}
	}

	/**
	 * It splits the phone number into an array of strings, then it adds a dash every 3 characters
	 * 
	 * @param e The event that triggered the action.
	 */
	private void mnuSplitAlgo(ActionEvent e) {
		if (e.getSource() == mnuSplit) {
			System.err.println("mnuSplit");
			String[] phoneNumberValue = phoneNumber.getText().split("");
			String phoneNumberSplit = "";
			if (!phoneNumber.getText().equals("CLEAN! ♥‿♥") && !phoneNumber.getText().equals("HI! ʘ‿ʘ")) {

				for (int i = 0; i < phoneNumberValue.length; i++) {
					if (i % 3 == 0 && i != 0) {
						phoneNumberSplit += "-" + phoneNumberValue[i];
					} else {
						phoneNumberSplit += phoneNumberValue[i];
					}
				}

				phoneNumber.setText(phoneNumberSplit);
			}

		}
	}

	/**
	 * It moves the mouse to the top left corner of the screen, clicks, and then releases the click
	 * @deprecated don't use. Only for save.
	 */
	private void robot() {
		Robot bot = null;

		try {
			bot = new Robot();
		} catch (Exception failed) {
			System.err.println("Failed instantiating Robot: " + failed);
		}
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		bot.mouseMove(1, 1);
		bot.mousePress(mask);
		bot.mouseRelease(mask);
	}
}
