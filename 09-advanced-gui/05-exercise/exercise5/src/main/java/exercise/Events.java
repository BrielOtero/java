package exercise;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Events extends JFrame implements ActionListener {

	ArrayList<JCheckBox> chbNumbers = new ArrayList<JCheckBox>(49);
	JLabel lblInfo;
	JButton btPlay;
	int chbWidth = 40;
	int chbHeight = 40;

	int btPlayLocX = 10;
	int chbLocX = 10;
	int chbLocY = 70;

	int chbCommand=0;

	ArrayList<Integer> randomNum = new ArrayList<Integer>(6);
	ArrayList<Integer> selectedNum = new ArrayList<Integer>(6);

	public Events() {

		setLayout(null);

		lblInfo = new JLabel("SELECT 6 NUMBERS");
		lblInfo.setSize(400, 50);
		lblInfo.setLocation(10, 10);
		lblInfo.setFont(new Font("TimesRoman", Font.BOLD, 30));
		add(lblInfo);

		for (int i = 0; i < 49; i++) {
			chbNumbers.add(i, new JCheckBox(String.format("%d", i)));
			chbNumbers.get(i).setSize(chbWidth, chbHeight);
			chbNumbers.get(i).setLocation(chbLocX, chbLocY);
			chbNumbers.get(i).addActionListener(this);
			chbNumbers.get(i).setActionCommand(String.format("%d", i));
			this.add(chbNumbers.get(i));

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		checkNumbers(e);

		if (e.getSource() == btPlay) {
			

			for (int i = 0; i <= 6; i++) {
				randomNum.add((int) (Math.random() * 50));
			}

			for (int i = 0; i < chbNumbers.length; i++) {
				chbCommand=Integer.parseInt(chbNumbers[i].getActionCommand());
				
				if(randomNum.contains(chbCommand)){
					if(selectedNum.contains(chbCommand)){
						chbNumbers[i].setBackground(Color.GREEN);

					}else{
						chbNumbers[i].setBackground(Color.RED);
					}
				}else{
					chbNumbers[i].setBackground(Color.RED);
				}
			}

		}

	}

	private void checkNumbers(ActionEvent e) {
		if (e.getSource().getClass() == chbNumbers[1].getClass() && selectedNum.size() <= 7) {

			if (selectedNum.size() == 5) {
				btPlay.setVisible(true);
			}

			if (selectedNum.size() < 6) {

				if (((JCheckBox) e.getSource()).isSelected()) {
					if (!selectedNum.contains(Integer.parseInt(e.getActionCommand()))) {
						selectedNum.add(Integer.parseInt(e.getActionCommand()));
					}

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
				}

			}

		}
	}

}
