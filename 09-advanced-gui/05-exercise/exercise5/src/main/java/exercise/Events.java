package exercise;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Events extends JFrame implements ActionListener {

	JCheckBox[] chbNumbers = new JCheckBox[49];
	JLabel lblInfo;
	JButton btPlay;
	JButton btReset;
	JMenuBar mnuMain;
	JMenu mnuGame;
	JMenuItem mnuSave;
	JMenuItem mnuRecords;
	Timer titleTimer;

	boolean played = false;

	int titleCont;
	int chbWidth = 40;
	int chbHeight = 40;

	int btPlayLocX = 100;
	int chbLocX = 10;
	int chbLocY = 70;

	int numberOfHits = 0;
	int contSetItems;
	int lastItem;

	int[] randomNum = new int[6];

	String[] titleLetters = { "A", "Í", "R", "E", "T", "O", "L", " ", " ", " " };
	String title = "";
	ArrayList<Integer> selectedNum = new ArrayList<Integer>(0);

	public Events() {

		setLayout(null);

		lblInfo = new JLabel("SELECT 6 NUMBERS");
		lblInfo.setSize(400, 50);
		lblInfo.setLocation(10, 10);
		lblInfo.setFont(new Font("TimesRoman", Font.BOLD, 30));
		add(lblInfo);

		titleTimer = new Timer(300, this);
		titleTimer.start();

		for (int i = 0; i < 49; i++) {
			chbNumbers[i] = new JCheckBox(String.format("%d", i));
			chbNumbers[i].setSize(chbWidth, chbHeight);
			chbNumbers[i].setLocation(chbLocX, chbLocY);
			chbNumbers[i].addActionListener(this);
			this.add(chbNumbers[i]);

			if ((i + 1) % 7 == 0) {
				chbLocX = 10;
				chbLocY += 40;
			} else {
				chbLocX += 60;
			}

		}

		btPlay = new JButton("Play");
		btPlay.setSize(200, 50);
		btPlay.setLocation(btPlayLocX, chbLocY + 20);
		btPlay.addActionListener(this);
		btPlay.setVisible(false);
		add(btPlay);

		btReset = new JButton("New Game");
		btReset.setSize(200, 50);
		btReset.setLocation(btPlayLocX, chbLocY + 20);
		btReset.addActionListener(this);
		btReset.setVisible(false);
		add(btReset);

		mnuSave = new JMenuItem("Save");
		mnuSave.setMnemonic('S');
		mnuSave.addActionListener(this);

		mnuRecords = new JMenuItem("See Records");
		mnuRecords.setMnemonic('R');
		mnuRecords.addActionListener(this);

		mnuGame = new JMenu("Game");
		mnuGame.setMnemonic('G');
		mnuGame.add(mnuSave);
		mnuGame.add(mnuRecords);

		mnuMain = new JMenuBar();
		mnuMain.add(mnuGame);
		this.setJMenuBar(mnuMain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		checkNumbers(e);

		play(e);

		resetBtn(e);

		saveBtn(e);

		recordsMnu(e);

		titleChange(e);

	}

	/**
	 * It checks if the user has selected more than 6 numbers and if so, it asks the user if he wants to
	 * reset the selection
	 * 
	 * @param e the event that was triggered
	 */
	private void checkNumbers(ActionEvent e) {

		if (e.getSource().getClass() == chbNumbers[1].getClass() && selectedNum.size() <= 7) {

			lastItem = Integer.parseInt(((AbstractButton) e.getSource()).getText());

			if (!((AbstractButton) e.getSource()).isSelected()) {

				selectedNum.remove(selectedNum.indexOf(lastItem));
				lblInfo.setText(String.format("SELECT %d NUMBERS",6- selectedNum.size()));
				btPlay.setVisible(false);
			

			} else {

				if (selectedNum.size() == 5) {
					btPlay.setVisible(true);
				}

				if (selectedNum.size() < 6) {
					if (!selectedNum.contains(lastItem)) {

						selectedNum.add(lastItem);

						contSetItems = selectedNum.lastIndexOf(lastItem) + 1;
						// System.err.println(selectedNum.lastIndexOf(lastItem));
						lblInfo.setText(String.format("SELECT %d NUMBERS", 6 - selectedNum.size()));
					}

				} else {

					((JCheckBox) e.getSource()).setSelected(false);

					int res = JOptionPane.showConfirmDialog(this,
							"You can't add more than 6 numbers\nDo you want reset the number selection", "Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

					if (res == JOptionPane.OK_OPTION) {
						selectedNum = new ArrayList<Integer>(6);
						btPlay.setVisible(false);
						for (int i = 0; i < chbNumbers.length; i++) {
							chbNumbers[i].setSelected(false);
						}
						resetDownBtn();
						lblInfo.setText("SELECT 6 NUMBERS");
						played = false;
					}

				}
			}

		}

	}

	/**
	 * It generates 6 random numbers, compares them to the selected numbers and changes the background
	 * color of the checkboxes accordingly
	 * 
	 * @param e ActionEvent
	 */
	private void play(ActionEvent e) {
		if (e.getSource() == btPlay) {

			for (int i = 0; i < 6; i++) {
				randomNum[i] = ((int) (Math.random() * 50));
				System.err.print(randomNum[i] + " ");
			}
			System.err.println();

			for (int i = 0; i < chbNumbers.length; i++) {

				for (int j = 0; j < randomNum.length; j++) {

					if (randomNum[j] == i) {

						if (selectedNum.contains(i)) {
							chbNumbers[i].setBackground(Color.GREEN);
							numberOfHits++;

						} else {
							chbNumbers[i].setBackground(Color.RED);

						}
						
					}
					chbNumbers[i].setEnabled(false);
				}

			}
			btReset.setVisible(true);
			btPlay.setVisible(false);
			played = true;
		}
	}

	/**
	 * It resets the background color of the checkboxes to null
	 */
	private void resetDownBtn() {
		for (int i = 0; i < 49; i++) {
			chbNumbers[i].setSelected(false);
			chbNumbers[i].setBackground(null);
		}
	}

	/**
	 * It resets the game
	 * 
	 * @param e ActionEvent
	 */
	private void resetBtn(ActionEvent e) {
		if (e.getSource() == btReset) {
			randomNum = new int[6];
			selectedNum = new ArrayList<Integer>(0);
			resetDownBtn();
			for (int i = 0; i < chbNumbers.length; i++) {
				chbNumbers[i].setEnabled(true);
			}
			lblInfo.setText("SELECT 6 NUMBERS");
			btReset.setVisible(false);
			btPlay.setVisible(false);
			played = false;
		}
	}

	/**
	 * If the user clicks on the save button, the program will check if the user has selected 6 numbers
	 * and played the game. If the user has selected 6 numbers and played the game, the program will open
	 * a new window
	 * 
	 * @param e the event that triggered the method
	 */
	private void saveBtn(ActionEvent e) {
		if (e.getSource() == mnuSave) {
			System.err.println(contSetItems);

			if (contSetItems == 6 && played) {

				Second second = new Second(this);
				second.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				second.setSize(430, 80);
				second.setLocationRelativeTo(this);
				second.setResizable(false);
				second.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Please select 6 numbers BEFORE and PLAY!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * It creates a new JFrame object and sets its properties
	 * 
	 * @param e the event that triggered the action
	 */
	private void recordsMnu(ActionEvent e) {
		if (e.getSource() == mnuRecords) {

			Third third = new Third(this);
			third.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			third.setSize(430, 300);
			third.setLocationRelativeTo(this);
			third.setResizable(false);
			third.setVisible(true);

		}
	}

	/**
	 * It takes the first letter of the titleLetters array and adds it to the title string
	 * 
	 * @param e The event that triggered the method.
	 */
	private void titleChange(ActionEvent e) {
		if (e.getSource() == titleTimer) {

			title = titleLetters[titleCont] + title;

			if (title.length() > 10) {
				title = title.substring(0, 10);
			}

			this.setTitle(title);

			titleCont++;
			if (titleCont > 9) {
				titleCont = 0;
			}
		}
	}

}
