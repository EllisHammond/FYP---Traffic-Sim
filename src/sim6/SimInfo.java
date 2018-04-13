package sim6;

import java.awt.Color;
import java.awt.Graphics;

public class SimInfo {
	
	private Handler handler;
	private Car car;
	private int count = 0;
	private int vehicleCounter = 0;
	public void tick() {
		count++;
	}

//	public int carCount() {
		//for(int a = 0; a = handler.object.size(); a++) {
		//	return a;
//		}
	//}
	public void render(Graphics g) {
		g.setColor(new Color (255,250,205));
		g.fillRect(15,15, 300, 52);
		g.setColor(Color.darkGray);
		g.drawRect(15, 15, 300, 52);
		
		g.drawString("Vehicle Count: " +  vehicleCounter, 18 , 30);
	}
	
	public void vehicleCount(int vehicleCounter) {
		this.vehicleCounter = vehicleCounter;
	}
	
	public int getVehicleCounter() {
		return vehicleCounter;
	}

	public void setVehicleCounter(int vehicleCounter) {
		this.vehicleCounter = vehicleCounter;
	}

	public void count(int count) {
		this.count = count;
	}
	
	
	public int getcount() {
		return count;
	}

	public void setcount(int count) {
		this.count = count;
	}



}