package sim6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;





public class TrafficLight extends Objects {
	private Color lColor;	
	private int lightCounter = 0;
	public enum lightColor{G, A, R};
	static int lightIndicator = (int)(Math.random() * (3 - 0) + 1);
	static int lightIndicator2 = (int)(Math.random() * (3 - 0) + 1);
	int thingy = 0;
/**Enumerated type created of the light colors that the traffic light
 * will switch between with delays **/

	public TrafficLight(int x, int y, ID id) {
		super(x, y, id);
		lColor =  lightColorIterator1();
		velX = 0;
		velY = 0;
	}
	
	public Color getlColor() {
	return lColor;
}

public void setlColor(Color lColor) {
	this.lColor = lColor;
}

	public static int getLightIndicator() {
	return lightIndicator;
}
	
	public static int getLightIndicator2() {
		return lightIndicator2;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

	public void tick() {
	
		lightCounter++;
		if(lightCounter >= 100) {
			lightCounter = 0;
			lightIndicator++;
			if(lightIndicator > 3) {
				lightIndicator = 1;
				lightIndicator2 = 1;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Light Counter: " + lightCounter, 100, 200 );
		g.drawString("Light Indicator: " + lightIndicator, 100, 220 );
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.draw(getBounds());
		
		g2d.fillRect(x, y, 20, 20);
		//Timer timer = new Timer();
        //timer.schedule(new TimerTask() {
          //  public void run() {
		  //     }
	     //   }, 0, 5000);
		 g.setColor(lightColorIterator1());  
          g.fillRect(345, 250, 4, 30 );    
          g.fillRect(430, 300, 4, 30);
        		
    
        g.setColor(lightColorIterator2());            
        g.fillRect(400, 245, 30, 4);		
		g.fillRect(350, 330, 30, 4);
      			
	}
	
	public Color lightColorIterator1() {
		
			if(lightIndicator == 1 | lightIndicator2 == 3) { 
				lColor = Color.GREEN;
				}
			else if(lightIndicator == 2 | lightIndicator2 == 2) {
				lColor = Color.YELLOW;
			} else if (lightIndicator == 3 | lightIndicator2 == 1){
				lColor = Color.RED;
			}
			
			return lColor;
			
			
	}
	
	public Color lightColorIterator2() {
		
		if(lightIndicator == 3 ) { 
			lColor = Color.GREEN;
			}
		else if(lightIndicator == 2) {
			lColor = Color.YELLOW;
		} else if (lightIndicator == 1){
			lColor = Color.RED;
		}
		
		return lColor;
		
		
}
	

			
	
	

}
