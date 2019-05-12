
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	
	int speed = 0;
	boolean isActive = true;
	
	GameObject(int xPos, int yPos, int w, int h) {
		this.x = xPos;
		this.y = yPos;
		this.width = w;
		this.height = h;
		
	}
}
