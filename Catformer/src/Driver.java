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
	Audio bgMusic = new Audio("titleScreenMusic.wav", true);
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
		bgMusic.play();
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
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case 68: 
			chocola.setVx(2);
			break;
		case 65:
			chocola.setVx(-2);
			break;
		case 87:
			chocola.setVy(-2);
			int pos = chocola.getY();
			System.out.print(chocola.isJumping());
			if(chocola.isJumping() == false) {
				//chocola.setJumping(true);
				System.out.print("YEAH THIS IS IN FACT RUNNING");
				chocola.setVy(-2);
				try {
					Thread.sleep(2000); 
				} 
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				chocola.setVy(2);
				boolean inAir = true;
				while(inAir == true) {
					if(chocola.getY() == pos) {
						chocola.setVy(0);
						inAir = false;
					}
				}
				chocola.setJumping(false);
			}
			break;
		}
		
		
	}
	@Override
	 public void keyReleased(KeyEvent e) {
        // Get the released key code
        int keyCode = e.getKeyCode();
        switch(keyCode) {
        case 68:
        	chocola.setVx(0);
        	break;
        case 65:
        	chocola.setVx(0);
        	break;
        case 90:
        	System.out.println(chocola.getX() + ", " + chocola.getY());
        	break;
        }
        
    }
  
}