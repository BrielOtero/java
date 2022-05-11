package exercise;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * It creates a secondary window that can be used to display information.
 */
public class Secondary extends JDialog implements ActionListener, ItemListener {

	// Declaring the variables that will be used in the class.

	JLabel lblTfTitle;
	JTextField tfTitle;

	JComboBox<String> cbColors;
	JLabel lblCbColors;

	JButton save;

	String[] colorsName = { "Orange", "Green", "Blue", "Black" };
	Color[] colors={Color.ORANGE,Color.GREEN,Color.BLUE,Color.BLACK};


	Events events = (Events) this.getOwner();

	Color color = Color.BLACK;

	// A static variable that is used to store the selected index of the combo box.
	public static int dfSelectSecon;

	/**
	 * This function returns the default value of the secondary selection
	 * 
	 * @return The value of the variable dfSelectSecon.
	 */
	public static int getDefaultSelectSecondary() {
		return dfSelectSecon;
	}

	/**
	 * This function sets the default value for the secondary selection
	 * 
	 * @param defaultSelectSecondary The default value for the secondary select box.
	 */
	public static void setDefaultSelectSecondary(int defaultSelectSecondary) {
		Secondary.dfSelectSecon = defaultSelectSecondary;
	}

	// The constructor of the class.
	public Secondary(Events e) {
		super(e, true);
		setTitle("TITLE & COLORS");

		setLayout(null);

		dfSelectSecon = events.getDfSelectItem();

		// Creating a label with the text "Select the title of the window" and setting
		// its size and location.
		lblTfTitle = new JLabel("Select the title of the window");
		lblTfTitle.setSize(250, 50);
		lblTfTitle.setLocation(25, 0);
		add(lblTfTitle);

		// Creating a text field with a size of 250x50 and a location of 25,60. It is
		// also adding an action
		// listener to the text field and adding it to the window.
		tfTitle = new JTextField(10);
		tfTitle.setSize(250, 50);
		tfTitle.setLocation(25, 60);
		tfTitle.addActionListener(this);
		add(tfTitle);

		// Creating a label with the text "Select the color of the buttons" and setting
		// its size and
		// location.
		lblCbColors = new JLabel("Select the color of the buttons");
		lblCbColors.setSize(250, 50);
		lblCbColors.setLocation(25, 150);
		add(lblCbColors);

		// Creating a combo box with the colors array as the options. It is also setting
		// the maximum number
		// of rows to 4, setting the selected index to the default value of the
		// secondary selection, adding
		// an item listener to the combo box, setting the size and location of the combo
		// box, and adding the
		// combo box to the window.
		cbColors = new JComboBox<String>(colorsName);
		cbColors.setMaximumRowCount(4);
		cbColors.setSelectedIndex(dfSelectSecon);
		cbColors.addItemListener(this);
		cbColors.setSize(250, 50);
		cbColors.setLocation(25, 210);
		add(cbColors);

		// Creating a button with the text "Save", adding an action listener to the
		// button, setting the size
		// and location of the button, and adding the button to the window.
		save = new JButton("Save");
		save.addActionListener(this);
		save.setSize(250, 50);
		save.setLocation(25, 350);
		add(save);

	}

	@Override
	// An event handler that is called when an action is performed.
	public void actionPerformed(ActionEvent e) {

		// Setting the title of the window, the title of the button, the background
		// color of the buttons, and
		// the default color of the buttons.
		events.setTitleWindow(tfTitle.getText());
		events.setTitle(tfTitle.getText());
		events.btn1.setBackground(colors[cbColors.getSelectedIndex()]);
		events.btn2.setBackground(colors[cbColors.getSelectedIndex()]);
		events.setDefaultColor(colors[cbColors.getSelectedIndex()]);

		if (e.getSource() == save) {
			if (events.getDefaultColor() == null) {
				events.setVisible(true);
				events.setDefaultColor(Color.BLACK);
			}
			if (tfTitle.getText().equals("")) {
				events.setTitle("Mouse Control");
				events.setTitleWindow("Mouse Control");
			}
			events.btn1.setBackground(colors[cbColors.getSelectedIndex()]);
			events.btn2.setBackground(colors[cbColors.getSelectedIndex()]);
			events.setDefaultColor(colors[cbColors.getSelectedIndex()]);
			this.getContentPane().setBackground(Color.red);
			this.setVisible(false);
		}
	}

	@Override
	// A method that is called when an item is selected from the combo box.
	public void itemStateChanged(ItemEvent e) {

		// Setting the default color of the buttons to the color that is selected in the combo box.
		events.setDfSelectItem(cbColors.getSelectedIndex());
		events.btn1.setBackground(colors[cbColors.getSelectedIndex()]);
		events.btn2.setBackground(colors[cbColors.getSelectedIndex()]);
		events.setDefaultColor(colors[cbColors.getSelectedIndex()]);

	}

}
