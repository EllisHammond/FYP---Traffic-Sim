package sim6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Road extends Objects {

	public Road(int x, int y, ID id) {
		super(x, y, id);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 0, 0);
	}

	public void tick() {
		velX = 0;
		velY = 0;
	}

	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 250, 800, 80);
		for(int a = 0; a < 30; a++) {
			g.setColor(Color.white);
			g.drawLine(0, 290, 800, 290);
		}
			
		g.setColor(Color.black);
		g.fillRect(350, 0, 80, 600);
		for(int b = 0; b < 20; b++) {
			g.setColor(Color.white);
			g.drawLine(390, 0, 390, 600);
		}
		
		g.setColor(Color.black);
		g.fillRect(350, 250, 80, 80);
	}

}