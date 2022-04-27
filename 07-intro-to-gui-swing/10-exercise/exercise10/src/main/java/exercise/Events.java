package exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Events extends JFrame implements ActionListener, KeyListener {
	JLabel bomb;
	JLabel setBomb;
	JLabel a;
	JLabel ship;
	JLabel lost;

	JButton leftButton;
	JButton rightButton;

	Timer timer;

	Boolean lose = false;

	int cont = 0;
	int dropBombs = 9;
	int indexBomb = 0;
	int numBombs = 0;
	int xPosition = 0;
	int xPositionHistory = 0;

	int keyLeft;
	int keyRight;

	ArrayList<JLabel> bombs = new ArrayList<JLabel>();

	// ImageIcon imageBomb = new ImageIcon("images\\red.png");
	// ImageIcon imageShip = new ImageIcon("images\\red.png");

	// Si quieres ver las hitbox descomenta estos y comenta los de arriba
	
	ImageIcon imageBomb = new ImageIcon("images\\bomb.png");
	ImageIcon imageShip = new ImageIcon("images\\ship.png");


	public Events() {
		super("Dodge the Bombs");

		this.setLayout(null);
		setFocusable(true);

		timer = new Timer(100, this);
		timer.start();

		ship = new JLabel(imageShip);
		ship.setSize(55, 95);
		ship.setLocation(200, 400);
		add(ship);

		lost = new JLabel("", 0);
		lost.setFont(new Font("Arial", Font.BOLD, 40));
		lost.setForeground(new Color(255, 0, 0));
		lost.setSize(500, 100);
		lost.setLocation(0, 500);
		add(lost);

		leftButton = new JButton("Left");
		leftButton.setSize(250, 50);
		leftButton.setLocation(0, 600);
		leftButton.addActionListener(this);
		add(leftButton);

		rightButton = new JButton("Right");
		rightButton.setSize(250, 50);
		rightButton.setLocation(250, 600);
		rightButton.addActionListener(this);
		add(rightButton);

		addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!lose) {

			Point point = new Point();

			if (e.getSource() == leftButton || keyLeft == 1) {
				point = ship.getLocation();
				if (point.getX() > 0) {
					point.x += -20;
				}
				ship.setLocation(point);
			}

			if (e.getSource() == rightButton || keyRight == 1) {
				point = ship.getLocation();
				if (point.getX() < 445) {
					point.x += +20;
				}else {
					point.x = 445;
				}
				ship.setLocation(point);
			}

			keyLeft = 0;
			keyRight = 0;

			if (e.getSource() == timer) {
				if (cont != 30) {
					cont++;
				}

				dropBombs++;

				if (dropBombs == 10) {

					this.bomb = new JLabel(imageBomb);
					this.bomb.setSize(85, 85);

					if (numBombs > 1) {
						do {

							xPosition = (int) (Math.random() * 405 + 0);

						} while (xPosition > xPositionHistory - 50 && xPosition < xPositionHistory + 50);

					} else {
						xPosition = (int) (Math.random() * 405 + 0);
					}

					xPositionHistory = xPosition;
					this.bomb.setLocation(xPosition, 0);
					this.bombs.add(bomb);
					add(bombs.get(indexBomb));

					dropBombs = 0;
					this.repaint();

					indexBomb++;

					if (indexBomb > 1) {
						numBombs++;
					}

				} else {

					for (int i = 0; i <= numBombs; i++) {

						point = bombs.get(i).getLocation();
						point.y += cont;
						((JLabel) bombs.get(i)).setLocation(point);

						if (bombs.get(i).getLocation().y > 400) {
							this.remove(bombs.get(i));
							bombs.remove(i);
							numBombs--;
							indexBomb--;

						} else {

							if (ship.getBounds().intersects(((JLabel) bombs.get(i)).getBounds())) {
								lost.setText("You Lose!");
								lose = true;
							}
						}
					}
					this.revalidate();
					this.repaint();
				}
			}
		} else {

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keyLeft = 1;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keyRight = 1;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
