package exercise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Events extends JFrame implements ActionListener {
	JLabel infoRed;
	JTextField red;
	JLabel infoGreen;
	JTextField green;
	JLabel infoBlue;
	JTextField blue;
	JButton color;
	JLabel showError;
	JTextField path;
	JLabel image;
	boolean error = false;

	public Events() {
		super("Exercise 8");

		this.setLayout(new FlowLayout());

		infoRed = new JLabel("Red");
		add(infoRed);

		red = new JTextField("", 3);
		red.setToolTipText("Red Color");
		add(red);

		infoGreen = new JLabel("Green");
		add(infoGreen);

		green = new JTextField("", 3);
		green.setToolTipText("Green Color");
		add(green);

		infoBlue = new JLabel("Blue");
		add(infoBlue);

		blue = new JTextField(3);
		blue.setToolTipText("Blue Color");
		blue.addActionListener(this);
		add(blue);

		color = new JButton("Color");
		color.setToolTipText("The button to set the color");
		color.addActionListener(this);
		add(color);

		showError = new JLabel("", 10);
		showError.setToolTipText("Show the errors");
		add(showError);

		path = new JTextField("", 20);
		path.setToolTipText("Insert the path of the image");
		path.addActionListener(this);
		add(path);

		image = new JLabel("");
		image.setToolTipText("The label to show the image");
		add(image);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int redValue = 0;
		int greenValue = 0;
		int blueValue = 0;

		error = false;
		if (red.getText().equals("") || green.getText().equals("") || blue.getText().equals("")) {
			error = true;
			showError.setText("Please fill the fields");
		} else {
			
			try {
				redValue = Integer.parseInt(red.getText());
				greenValue = Integer.parseInt(green.getText());
				blueValue = Integer.parseInt(blue.getText());

				if (redValue > 255 || redValue < 0 || greenValue > 255 || greenValue < 0 || blueValue > 255
						|| blueValue < 0) {
					throw new NumberFormatException();
				}

			} catch (NumberFormatException i) {
				showError.setText("Please insert a valid number");
				error = true;
			}
		}

		if (!error) {
			showError.setText("");
			if (e.getSource() == blue || e.getSource() == color) {
				color.setBackground(new Color(redValue, greenValue, blueValue));
			} else if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
				color.setForeground(new Color(redValue, greenValue, blueValue));
			}
		}

		if (e.getSource() == path) {
			ImageIcon imageIcon = new ImageIcon(path.getText());
			image.setIcon(imageIcon);
		}

	}

}
