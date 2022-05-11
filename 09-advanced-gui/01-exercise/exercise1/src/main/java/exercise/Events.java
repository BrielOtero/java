package exercise;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * It's a JFrame that implements KeyListener and has a MouseListener and
 * MouseMotionListener
 */
public class Events extends JFrame implements KeyListener {
	JButton btn1;
	JButton btn2;
	JLabel lblKey;
	String setPressed = "";
	String setTyped = "";
	public int xPosition=0;
	public int yPosition=0;

	// It's a static variable that is used to set the default value of the JComboBox
	// in the Secondary class.
	public static int dfSelectItem = 3;

	// It's a static variable that is used to set the default value of the JComboBox
	// in the Secondary class.
	public static String titleWindow = "Mouse Control";

	// It's a static variable that is used to set the default value of the JComboBox
	// in the Secondary class.
	public static Color defaultColor = Color.BLACK;

	/**
	 * This function returns the value of the variable dfSelectItem
	 * 
	 * @return The value of the variable dfSelectItem.
	 */
	public int getDfSelectItem() {
		return dfSelectItem;
	}

	/**
	 * This function sets the value of the variable dfSelectItem to the value of the
	 * parameter
	 * dfSelectItem
	 * 
	 * @param dfSelectItem The index of the item in the dropdown list that is
	 *                     selected.
	 */
	public void setDfSelectItem(int dfSelectItem) {
		Events.dfSelectItem = dfSelectItem;
	}

	/**
	 * This function returns the default color of the object
	 * 
	 * @return The defaultColor variable is being returned.
	 */
	public Color getDefaultColor() {
		return defaultColor;
	}

	/**
	 * This function sets the default color of the events to the color passed in
	 * 
	 * @param defaultColor The color of the event when it is not selected.
	 */
	public void setDefaultColor(Color defaultColor) {
		Events.defaultColor = defaultColor;
	}

	/**
	 * The function setTitleWindow() is a public function that takes a string as an
	 * argument and sets the
	 * value of the variable titleWindow to the value of the argument
	 * 
	 * @param titleWindow The title of the window that will be displayed.
	 */
	public void setTitleWindow(String titleWindow) {
		Events.titleWindow = titleWindow;
	}

	// It's the constructor of the class.
	public Events() {
		super(titleWindow);

		setLayout(null);
		setFocusable(true);

		// It's creating a new instance of the MouseHandler class.
		MouseHandler handler = new MouseHandler();

		// It's creating a new JButton and setting the size, location, background color,
		// and adding a mouse listener and mouse motion listener to the button.
		btn1 = new JButton();
		btn1.setSize(125, 50);
		btn1.setLocation(125, 50);
		btn1.setFocusable(false);
		btn1.addMouseMotionListener(handler);
		btn1.setBackground(defaultColor);
		add(btn1);

		// It's creating a new JButton and setting the size, location, background color,
		// and adding a mouse listener and mouse motion listener to the button.
		btn2 = new JButton();
		btn2.setSize(125, 50);
		btn2.setLocation(250, 50);
		btn2.setFocusable(false);
		btn2.addMouseMotionListener(handler);
		btn2.setBackground(defaultColor);
		add(btn2);

		// It's creating a new JLabel and setting the size and location of the label.
		lblKey = new JLabel("Key");
		lblKey.setSize(250, 50);
		lblKey.setLocation(125, 150);
		add(lblKey);

		// It's adding a mouse listener and mouse motion listener to the content pane of
		// the JFrame and adding a key listener to the JFrame.
		this.getContentPane().addMouseListener(handler);
		this.getContentPane().addMouseMotionListener(handler);

		addKeyListener(this);

		// It's adding a window listener to the JFrame.
		addWindowListener(new WindowAdapter() {

			@Override
			// It's a function that is called when the window is closing.
			public void windowClosing(WindowEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Do you want close the program?", "Close",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (res == JOptionPane.OK_OPTION) {
					e.getWindow().dispose();
				}

			}
		});

	}

	/**
	 * The MouseHandler class extends the MouseAdapter class, which is an abstract
	 * class that implements
	 * the MouseListener interface
	 */
	private class MouseHandler extends MouseAdapter {

		@Override
	// It's setting the title of the window to the position of the mouse.
		public void mouseMoved(MouseEvent e) {
			if (e.getSource() == getContentPane()) {
				xPosition=e.getX();
				yPosition=e.getY();
				Events.this.setTitle(String.format(titleWindow + " - (X:%d,Y:%d)", xPosition, yPosition));
			} else {
				Events.this.setTitle(String.format(titleWindow + " - (X:%d,Y:%d)",e.getX()+xPosition, e.getY()+yPosition));
			}
		}

		@Override
		// It's setting the title of the window to the position of the mouse.
		public void mouseExited(MouseEvent e) {
			Events.this.setTitle(titleWindow);
		}

		@Override
		// It's setting the background color of the button to red when the mouse is
		// pressed.
		public void mousePressed(MouseEvent e) {
			System.err.println(e.getButton());
			if (e.getButton() == 1) {
				btn1.setBackground(Color.red);
			}
			if (e.getButton() == 3) {
				btn2.setBackground(Color.red);
			}
		}

		@Override
		// It's setting the background color of the button to the default color when the
		// mouse is released.
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == 1) {
				btn1.setBackground(defaultColor);
			}
			if (e.getButton() == 3) {
				btn2.setBackground(defaultColor);
			}
		}
	}

	@Override
	// It's setting the value of the variable setPressed to the value of the key
	// that is pressed.
	public void keyPressed(KeyEvent e) {
		System.err.println(e.getKeyCode());
		setPressed = e.getKeyCode() + "";

	}

	@Override
	// It's a function that is called when a key is released.
	public void keyReleased(KeyEvent e) {
	}

	@Override
	// It's setting the value of the variable setTyped to the value of the key that
	// is typed.
	public void keyTyped(KeyEvent e) {
		if (e.isControlDown()) {
			Secondary secondary = new Secondary(this);
			secondary.setLocationRelativeTo(this);
			secondary.setSize(310, 500);
			secondary.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			secondary.setVisible(true);
		}

		System.err.println(e.getKeyChar());
		setTyped = e.getKeyChar() + "";

		// It's setting the text of the label to the value of the variables setTyped and
		// setPressed.
		lblKey.setText(String.format("Key - Unicode:  %s  Code:  %s", setTyped, setPressed));
	}

}
