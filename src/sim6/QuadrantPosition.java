package sim6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class QuadrantPosition extends Objects  {

	public QuadrantPosition(int x, int y, ID id) {
		super(x, y, id);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		//g.setColor(Color.red);
		//g.fillRect(350, 250, 40, 40);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(350, 250, 40, 40);
	}
}
