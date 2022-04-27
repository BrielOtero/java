package exercise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Events extends JFrame implements ActionListener {
	JLabel leftIcon;
	JLabel middleIcon;
	JLabel rightIcon;
	JLabel signWinOrLost;
	JLabel winOrLost;
	JLabel money;
	JLabel badge;

	JButton play;

	Timer flicker;

	double moneyValue;
	double winOrLostValue;

	int cont = 0;

	int[] values = new int[3];

	boolean lose = false;
	boolean activateFlicker = false;

	char signWinOrLostValue;

	Object[] paths = new Object[6];

	public Events() {
		super("Superminislots");
		this.setLayout(null);

		flicker = new Timer(1000, this);
		flicker.start();

		ImageIcon icon = new ImageIcon(
				"images\\1.png");

		leftIcon = new JLabel(icon);
		leftIcon.setSize(200, 200);
		leftIcon.setLocation(0, 0);
		add(leftIcon);

		middleIcon = new JLabel(icon);
		middleIcon.setSize(200, 200);
		middleIcon.setLocation(200, 0);
		add(middleIcon);

		rightIcon = new JLabel(icon);
		rightIcon.setSize(200, 200);
		rightIcon.setLocation(400, 0);
		add(rightIcon);

		play = new JButton("Play");
		play.setBackground(new Color(35, 39, 46));
		play.setForeground(new Color(255, 255, 255));
		play.setSize(180, 100);
		play.setLocation(200, 200);
		play.addActionListener(this);
		add(play);

		signWinOrLost = new JLabel("", 10);
		signWinOrLost.setFont(new Font("Arial", Font.BOLD, 40));
		signWinOrLost.setSize(100, 100);
		signWinOrLost.setLocation(70, 200);
		add(signWinOrLost);

		winOrLost = new JLabel("", 10);
		winOrLost.setFont(new Font("Arial", Font.BOLD, 40));
		winOrLost.setSize(100, 100);
		winOrLost.setLocation(100, 200);
		add(winOrLost);

		money = new JLabel("10", 10);
		money.setFont(new Font("Arial", Font.BOLD, 40));
		money.setSize(100, 100);
		money.setLocation(390, 200);
		this.moneyValue = Double.parseDouble(money.getText());
		add(money);

		badge = new JLabel("Coins", 10);
		badge.setFont(new Font("Arial", Font.BOLD, 40));
		badge.setSize(150, 100);
		badge.setLocation(490, 200);
		add(badge);

		for (int i = 1; i <= 6; i++) {
			ImageIcon ico = new ImageIcon(
					"images\\" + i + ".png");
			paths[i - 1] = ico;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == flicker) {
			cont++;
		}

		for (int i = 0; i <= 2; i++) {
			values[i] = (int) (Math.random() * 6 + 1);
		}

		if (activateFlicker && !lose) {

			if (cont % 2 == 0) {
				play.setBackground(new Color(0, 200, 0));
				play.setForeground(new Color(0, 0, 0));

			} else {
				play.setBackground(new Color(0, 255, 0));
				play.setForeground(new Color(0, 0, 0));
			}

		} else {

			if (!lose) {
				play.setBackground(new Color(35, 39, 46));
				play.setForeground(new Color(255, 255, 255));
			}
		}

		if (e.getSource() == play) {
			if (moneyValue >= 1) {

				if (values[0] == values[1] && values[1] == values[2]) {
					moneyValue += +4;
					winOrLostValue = 5;
					signWinOrLostValue = '+';
					winOrLost.setForeground(new Color(0, 220, 0));
					signWinOrLost.setForeground(new Color(0, 220, 0));
					activateFlicker = true;

				} else if (values[0] == values[1] || values[0] == values[2] || values[1] == values[2]) {
					moneyValue += +0.5;
					winOrLostValue = 1.5;
					signWinOrLostValue = '+';
					winOrLost.setForeground(new Color(0, 220, 0));
					signWinOrLost.setForeground(new Color(0, 220, 0));
					activateFlicker = true;

				} else {
					moneyValue--;
					winOrLostValue = 1;
					signWinOrLostValue = '-';
					winOrLost.setForeground(new Color(255, 0, 0));
					signWinOrLost.setForeground(new Color(255, 0, 0));
					activateFlicker = false;
				}

				leftIcon.setIcon(((ImageIcon) paths[values[0] - 1]));
				middleIcon.setIcon(((ImageIcon) paths[values[1] - 1]));
				rightIcon.setIcon(((ImageIcon) paths[values[2] - 1]));
				signWinOrLost.setText(String.format("%c", signWinOrLostValue));
				winOrLost.setText(String.format("%.1f", winOrLostValue));
				money.setText(String.format("%.1f", moneyValue));

			} else {

				lose = true;
				play.setBackground(new Color(255, 0, 0));
				play.setForeground(new Color(255, 255, 255));
				play.setFont(new Font("Arial", Font.BOLD, 20));
				play.setText("You Lose");
				play.setEnabled(false);

			}

		}
	}

}
