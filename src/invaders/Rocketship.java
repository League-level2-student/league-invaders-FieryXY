package invaders;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	Rocketship(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.speed = 10;
		loadImage("rocket.png");
	}
	
	public void draw(Graphics g) {
		if(gotImage) {
			g.drawImage(image, x, y, width, height, null);
		}
		else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
	}
	
	void loadImage(String imageFile) {
		if(needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			}
			catch(Exception e) {
				
			}
			
		}
		needImage = false;
	}
	
	public void left() {
		super.update();
		if(this.x > width/2) {
			this.x -= speed;
		}
		
	}
	public void right() {
		super.update();
		if(this.x < LeagueInvaders.WIDTH-width) {
			this.x += speed;
		}
	}
	public void up() {
		super.update();
		this.y -= speed;
	}
	public void down() {
		super.update();
		this.y += speed;
	}
	
	public Projectile getProjectile() {
		return new Projectile(this.x+(this.width/2), this.y, 10, 10);
	}
}
