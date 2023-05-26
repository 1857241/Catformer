import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener{
	
	public static Player chocola;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		chocola.paint(g);
	}
	public static void main(String[] args){
		chocola = new Player();
	  	new Driver();
	}
	
	public Driver() {
		JFrame frame = new JFrame("Nekopara");
		frame.setSize(800,600);
		frame.add(this);
		frame.addKeyListener(this);
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	frame.setTitle("Catformer");
	  	Timer t = new Timer(16, this);
	  	t.start();
	  	frame.setVisible(true);
	  	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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