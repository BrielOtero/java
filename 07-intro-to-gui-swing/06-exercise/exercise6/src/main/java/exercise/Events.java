package exercise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Events extends JFrame implements ActionListener {
	JTextField text1;
	JTextField text2;
	JLabel label;
	JButton sum;
	JButton divide;
	JButton squareRoot;

	public Events() {
		super("Exercise 6");

		this.setLayout(new FlowLayout());

		text1 = new JTextField("", 5);
		add(text1);

		text2 = new JTextField("", 5);
		add(text2);

		label = new JLabel("");
		add(label);

		sum = new JButton("Sum");
		sum.addActionListener(this);
		add(sum);

		divide = new JButton("Divide");
		divide.addActionListener(this);
		add(divide);

		squareRoot = new JButton("Square Root");
		squareRoot.addActionListener(this);
		add(squareRoot);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double value1 = 0;
		double value2 = 0;
		String return1 = "";
		String return2 = "";
		String return3 = "";
		label.setForeground(new Color(0, 0, 0));
		boolean error = false;

		error = false;
		if (text1.getText().equals("") && text1.getText().equals("")) {
		} else if (text2.getText().equals("")) {

			try {
				value1 = Double.parseDouble(text1.getText());

			} catch (NumberFormatException i) {
				label.setForeground(new Color(255, 0, 0));
				label.setText("It is not a numeric value");
				error = true;
			}

		} else {

			try {
				value1 = Double.parseDouble(text1.getText());
				value2 = Double.parseDouble(text2.getText());

			} catch (NumberFormatException i) {
				label.setForeground(new Color(255, 0, 0));
				label.setText("It is not a numeric value");
				error = true;
			}
		}

		if (error == false) {

			if (e.getSource() == sum) {

				if (text1.getText().equals("") || text2.getText().equals("")) {
					label.setForeground(new Color(255, 0, 0));
					label.setText("Please fill the fields");

				} else {
					return1 = String.format("= %.3f\n", value1 + value2);
					label.setText(return1);
				}
			}

			if (e.getSource() == divide) {

				if (text1.getText().equals("") || text2.getText().equals("")) {
					label.setForeground(new Color(255, 0, 0));
					label.setText("Please fill the fields");

				} else if (value2 == 0) {
					label.setForeground(new Color(255, 0, 0));
					label.setText("Cannot be divided by zero");

				} else {
					return2 = String.format("= %.3f\n", value1 / value2);
					label.setText(return2);
				}
			}

			if (e.getSource() == squareRoot) {
				if (text1.getText().equals("")) {
					label.setForeground(new Color(255, 0, 0));
					label.setText("Please fill the left field");

				} else if (value1 < 0) {
					label.setForeground(new Color(255, 0, 0));
					label.setText("Not negative number");

				} else {
					return3 = String.format("= %.3f\n", Math.sqrt(value1));
					label.setText(return3);
				}
			}
		}

	}

}
