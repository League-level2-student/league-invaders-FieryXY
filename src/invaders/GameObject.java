package invaders;

import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	
	int speed = 0;
	boolean isActive = true;
	
	GameObject(int xPos, int yPos, int w, int h) {
		this.x = xPos;
		this.y = yPos;
		this.width = w;
		this.height = h;
		
	}
	
	void update() {
		this.collisionBox.setBounds(this.x, this.y, this.width, this.height);
	}
}
