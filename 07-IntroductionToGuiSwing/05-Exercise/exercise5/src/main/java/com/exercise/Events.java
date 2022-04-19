package com.exercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Events extends JFrame implements ActionListener, ItemListener {
	JLabel info1;
	JButton send;
	JTextField txt1;
	JCheckBox check;
	JCheckBox textFieldWork;

	public Events() {
		super("Exercise 5");

		this.setLayout(new FlowLayout());

		info1 = new JLabel("Introduce an text");
		add(info1);

		txt1 = new JTextField(20);
		txt1.addActionListener(this);
		add(txt1);

		send = new JButton("Send");
		send.addActionListener(this);
		add(send);

		check = new JCheckBox("Turn around");
		add(check);

		textFieldWork = new JCheckBox("Enable JTextField", true);
		textFieldWork.addItemListener(this);
		add(textFieldWork);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String txtUser;
		String txtToSet = "";
		txtUser = txt1.getText();

		if (check.isSelected()) {
			for (int i = txtUser.length() - 1; i >= 0; i--) {
				txtToSet = txtToSet + txtUser.charAt(i);
			}
		} else {
			txtToSet = txtUser;
		}

		if (e.getSource() == txt1 || e.getSource() == send) {
			txtUser = txt1.getText();

			int option = JOptionPane.showConfirmDialog(null, "Do you want set \"" + txtToSet + "\" as a title?",
					"Set Title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			switch (option) {
				case 0:
					this.setTitle(txtToSet);
					break;
				case 1:
					break;
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		txt1.setEnabled(textFieldWork.isSelected());
	}
}
