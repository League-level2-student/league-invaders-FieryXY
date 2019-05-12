import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	//Declare Timer
	Timer frameDraw;
	
	//Initialize Rocketship
	Rocketship rocket = new Rocketship(250, 600, 50, 50);
	
	//Initialize possible states
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	//Maintains the current state
	int currentState = MENU;
	
	//Initializes different fonts
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font menuMainFont = new Font("Arial", Font.PLAIN, 20);
	
	GamePanel() {
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
	}
	
	//Overrides parent function to paint on the panel
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	//Update and Draw functions for each state.
	void updateMenuState() {
		
		
	}
	void drawMenuState(Graphics g) {
		//Background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		//Text - Title
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		
		//Text - Enter to Play
		g.setFont(menuMainFont);
		g.drawString("Press ENTER to start", 150, 300);
		
		//Text-Space for Help
		g.drawString("Press SPACE for instructions", 130, 400);
	}
	void updateGameState() {
		
		
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		//rocket.draw(g);
		g.setColor(Color.BLUE);
		g.fillRect(rocket.x, rocket.y, rocket.width, rocket.height);
	}
	void updateEndState() {
		
		
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		//Text - Title
				g.setFont(titleFont);
				g.setColor(Color.YELLOW);
				g.drawString("GAME OVER", 100, 100);
				
				//Text - Enter to Play
				g.setFont(menuMainFont);
				g.drawString("You killed enemies", 150, 300);
				
				//Text-Space for Help
				g.drawString("Press ENTER to restart", 130, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		this.repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
