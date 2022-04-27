package com.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class Events extends JFrame implements ActionListener {
	JLabel label;
	JLabel labelInstr;
	int randomValue;
	JTextField userValueAsk;

	public Events() {

		super("Dice");
		//this.setLayout(new FlowLayout());
		this.setLayout(null);
		
		labelInstr = new JLabel("Introduce an number");
		labelInstr.setSize(labelInstr.getPreferredSize());
		labelInstr.setLocation(0, 0);
		this.add(labelInstr);

		userValueAsk = new JTextField(5);
		userValueAsk.addActionListener(this);
		userValueAsk.setSize(userValueAsk.getPreferredSize());
		userValueAsk.setLocation(0, 20);
		this.add(userValueAsk);


		label = new JLabel("Prepare your luck");
		label.setSize(label.getPreferredSize());
		label.setLocation(0, 40);
		this.add(label);
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == userValueAsk) {
			try {

				Double valueUser = Double.parseDouble(userValueAsk.getText());

				if (valueUser > 1 && valueUser <= 1000) {

					randomValue = (int) (Math.random() * valueUser + 1);
					label.setText(String.format("%2d", randomValue));
				
				} else {
					JOptionPane.showMessageDialog(null,
							"Invalid number",
							"Error",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (NumberFormatException a) {

				JOptionPane.showMessageDialog(null,
				"Letters are not available",
				"Error",
				JOptionPane.INFORMATION_MESSAGE);
			}
		}


	}

}
