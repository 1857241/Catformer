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
	public void update() {
		chocola.move();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
		
	}
	public static void main(String[] args){
	  	Driver d = new Driver();
	}
	
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Catformer");
		f.setSize(800,600);
		f.setResizable(false);
		f.addKeyListener(this);
		
		
		
		chocola = new Player("/imgs/chocola.png");
	  	
	  	f.add(this);
	  	Timer t = new Timer(16, this);
	  	t.start();
	  	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	f.setVisible(true);
	  	
	  	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 68) {
			chocola.setVx(2);
		}
		
	}
	@Override
	 public void keyReleased(KeyEvent e) {
        // Get the released key code
        int keyCode = e.getKeyCode();
        if (keyCode == 68) {
            chocola.setVx(0);
        }
    }
  
}