package invaders;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gPanel;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	LeagueInvaders(JFrame theFrame, GamePanel aPanel) {
	
		this.frame = theFrame;
		this.gPanel = aPanel;
		
	}
	
	public static void main(String[] args) {
		LeagueInvaders thing = new LeagueInvaders(new JFrame(), new GamePanel());
		thing.setup();
		
	}
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(gPanel);
		frame.addKeyListener(gPanel);
		frame.setVisible(true);
		

		
	}
}
