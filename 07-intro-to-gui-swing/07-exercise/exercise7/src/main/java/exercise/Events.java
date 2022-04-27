package exercise;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;

public class Events extends JFrame implements ActionListener {
	JTextField random1;
	JTextField random2;
	JTextField random3;
	JButton play;
	JLabel info;
	JLabel currentTimeLabel;
	Timer currentTime;
	int seconds = 0;
	int minutes = 0;

	public Events() {
		super("Exercise 7");

		this.setLayout(new FlowLayout());

		currentTime = new Timer(1000, this);
		currentTime.start();

		random1 = new JTextField("", 3);
		random1.setEnabled(false);
		add(random1);

		random2 = new JTextField("", 3);
		random2.setEnabled(false);
		add(random2);

		random3 = new JTextField("", 3);
		random3.setEnabled(false);
		add(random3);

		play = new JButton("Play");
		play.addActionListener(this);
		add(play);

		currentTimeLabel = new JLabel();
		add(currentTimeLabel);

		info = new JLabel();
		add(info);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == currentTime) {
			seconds++;
			if (seconds >= 60) {
				seconds = 0;
				minutes++;
			}
		}

		currentTimeLabel.setText(String.format("%02d:%02d\n", minutes, seconds));
		if (e.getSource() == play) {
			int[] values = new int[3];

			for (int i = 0; i <= 2; i++) {
				values[i] = (int) (Math.random() * 6 + 1);
			}
			random1.setText(String.format("%d", values[0]));
			random2.setText(String.format("%d", values[1]));
			random3.setText(String.format("%d", values[2]));

			if (values[0] == values[1] && values[1] == values[2]) {
				info.setText("Congratulations!! You have won an award");
			} else {
				info.setText("Sorry, you lost! Try it again");
			}

		}

	}

}
