package sim6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import sim6.TrafficLight.lightColor;



public class Car extends Objects {

	Handler handler;
	Random r = new Random();
	/**
	*This is the creation of the enumerated type direction with its possible values of 
	* north, east, west, or south. 
	*/
	public enum Direction{N, E, S, W};
	private int vehicleNumber;
	final private int spawnLimit = 1;
	private Direction direction;
	private SimInfo siminfo;
	private lightColor lColor;
	int carCount = 0;
	
	public Car(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		direction = randomDirection();
		this.handler = handler;
		velocity();
		turn();
	}
	
	public Rectangle getBounds() {
		if(velX != 0) {
		return new Rectangle(x, y, 35, 25);
		} else  {
		return new Rectangle(x, y, 25, 35);
		}
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		carCleaner();
	}
	
	private void collision() {
		int collisionA = 0;
		for(int i = 0; i < handler.object.size(); i++) {
			
			Objects tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Car) {
					if(getBounds().intersects(tempObject.getBounds()))
					{
						collisionA++;	
						//This says that if there is a car in front, then stop
						if(collisionA > 1) {
							 x+= velX * -1;	 
							 y+= velY * -1;
					}
				}
		
			}	
		} 
		
		for(int i = 0; i < handler.object.size(); i++) {
			Objects tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.TrafficLight) {
				if(TrafficLight.getLightIndicator() == 2 | TrafficLight.getLightIndicator() == 3 && getBounds().intersects(tempObject.getBounds()))
				{
					collisionA++;	
					if(collisionA > 0 && velX !=0 ) {
						 x+= velX * -1;	 
						 y+= velY * -1;
					} 
				} else if (TrafficLight.getLightIndicator() == 2 | TrafficLight.getLightIndicator2() == 1 && getBounds().intersects(tempObject.getBounds())) {
					collisionA++;	
					if(collisionA > 0 && velY !=0 ) {
						 x+= velX * -1;	 
						 y+= velY * -1;
				}
				
		}
		}
		}
	}

	public void render(Graphics g) {
		
		if(velX != 0) {
			g.setColor(Color.CYAN);
			g.fillRect(x, y, 30, 20);
		} else if(velY != 0){
			
			g.setColor(Color.RED);
			g.fillRect(x, y, 20, 30);
		}
		Graphics2D g2d = (Graphics2D) g;
	
		
		
	}
	/**
	* This method assigns each new vehicle a randomly generated direction using the Math.random function.
	* @return the direction the car is headed 
	*/
	public Direction randomDirection() {
		//int dirIndicator = (int)(Math.random() * (4 - 0) + 1);
			if(x == 400 ) { 
				direction = Direction.N;
				}
			else if(x == -40) {
				direction = Direction.E;
				}
			else if(x == 360) {
				direction = Direction.S;
				}
			else if (x == 840) {
				direction = Direction.W;
			}
			return direction;
			
	}
	
	public void changeDirection() {
		
	}
	
	public void deceleration() {
		int min = 0;
		
	}
	
	private void velocity() {
		switch (direction) {
		case N: velY = 5;
		break;
		case S: velY = -5;
			break;
		case E: velX = 5;
			break;
		case W: velX = -5;
			break;
		}
	}
	
	
	
	
	private int getVelocity() {
		if(velX != 0) {
			return velX; 
		} else {
		return velY;
	}
	}
	
	
	public void carCleaner() {
		if(x >= 850 || x < -50 || y >= 650 || y <= -50) {
			handler.removeObject(this);
		}
	}
	
	public Integer getCarCount() {
	      return carCount;
	    }
}
	
	
	
