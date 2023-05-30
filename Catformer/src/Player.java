import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player implements KeyListener {
	private Image Sprite;
	private AffineTransform tx;
	private int x, y;
	private int vx, vy;
	public Player() {
		Sprite = getImage("/imgs/chocolaWalking.gif");
		tx = AffineTransform.getTranslateInstance(0, 600);
		init(0, 600);
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}
	public void update() {
		tx.setToTranslation(x, y);
		tx.scale(2, 2);
	}
	public void move() {
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(Sprite, tx, null);
	} 
	
	protected Image getImage(String path) {
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
