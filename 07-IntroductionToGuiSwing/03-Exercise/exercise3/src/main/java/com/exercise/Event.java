package com.exercise;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Event extends JFrame implements ActionListener {
	JButton yellow;
	JButton blue;
	JButton random;

	public Event() {
		super("Colors");
		this.setLayout(new FlowLayout());

		yellow = new JButton("Yellow");
		yellow.addActionListener(this);
		this.add(yellow);

		blue = new JButton("Blue");
		blue.addActionListener(this);
		this.add(blue);

		random = new JButton("Random");
		random.addActionListener(this);
		this.add(random);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		e.getModifiers();

		if (e.getSource() == yellow) {
			// yellow.setBackground(new Color(255,255,0));
			getContentPane().setBackground(Color.yellow);
		}
		if (e.getSource() == blue) {
			// blue.setBackground(new Color(0,255,255));
			getContentPane().setBackground(Color.blue);
		}
		if (e.getSource() == random) {
			int num1 = (int) (Math.random() * 600);
			int num2 = (int) (Math.random() * 400);
			this.setLocation(num1, num2);
			
		}

	}

}
