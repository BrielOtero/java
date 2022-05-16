package exercise;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Events extends JDialog implements ActionListener, ItemListener {

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
	JLabel lblError;
	JLabel lblInfoDecimals;
	JComboBox<String> cbDecimals;

	ButtonGroup bgpSymbols;

	int mainCalYLoc = 30;
	int mainCalHeight = 30;
	int symbolCalYLoc = 10;
	int symbolCalheight = 20;
	int numberDecimals = 2;

	String selectedOperation = "0";
	int selectedDecimals = 2;

	String fileCont = "";
	String[] fileContSplit;

	double result = 2;
	double leftValue = 0;
	double rightValue = 0;
	boolean error = false;
	boolean firstBoot = true;
	boolean readsuccessfully=true;

	String[] decimals = { "0", "1", "2", "3", "4", "5" };

	public Events() {

		super();
		setLayout(null);

		try (Scanner s = new Scanner(new File(System.getProperty("user.home") + File.separator + ".calculator.txt"))) {
			while (s.hasNext()) {
				fileCont += s.nextLine();
			}
			fileContSplit = fileCont.split("///");

			leftValue = Double.parseDouble(fileContSplit[0]);
			selectedOperation = fileContSplit[1];
			rightValue = Double.parseDouble(fileContSplit[2]);
			result = Double.parseDouble(fileContSplit[3]);
			selectedDecimals = Integer.parseInt(fileContSplit[4]);


		} catch (IOException j) {
			System.err.println("Error Reading File");
			readsuccessfully=false;
		}

		rbSum = new JRadioButton("Sum");
		rbSum.setSelected(false);
		rbSum.setActionCommand("0");
		rbSum.setLocation(25, symbolCalYLoc);
		rbSum.setSize(70, symbolCalheight);
		rbSum.addActionListener(this);
		rbSum.addItemListener(this);

		rbSubtraction = new JRadioButton("Subtraction");
		rbSubtraction.setSelected(false);
		rbSubtraction.setLocation(25, rbSum.getY() + rbSum.getSize().height);
		rbSubtraction.setActionCommand("1");
		rbSubtraction.setSize(100, symbolCalheight);
		rbSubtraction.addActionListener(this);
		rbSubtraction.addItemListener(this);

		rbMultiplication = new JRadioButton("Multiplication");
		rbMultiplication.setSelected(false);
		rbMultiplication.setActionCommand("2");
		rbMultiplication.setLocation(25, rbSubtraction.getY() + rbSubtraction.getSize().height);
		rbMultiplication.setSize(100, symbolCalheight);
		rbMultiplication.addActionListener(this);
		rbMultiplication.addItemListener(this);

		rbDivision = new JRadioButton("Division");
		rbDivision.setSelected(false);
		rbDivision.setActionCommand("3");
		rbDivision.setLocation(25, rbMultiplication.getY() + rbMultiplication.getSize().height);
		rbDivision.setSize(100, symbolCalheight);
		rbDivision.addActionListener(this);
		rbDivision.addItemListener(this);

		setSelectedOperation();
		add(rbSum);
		add(rbSubtraction);
		add(rbMultiplication);
		add(rbDivision);

		bgpSymbols = new ButtonGroup();
		bgpSymbols.add(rbSum);
		bgpSymbols.add(rbSubtraction);
		bgpSymbols.add(rbMultiplication);
		bgpSymbols.add(rbDivision);

		tfLeft = new JTextField(10);
		tfLeft.setLocation(rbMultiplication.getX() + rbMultiplication.getSize().width + 25, mainCalYLoc);
		tfLeft.setSize(100, mainCalHeight);
		tfLeft.addActionListener(this);
		add(tfLeft);

		lblSymbol = new JLabel("+");
		lblSymbol.setLocation(tfLeft.getX() + tfLeft.getSize().width + 25, mainCalYLoc);
		lblSymbol.setSize(10, mainCalHeight);
		add(lblSymbol);

		tfRight = new JTextField(10);
		tfRight.setLocation(lblSymbol.getX() + lblSymbol.getSize().width + 25, mainCalYLoc);
		tfRight.setSize(100, mainCalHeight);
		tfRight.addActionListener(this);
		add(tfRight);

		lblEqual = new JLabel("=");
		lblEqual.setLocation(tfRight.getX() + tfRight.getSize().width + 25, mainCalYLoc);
		lblEqual.setSize(100, mainCalHeight);
		add(lblEqual);

		lblInfoDecimals = new JLabel("Decimals");
		lblInfoDecimals.setSize(100, 10);
		lblInfoDecimals.setLocation(25, rbDivision.getY() + rbDivision.getSize().height + 25);
		add(lblInfoDecimals);

		cbDecimals = new JComboBox<String>(decimals);
		cbDecimals.setSize(100, 30);
		cbDecimals.setLocation(25, lblInfoDecimals.getY() + lblInfoDecimals.getSize().height + 5);
		cbDecimals.setMaximumRowCount(6);
		cbDecimals.setSelectedIndex(selectedDecimals);
		cbDecimals.addItemListener(this);
		add(cbDecimals);

		btOperation = new JButton("Operation");
		btOperation.setLocation(cbDecimals.getX() + cbDecimals.getSize().width + 25,
				rbDivision.getY() + rbDivision.getSize().height + 25);
		btOperation.setSize(200, 50);
		btOperation.addActionListener(this);
		add(btOperation);

		lblError = new JLabel();
		lblError.setLocation(btOperation.getX() + btOperation.getSize().width + 25,
				rbDivision.getY() + rbDivision.getSize().height + 25);
		lblError.setVisible(false);
		lblError.setSize(200, 50);
		add(lblError);

		if(readsuccessfully){
			tfLeft.setText(String.format("%f",leftValue));
			tfRight.setText(String.format("%f",rightValue));
			lblEqual.setText(String.format("=%f",result));
		}

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String saveValue=String.format(Locale.US,"%f///%s///%f///%f///%d", leftValue, selectedOperation, rightValue, result,
				selectedDecimals);
				try (PrintWriter pw = new PrintWriter(
						System.getProperty("user.home") + File.separator + ".calculator.txt")) {
					pw.println(saveValue);
				} catch (IOException j) {
					System.err.println("Error Writing File");
				}
				dispose();
			}
		});
		firstBoot = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		
		if (e.getSource() == btOperation) {

			calculatorAlgo();

			showResult();
		}

		if(e.getSource()==rbSum || e.getSource()==rbSubtraction || e.getSource()==rbMultiplication || e.getSource()==rbDivision   ){
	
		selectedOperation=e.getActionCommand();

			
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (!firstBoot) {

			if (e.getSource() == rbSum) {
				lblSymbol.setText("+");
			}
			if (e.getSource() == rbSubtraction) {
				lblSymbol.setText("-");
			}
			if (e.getSource() == rbMultiplication) {
				lblSymbol.setText("x");
			}
			if (e.getSource() == rbDivision) {
				lblSymbol.setText("÷");
			}

			lblEqual.setText("=");


			if (e.getSource() == cbDecimals) {
			selectedDecimals=cbDecimals.getSelectedIndex();				
				calculatorAlgo();
				showResult();
			}	
		}


	}

	private void calculatorAlgo() {
		error = false;

		try {
			leftValue = Double.parseDouble(tfLeft.getText());
			rightValue = Double.parseDouble(tfRight.getText());

			if (rbSum.isSelected()) {
				result = leftValue + rightValue;
			}
			if (rbSubtraction.isSelected()) {
				result = leftValue - rightValue;
			}
			if (rbMultiplication.isSelected()) {
				result = leftValue * rightValue;
			}
			if (rbDivision.isSelected()) {
				if (rightValue <= 0) {
					throw new NumberFormatException();
				}
				result = leftValue / rightValue;
			}
		} catch (NumberFormatException j) {
			System.err.println("Error");
			error = true;
		}
	}

	private void showResult() {
		if (!error) {
			lblError.setText("Error False");
			lblEqual.setText(String.format("= %." + selectedDecimals + "f", result));
			lblError.setVisible(false);
			lblError.setText("");
		} else {
			System.err.println("Error True");
			lblEqual.setText("=");
			lblError.setText("Error");
			lblError.setForeground(Color.RED);
			lblError.setVisible(true);
		}
	}

	private void setSelectedOperation() {
		int i = Integer.parseInt(selectedOperation);

		JRadioButton[] rbButtons={rbSum,rbSubtraction,rbMultiplication,rbDivision};
		rbButtons[i].setSelected(true);
	}

}
