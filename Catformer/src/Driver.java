import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener{
	
	public static Player chocola;
	public static Background kitchen1;
	public static ArrayList<Mouse> mice = new ArrayList<>();
	public static Mouse m1;
	Audio bgMusic = new Audio("catwork.wav", true);
	Audio secretBgMusic = new Audio("seventeen.wav", true);
	String lives = "Lives: 3";
	Font comicSans = new Font("Comic Sans MS", 1, 50);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		kitchen1.paint(g);
		g.setFont(comicSans);
		g.setColor(Color.black);
		g.drawString(lives, 10, 50);
		chocola.paint(g);
		m1.paint(g);
		
	}
	public void update() {
		chocola.move();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
		chocola.checkGroundCollision();
		//System.out.println("Frame updated");
		
	}
	public static void main(String[] args){
	  	Driver d = new Driver();
	}
	
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Catformer");
		f.setSize(800, 600);
		f.setResizable(false);
		f.addKeyListener(this);
		int i = (int) (Math.random() * 50);
		/*
		 * testing if randomizer works
		while(i != 0) {
			System.out.println(i);
			i = (int) (Math.random() * 50);
		}
		*/
		
		if(i == 0) {
			System.out.print(i + ", Super is playing!");
			secretBgMusic.play();
		}
		else {
			System.out.print(i + ", Catwork is playing!");
			bgMusic.play();
		}
		chocola = new Player("/imgs/chocolaUpdated.png");
		kitchen1 = new Background("/imgs/kitchen1.png");
		m1 = new Mouse(300, 462, "/imgs/mouseUpdated.gif");
	  	f.add(this);
	  	Timer t = new Timer(16, this);
	  	t.start();
	  	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	f.setVisible(true);
	  		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case 68:
			chocola.changeAnimation("/imgs/chocolaWalking2.gif");
			chocola.setVx(3);
			break;
		case 65:
			chocola.changeAnimation("/imgs/chocolaWalking2.gif");
			chocola.setVx(-3);
			break;
		case 32:
			chocola.setY(chocola.getY()-200);
			chocola.setVy(2);
			break;
		}
		
		
	}
	@Override
	 public void keyReleased(KeyEvent e) {
        // Get the released key code
        int keyCode = e.getKeyCode();
        switch(keyCode) {
        case 68:
        	chocola.changeAnimation("/imgs/chocolaUpdated.png");
        	chocola.setVx(0);
        	break;
        case 65:
        	chocola.changeAnimation("/imgs/chocolaUpdated.png");
        	chocola.setVx(0);
        	break;
        case 90:
        	System.out.println(chocola.getX() + ", " + chocola.getY());
        	break;
        }   
    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
  
}