import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Mouse {

	private int x;
	private int y; 
	private int width;
	private int height;
	private Image img;
	private AffineTransform tx; 
	
	public Mouse(int x, int y, String fileName) {
		this.x = x;
		this.y = y;
		width = 32*2;
		height = 32*2;
		tx = AffineTransform.getTranslateInstance(x, y);
		img = getImage(fileName);
		init(x, y);
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		//g2.drawRect(x, y+32, 32*2, 32);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}


//	public boolean collided() {
//		if(getX() < chocola.getX() + froggy.getWidth()
//		 && getX()+getWidth() > froggy.getX()
//		 && getY() + getHieght() > froggy.getY()
//		 && getY() < froggy.getY() + froggy.getHeight()) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	// getters and setters

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


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
//	public void move() {
//		tx.translate(vx, 0);
//		x += vx;
//		if(x<0){
//			
//			x=950;
//			tx.setToTranslation(x, y);
//		}
//		if(collided() == true) {
//			if(y > 395) {
//				Driver.die();
//			}
//			else {
//				froggy.setX(getX());
//				froggy.floating = true;
//			}
//			
//		}
//	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Mouse.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}