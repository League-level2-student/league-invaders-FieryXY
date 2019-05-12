package invaders;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocketship;
	ArrayList<Projectile> projectileArr = new ArrayList<Projectile>();
	ArrayList<Alien> alienArr = new ArrayList<Alien>();
	Random random = new Random();
	
	ObjectManager(Rocketship rocket) {
		this.rocketship = rocket;
	}
	
	void addProjectile(Projectile p) {
		projectileArr.add(p);
	}
	
	void addAlien() {
		alienArr.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	void update() {
		for(Alien a : alienArr) {
			a.update();
			if(a.y == LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		for(Projectile p : projectileArr) {
			p.update();
			if(p.y == 0) {
				p.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}
	void draw(Graphics g) {
		rocketship.draw(g);
		for(Alien a : alienArr) {
			a.draw(g);
		}
		for(Projectile p : projectileArr) {
			p.draw(g);
		}
	}
	
	void purgeObjects() {
		for(int i = 0; i < alienArr.size(); i++) {
			if(alienArr.get(i).isActive == false) {
				alienArr.remove(alienArr.get(i));
			}
		}
		for(int i = 0; i < projectileArr.size(); i++) {
			if(projectileArr.get(i).isActive == false) {
				projectileArr.remove(projectileArr.get(i));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
		
	}
	
	void checkCollision() {
		for(Alien alien : alienArr) {
			if(rocketship.collisionBox.intersects(alien.collisionBox)) {
				alien.isActive = false;
				rocketship.isActive = false;
			}
			for(Projectile proj : projectileArr) {
				if(proj.collisionBox.intersects(alien.collisionBox)) {
					proj.isActive = false;
					alien.isActive = false;
				}
			}
		}
		
	}
}
