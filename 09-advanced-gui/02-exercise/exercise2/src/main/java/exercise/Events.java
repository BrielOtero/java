package exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

	ImgFormat imgFormat = new ImgFormat();
	ImageIcon[] icons;

	int selectedLabel = 999;

	int fcSelected;

	boolean isAnySet = false;
	boolean pauseAni = false;

	String nameToFile = "";

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

		MouseHandler handler = new MouseHandler();

		timeColor = new Timer(300, this);
		timeColor.start();

		phoneNumber = new JTextField("HI! ʘ‿ʘ");
		phoneNumber.setEditable(false);
		phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));
		phoneNumber.setSize(220, topLineSize);
		phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		phoneNumber.setLocation(25, 25);
		add(phoneNumber);
		

		

		trash = new JLabel(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
		trash.setLocation(phoneNumber.getWidth() + 30, 25);
		trash.setSize(topLineSize, topLineSize);
		trash.addMouseListener(handler);
		trash.addMouseMotionListener(handler);
		add(trash);

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

		addComponentListener(new ComponentAdapter() {

			public void componentResized(ComponentEvent e) {

				if (historyX == 0) {
					historyX = getContentPane().getWidth();
				}

				if (getContentPane().getWidth() != historyX) {

					size = (getContentPane().getWidth() - 75) / 3;
					sizeImg = ((getContentPane().getWidth() - 75) / 3) - 10;
					resizeIcons();
					resetPosition();

					phoneNumber.setSize(getWidth() - 120, topLineSize);

					trash.setLocation(phoneNumber.getWidth() + 30, 25);
					historyX = getContentPane().getWidth();
					setSize(new Dimension(getWidth(), label[11].getY() + size + 50));
					revalidate();
					repaint();
				}
			}
		});
		addKeyListener(this);
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
			System.err.println("as");

		
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			trashMP(e);
			numberMP(e);
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {

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

		colorAnimation(e);

		if (e.getSource() == mnuReadNum || e.getSource() == mnuSaveNum) {
			fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			mnuSaveAlgo(e);

			if (e.getSource() == mnuReadNum) {
				System.err.println("mnuRead");

			}

		}

		if (e.getSource() == mnuReset) {
			System.err.println("mnuReset");
		}

		if (e.getSource() == mnuSplit) {
			System.err.println("mnuSplit");
		}

		if (e.getSource() == mnuExit) {
			System.err.println("mnuExit");
		}

		if (e.getSource() == mnuAbout) {
			System.err.println("mnuAbout");
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

	private void resizeIcons() {
		try {
			icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, selectedLabel, Color.GREEN, icons);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

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

	private int converNumToIndex(int i) {
		int iReturn = 0;

		if (i >= 1 && i <= 9) {
			iReturn = i - 1;
		} else if (i == 0) {
			iReturn = 10;
		}

		return iReturn;
	}

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

	private void colorAnimation(ActionEvent e) {
		if (e.getSource() == timeColor && !isAnySet && !pauseAni) {
			contAnimation++;

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
					Thread.sleep(200);
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
	}

	private void mnuSaveAlgo(ActionEvent e) {
		if (e.getSource() == mnuSaveNum) {

			System.err.println("mnuSaveNum");
			boolean errorSave = false;

			fc.setDialogTitle("Select the directory to save file");
			fcSelected = fc.showOpenDialog(this);

			if (fcSelected == JFileChooser.APPROVE_OPTION) {

				if (fc.getSelectedFile().isDirectory()) {

					nameToFile = JOptionPane.showInputDialog(this, "Please insert the name of the file", "Pick a name",
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
				JOptionPane.showMessageDialog(this, "Could not create file", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "The file was created successfully", "Good news",
						JOptionPane.INFORMATION_MESSAGE);

			}

		}
	}

}
