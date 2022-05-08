package exercise;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import org.w3c.dom.events.MouseEvent;

public class Events extends JDialog {
	public int size = 45;
	public int sizeImg = 40;
	public int separation = 25;
	public int historyX = 0;

	ImgFormat imgFormat = new ImgFormat();
	ImageIcon[] icons;
	public JButton[] button;
	int buttonPush;

	public Events() {

		setLayout(null);
		setFocusable(true);
		MouseHandler handler = new MouseHandler();
		icons = imgFormat.generateIcons(sizeImg);

		button = new JButton[12];

		for (int i = 0; i < button.length; i++) {
			JButton b = new JButton(icons[i]);
			b.setSize(size, size);
			// b.setOpaque(false);
			b.setContentAreaFilled(false);

			b.setBorderPainted(false);

			if (i == 0) {
				// 1
				b.setLocation(25, 50);
				b.setBorder(new BevelBorder(2, Color.red, Color.BLACK));

			} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
				// 2 3 5 6 8 9 Zero Pad
				b.setLocation(button[i - 1].getX() + size + separation, button[i - 1].getY());

			} else {
				// 4 7 Asterisk
				b.setLocation(25, button[i - 3].getY() + size + separation);

			}
			b.addMouseListener(handler);
			b.addMouseMotionListener(handler);
			button[i] = b;
		}

		for (int i = 0; i < button.length; i++) {
			this.add(button[i]);
		}

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {

				if (historyX == 0) {
					historyX = getContentPane().getWidth();

				}

				if (getContentPane().getWidth() - historyX > 20
						|| getContentPane().getWidth() - historyX < -20) {

					size = (getContentPane().getWidth() - 100) / 3;
					sizeImg = ((getContentPane().getWidth() - 100) / 3) - 5;

					icons = imgFormat.generateIcons(sizeImg);

					for (int i = 0; i < button.length; i++) {
						button[i].setIcon(icons[i]);
						button[i].setSize(size, size);
						if (i == 0) {
							// 1
							button[i].setLocation(25, 50);

						} else if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 10 || i == 11) {
							// 2 3 5 6 8 9 Zero Pad
							button[i].setLocation(button[i - 1].getX() + size + separation, button[i - 1].getY());

						} else {
							// 4 7 Asterisk
							button[i].setLocation(25, button[i - 3].getY() + size + separation);

						}
					}

					historyX = getContentPane().getWidth();

					setSize(getContentPane().getWidth() + 5, (getContentPane().getWidth() + 250));

					revalidate();

					repaint();
				}

			}

		});

	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {

		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {

		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {

			for (int i = 0; i < button.length; i++) {
				if (e.getSource().equals(button[i])) {
					for (int j = 0; j < button.length; j++) {
						ImageIcon[] icons=imgFormat.generateIcons(sizeImg);
						button[j].setIcon(icons[j]);
						revalidate();
						repaint();

					}
					button[i].setIcon(imgFormat.selectIcons(i, sizeImg, "Green"));
					buttonPush = i;
				}
			}

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			for (int i = 0; i < button.length; i++) {
				if (i != buttonPush) {
					if (e.getSource().equals(button[i])) {
						button[i].setIcon(imgFormat.selectIcons(i, sizeImg, "Black"));
					}
				}
			}
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {

			for (int i = 0; i < button.length; i++) {
				if (i != buttonPush) {
					if (e.getSource().equals(button[i])) {
						button[i].setIcon(imgFormat.selectIcons(i, sizeImg, "Grey"));

					}
				}
			}
		}

	}

}
