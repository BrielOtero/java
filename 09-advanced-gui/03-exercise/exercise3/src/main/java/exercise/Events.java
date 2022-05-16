package exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Events extends JDialog implements ActionListener{

// Declaring variables.
JTextField tfLeft;
JTextField tfRight;
JLabel lblSymbol;
JLabel lblEqual;
JRadioButton rbSum;
JRadioButton rbSubtraction;
JRadioButton rbMultiplication;
JRadioButton rbDivision;
JButton btOperation;

int mainCalY=25;

 public Events(){

	super();
	setLayout(null);

	tfLeft = new JTextField(10);
	tfLeft.setLocation(25, mainCalY);
	tfLeft.setSize(100,50);
	tfLeft.addActionListener(this);
	add(tfLeft);

	lblSymbol = new JLabel("+");
	lblSymbol.setLocation(tfLeft.getX()+tfLeft.getSize().width+25, mainCalY);
	lblSymbol.setSize(10,50);
	add(lblSymbol);

	tfRight = new JTextField(10);
	tfRight.setLocation(lblSymbol.getX()+lblSymbol.getSize().width+25, mainCalY);
	tfRight.setSize(100,50);
	tfRight.addActionListener(this);
	add(tfRight);

	lblEqual = new JLabel("=");
	lblEqual.setLocation(tfRight.getX()+tfRight.getSize().width+25, mainCalY);
	lblEqual.setSize(10,50);
	add(lblEqual);



	

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
