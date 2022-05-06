package exercise;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Events extends JFrame implements KeyListener{
	JButton btn1;
	JButton btn2;
	JLabel lblKey;
	String setPressed="";
	String setTyped="";
	
	public Events(){
		super("Mouse Control");
		setLayout(null);
		setFocusable(true);
		MouseHandler handler = new MouseHandler();

		btn1=new JButton();
		btn1.setSize(125, 50);
		btn1.setLocation(125, 50);
		btn1.addMouseListener(handler);
		btn1.addMouseMotionListener(handler);
		btn1.setBackground(Color.DARK_GRAY);
		add(btn1);
				
		btn2=new JButton();
		btn2.setSize(125, 50);
		btn2.setLocation(250, 50);
		btn2.addMouseListener(handler);
		btn2.addMouseMotionListener(handler);
		btn2.setBackground(Color.DARK_GRAY);
		add(btn2);

		lblKey= new JLabel("Key");
		lblKey.setSize(250, 50);
		lblKey.setLocation(125,150);
		add(lblKey);

		this.getContentPane().addMouseListener(handler);
		this.getContentPane().addMouseMotionListener(handler);
		addKeyListener(this);
		
	}
	
	private class MouseHandler extends MouseAdapter{
		
		@Override
		public void mouseMoved(MouseEvent e){
			Events.this.setTitle(String.format("Mouse Control - (X:%d,Y:%d)", e.getX(),e.getY()));
		}

		@Override
		public void mouseExited(MouseEvent e){
			Events.this.setTitle("Mouse Control");
		}

		@Override
		public void mousePressed(MouseEvent e){
			System.err.println(e.getButton());
			if(e.getButton()==1){
				btn1.setBackground(Color.red);
			}
			if(e.getButton()==3){
				btn2.setBackground(Color.red);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e){
			btn1.setBackground(Color.DARK_GRAY);
			btn2.setBackground(Color.DARK_GRAY);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.err.println(e.getKeyCode());
		setPressed=e.getKeyCode()+"";
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.err.println(e.getKeyChar());
		setTyped=e.getKeyChar()+"";
		
		
		lblKey.setText(String.format("Key - Unicode:  %s  Code:  %s",setTyped,setPressed));
	}






}
