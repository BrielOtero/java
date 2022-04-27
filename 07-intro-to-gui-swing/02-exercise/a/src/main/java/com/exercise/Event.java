package com.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event extends JFrame implements ActionListener {
	JLabel label;
	JButton button;
	int randomValue;
	

	public Event() {
		super("Dice");
		this.setLayout(new FlowLayout());
		// this.setLayout(null);

		button = new JButton("Roll the dice");
		// button.setSize(button.getPreferredSize());
		// button.setLocation(0, 0);
		button.addActionListener(this);
		this.add(button);

		label = new JLabel("Prepare your luck");
		// label.setSize(label.getPreferredSize());
		// label.setLocation(150, 0);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			randomValue = (int) (Math.random() * 6 + 1);
		}
		label.setText(String.format("%2d", randomValue));

	}

}
