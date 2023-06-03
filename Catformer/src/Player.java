import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player implements KeyListener {
	private int x, y;
	private double vx, vy;
	private double a;
	private int width, height;
	private boolean jumping;
	private Image Sprite;
	private AffineTransform tx;
	public Player(String fileName) {
		x = 0;
		y = 462;
		vx = 0;
		vy = 0;
		a = -0.15;
		width = 64;
		height = 64;
		jumping = false;
		Sprite = getImage(fileName);
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
	}
	public void checkGroundCollision() {
		if(y+height >= 526) {
			vy = 0;
			//System.out.println("collision detected");
			y = 462;
			jumping = false;
		}
	}
	
	public void die() {
		x = 0;
		y = 462;
	}
	public void changeAnimation(String fileName) {
		Sprite = getImage(fileName);
	}
	public void move() {
		x += vx;
		y -= vy;
		vy += a;
		tx.setToTranslation(x, y);
		tx.scale(2, 2);
	}
	

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		move();
		g2.drawImage(Sprite, tx, null);
		//shows hitbox as visible
		//g2.drawRect(x, y, width, height);
	} 
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getVx() {
		return vx;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	public double getVy() {
		return vy;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}