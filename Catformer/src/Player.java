import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {
	
	
	private Image Sprite;
	private AffineTransform tx;
	
	private int x, y;
	
	
	public Player() {
		Sprite = getImage("/imgs/chocolaWalking.gif");
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y);
		
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(20, 20);
	}
	public void update() {
		tx.setToTranslation(x, y);
		tx.scale(20, 20);
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
}
