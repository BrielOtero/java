package exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Events extends JDialog implements ActionListener, KeyListener {
	JTextField phoneNumber;
	public int size = 80;
	public int sizeImg = 70;
	public int separation = 15;
	public int topLineSize = 50;
	public int topLineImgSize = 45;
	public int fontSize = 28;
	public int historyX = 0;
	public Color[] colors = { Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.CYAN,
		Color.PINK };
	Timer timeColor;
	Timer timeTrash;

	int contAnimation = 0;
	int contTrash = 0;

	ImgFormat imgFormat = new ImgFormat();
	ImageIcon[] icons;
	public JLabel[] label;
	public JLabel trash;

	public int selectedLabel = 999;
	public boolean isAnySet = false;

	public Events() throws IOException {

		setTitle("Phone");
		setLayout(null);
		setFocusable(true);
		setMinimumSize(new Dimension(330, 530));

		MouseHandler handler = new MouseHandler();

		timeColor = new Timer(300, this);
		timeTrash = new Timer(2000, this);
		timeColor.start();
		timeTrash.start();

		phoneNumber = new JTextField("HI! ʘ‿ʘ");
		phoneNumber.setEditable(false);
		phoneNumber.setFont(new Font("JeBrains Mono", Font.BOLD, fontSize));
		phoneNumber.setSize(220, topLineSize);
		phoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		phoneNumber.setLocation(25, 25);
		add(phoneNumber);

		trash = new JLabel(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
		trash.setLocation(phoneNumber.getWidth() + 30, 25);
		trash.setSize(topLineSize, topLineSize);
		trash.addMouseListener(handler);
		trash.addMouseMotionListener(handler);
		add(trash);

		label = new JLabel[12];
		icons = imgFormat.generateIcons(sizeImg);

		for (int i = 0; i < label.length; i++) {

			JLabel l = new JLabel(icons[i]);
			l.setSize(size, size);

			if (i == 0) {
				// 1
				l.setLocation(25, phoneNumber.getY() + phoneNumber.getHeight() + separation);
			} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
				// 2 3 5 6 8 9 Zero Pad
				l.setLocation(label[i - 1].getX() + size + separation, label[i - 1].getY());
			} else {
				// 4 7 Asterisk
				l.setLocation(25, label[i - 3].getY() + size + separation);
			}
			l.addMouseListener(handler);
			l.addMouseMotionListener(handler);
			label[i] = l;
		}

		for (int i = 0; i < label.length; i++) {
			this.add(label[i]);
		}

		addComponentListener(new ComponentAdapter() {

			public void componentResized(ComponentEvent e) {

				if (historyX == 0) {
					historyX = getContentPane().getWidth();
				}

				if (getContentPane().getWidth() != historyX) {

					size = (getContentPane().getWidth() - 75) / 3;
					sizeImg = ((getContentPane().getWidth() - 75) / 3) - 10;
					resizeIcons();
					resetPosition();

					phoneNumber.setSize(getWidth() - 120, topLineSize);

					trash.setLocation(phoneNumber.getWidth() + 30, 25);
					historyX = getContentPane().getWidth();
					setSize(new Dimension(getWidth(), label[11].getY() + size + 50));
					revalidate();
					repaint();
				}
			}
		});
		addKeyListener(this);
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {

			if (e.getSource() == trash) {
				phoneNumber.setText("CLEAN! ♥‿♥");

				try {
					icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, 13, Color.GREEN, icons);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				selectedLabel = 999;
				resetPosition();
				isAnySet = false;
			}

			for (int i = 0; i < label.length; i++) {
				if (e.getSource().equals(label[i])) {
					try {
						if (phoneNumber.getText().equals("CLEAN! ♥‿♥") || phoneNumber.getText().equals("HI! ʘ‿ʘ")) {
							phoneNumber.setText("");
						}
						selectedLabel = 999;
						resizeIcons();
						resetPosition();
						label[i].setIcon(imgFormat.colorizeIcon(sizeImg+10, i, Color.green));
						selectedLabel = i;
						phoneNumber.setText(phoneNumber.getText() + getIcoName(i));
						isAnySet = true;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {

			for (int i = 0; i < label.length; i++) {
				if (i != selectedLabel) {
					if (e.getSource().equals(label[i])) {

						try {
							label[i].setIcon(imgFormat.colorizeIcon(sizeImg, i, Color.BLACK));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {

			for (int i = 0; i < label.length; i++) {
				if (i != selectedLabel) {
					try {
						label[i].setIcon(imgFormat.colorizeIcon(sizeImg, i, Color.LIGHT_GRAY));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private String getIcoName(int i) {
		String iReturn = "";

		if (i >= 0 && i < 9) {
			iReturn = String.format("%d", i + 1);
		} else {
			switch (i) {
				case 9:
					iReturn = "*";
					break;
				case 10:
					iReturn = String.format("%d", 0);
					break;
				case 11:
					iReturn = "#";
					break;
			}
		}
		return iReturn;
	}

	private int converNumToIndex(int i) {
		int iReturn = 0;

		if (i >= 1 && i <= 9) {
			iReturn = i - 1;
		} else if (i == 0) {
			iReturn = 10;
		}

		return iReturn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timeColor && !isAnySet) {
			contAnimation++;

			if (contAnimation > 20 && contAnimation <= 33) {
				int j = (int) (Math.random() * 7);

				if (contAnimation <= 32) {
					try {
						label[contAnimation - 21]
								.setIcon(imgFormat.colorizeIcon(sizeImg + 10, contAnimation - 21, colors[j]));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (contAnimation > 21 && contAnimation <= 33) {
					try {
						label[contAnimation - 22]
								.setIcon(imgFormat.colorizeIcon(sizeImg, contAnimation - 22, Color.LIGHT_GRAY));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else if (contAnimation > 33) {
				contAnimation = 0;
			}
		}

		if (e.getSource() == timeTrash) {
			contTrash++;
			if (contTrash % 2 == 0) {
				try {
					trash.setIcon(imgFormat.colorizeIcon(topLineSize, 12, Color.red));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					trash.setIcon(imgFormat.colorizeIcon(topLineImgSize, 12, Color.LIGHT_GRAY));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private void resizeIcons() {
		try {
			icons = imgFormat.colorizeIcons(sizeImg, Color.LIGHT_GRAY, selectedLabel, Color.GREEN, icons);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void resetPosition() {
		for (int i = 0; i < label.length; i++) {
			label[i].setIcon(icons[i]);
			label[i].setSize(size, size);
			if (i == 0) {
				// 1
				label[i].setLocation(25, phoneNumber.getY() + phoneNumber.getHeight() + separation);
			} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
				// 2 3 5 6 8 9 Zero Pad
				label[i].setLocation(label[i - 1].getX() + size + separation, label[i - 1].getY());
			} else {
				// 4 7 Asterisk
				label[i].setLocation(25, label[i - 3].getY() + size + separation);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char keyValue = e.getKeyChar();
		int keyIndex;
		boolean validKey = false;

		if (keyValue >= '0' && keyValue <= '9') {
			validKey = true;
		} else if (keyValue == '*') {
			validKey = true;
		} else if (keyValue == '#') {
			validKey = true;
		}

		if (validKey) {
			if (phoneNumber.getText().equals("CLEAN! ♥‿♥") || phoneNumber.getText().equals("HI! ʘ‿ʘ")) {
				phoneNumber.setText("");
			}

			if (keyValue == '*') {
				keyIndex = 9;
			} else if (keyValue == '#') {
				keyIndex = 11;
			} else {
				keyIndex = Character.getNumericValue(keyValue);
				keyIndex = converNumToIndex(keyIndex);
			}

			try {
				selectedLabel = 999;
				resizeIcons();
				resetPosition();
				label[keyIndex].setIcon(imgFormat.colorizeIcon(sizeImg+10, keyIndex, Color.green));
				selectedLabel = keyIndex;
				phoneNumber.setText(phoneNumber.getText() + getIcoName(keyIndex));
				isAnySet = true;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			validKey = false;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
