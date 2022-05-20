package exercise;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Events extends JDialog implements ActionListener, ItemListener {

	// Declarating variables
	JComboBox<String> cbA;
	JComboBox<String> cbB;

	JButton btAdd;
	JButton btRemove;
	JButton btTransferA;
	JButton btTransferB;

	JTextField txfA;
	JTextField txfB;

	JLabel lblElements;
	JLabel lblIndex;

	Timer tmRunTime;
	int timeRuntime = 0;

	int heightSize = 25;
	int lblY = 25;
	int btLocY = 60;
	int txLocY = 95;
	int cbLocY = 130;

	String[] textASplit;
	boolean errTxtA = true;


	// Constructor
	public Events() {
		super();

		setLayout(null);

		tmRunTime = new Timer(1000, this);
		tmRunTime.start();

		MouseHandler handler = new MouseHandler();

		btAdd = new JButton("Add");
		btAdd.setSize(100, heightSize);
		btAdd.setLocation(25, btLocY);
		btAdd.addActionListener(this);
		btAdd.addMouseListener(handler);
		btAdd.setToolTipText("Add element");
		add(btAdd);

		btRemove = new JButton("Remove");
		btRemove.setSize(100, heightSize);
		btRemove.setLocation(btAdd.getX() + btAdd.getSize().width + 5, btLocY);
		btRemove.addActionListener(this);
		btRemove.setToolTipText("Remove element");
		add(btRemove);

		btTransferA = new JButton("Transfer A");
		btTransferA.setSize(100, heightSize);
		btTransferA.setLocation(btRemove.getX() + btRemove.getSize().width + 5, btLocY);
		btTransferA.addActionListener(this);
		btTransferA.setToolTipText("Transfer de selected element. Right to left.");
		add(btTransferA);

		btTransferB = new JButton("Transfer B");
		btTransferB.setSize(100, heightSize);
		btTransferB.setLocation(btTransferA.getX() + btTransferA.getSize().width + 5, btLocY);
		btTransferB.addActionListener(this);
		btTransferA.setToolTipText("Transfer de selected element. Left to right.");
		add(btTransferB);

		txfA = new JTextField(20);
		txfA.setSize(200, heightSize);
		txfA.addActionListener(this);
		txfA.setLocation(25, txLocY);
		txfA.setToolTipText("The name of the new item. Can be more than one. Separated by ;");
		add(txfA);

		txfB = new JTextField(20);
		txfB.setSize(200, heightSize);
		txfB.addActionListener(this);
		txfB.setLocation(txfA.getX() + txfA.getSize().width + 17, txLocY);
		txfB.setToolTipText("Insert the start name of the item to delete it.");
		add(txfB);

		cbA = new JComboBox<String>();
		cbA.setSize(200, heightSize);
		cbA.setLocation(25, cbLocY);
		cbA.addItemListener(this);
		cbA.setVisible(false);
		cbA.setToolTipText("The elements that you add");
		add(cbA);

		cbB = new JComboBox<String>();
		cbB.setSize(200, heightSize);
		cbB.setLocation(cbA.getX() + cbA.getSize().width + 17, cbLocY);
		cbB.addItemListener(this);
		cbB.setVisible(false);
		cbB.setToolTipText(String.format("%d elements", cbB.getItemCount()));
		add(cbB);

		lblElements = new JLabel("Elements: 0");
		lblElements.setSize(200, heightSize);
		lblElements.setLocation(25, lblY);
		add(lblElements);

		lblIndex = new JLabel("Selected Index: 0");
		lblIndex.setSize(200, heightSize);
		lblIndex.setLocation(lblElements.getX() + lblElements.getSize().width + 17, lblY);
		add(lblIndex);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int res = JOptionPane.showConfirmDialog(null, "Do you want close the program?", "Close",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (res == JOptionPane.OK_OPTION) {
					e.getWindow().dispose();
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// A timer that resets elements of the program after 60 seconds.
		if (e.getSource() == tmRunTime) {
			timeRuntime++;

			if (timeRuntime > 60) {
				cbA.removeAllItems();
				cbA.setVisible(false);
				cbB.removeAllItems();
				cbB.setVisible(false);
				txfA.setText("");
				txfB.setText("");
				timeRuntime = 0;
			}
		}

		// Adding the text from the textfield to the combobox.
		addElementsCbA(e);

		// Removing the elements from the combo box.
		rmElementsCbA(e);

		// Transferring the selected item from the left combo box to the right combo box and vice versa.
		transferAB(e);

		// It sets the text of the label to the number of items in the combo box and the index of the
		// selected item
		showLblInfo();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		// It sets the text of the label to the number of items in the combo box and the index of the
		// selected item
		if (e.getSource() == cbA) {
			resetTimer();
			lblIndex.setText(String.format("Selected Index: %d", cbA.getSelectedIndex() + 1));
		}

	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);

			if (e.getSource() == btAdd) {
				resetTimer();
				btAdd.setForeground(Color.RED);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);

			if (e.getSource() == btAdd) {
				btAdd.setForeground(Color.BLACK);
			}
		}
	}

	/**
	 * If the user clicks the button or presses enter in the textfield, the textfield's text is added to
	 * the combobox
	 * 
	 * @param e the event that triggered the method
	 */
	private void addElementsCbA(ActionEvent e) {
		if (e.getSource() == btAdd || e.getSource() == txfA) {
			resetTimer();

			String txtA = txfA.getText();
			if (!txtA.equals("") && !txtA.trim().equals("")) {

				if (txtA.contains(";")) {
					textASplit = txtA.split(";");
					for (int i = 0; i < textASplit.length; i++) {
						if (!textASplit[i].trim().equals("") && !textASplit[i].equals(" ")) {
							cbA.addItem(textASplit[i]);
							errTxtA = false;
							cbA.setSelectedIndex(i);
						}
					}

				} else {
					cbA.addItem(txtA);
					errTxtA = false;
					cbA.setSelectedIndex(cbA.getItemCount() - 1);

				}

			}

			if (!errTxtA) {
				cbA.setVisible(true);
			}
			showLblInfo();
		}
	}

	/**
	 * If the user clicks the "Remove" button, then the function will remove all items from the combo box
	 * that start with the text in the text field
	 * 
	 * @param e the event that triggered the method
	 */
	private void rmElementsCbA(ActionEvent e) {
		if (e.getSource() == btRemove) {
			resetTimer();
			String txtB;
			Boolean anyDelete = false;
			txtB = txfB.getText();
			if (!txtB.trim().equals("")) {
				for (int i = cbA.getItemCount() - 1; i >= 0; i--) {
					if (cbA.getItemAt(i).startsWith(txtB)) {
						cbA.removeItemAt(i);
						anyDelete = true;
					}
				}
				if (anyDelete) {
					txfB.setText("");
				}
			} else {
				cbA.removeItem(cbA.getSelectedItem());
			}
			visibleCbA();
		}
	}

	private void transferAB(ActionEvent e) {

		// Transferring the selected item from the left combo box to the right combo box.
		if (e.getSource() == btTransferB) {
			resetTimer();
			if (cbA.getItemCount() > 0) {
				cbB.addItem(cbA.getSelectedItem().toString());
				cbB.setSelectedIndex(cbB.getItemCount() - 1);
				cbA.removeItem(cbA.getSelectedItem());
			}
			visibleCbA();
			visibleCbB();
		}

		// Transferring the selected item from the right combo box to the left combo box.
		if (e.getSource() == btTransferA) {
			resetTimer();
			if (cbB.getItemCount() > 0) {
				cbA.addItem(cbB.getSelectedItem().toString());
				cbA.setSelectedIndex(cbA.getItemCount() - 1);
				cbB.removeItem(cbB.getSelectedItem());
			}
			visibleCbA();
			visibleCbB();

		}
	}

	/**
	 * If the number of items in the combo box is less than or equal to zero, then the combo box is not
	 * visible. Otherwise, the combo box is visible
	 */
	private void visibleCbA() {
		if (cbA.getItemCount() <= 0) {
			cbA.setVisible(false);
		} else {
			cbA.setVisible(true);
		}
	}

	/**
	 * If the number of items in the combo box is less than or equal to zero, then the combo box is not
	 * visible. Otherwise, the combo box is visible
	 */
	private void visibleCbB() {
		if (cbB.getItemCount() <= 0) {
			cbB.setVisible(false);
		} else {
			cbB.setVisible(true);
		}

		cbB.setToolTipText(String.format("%d elements", cbB.getItemCount()));
	}

	/**
	 * It sets the text of the label to the number of items in the combo box and the index of the selected
	 * item
	 */
	private void showLblInfo() {
		lblElements.setText(String.format("Elements: %d", cbA.getItemCount()));
		lblIndex.setText(String.format("Selected Index: %d", cbA.getSelectedIndex() + 1));
	}

	/**
	 * This function resets the timer to zero
	 */
	private void resetTimer() {
		timeRuntime=0;
	}

}
