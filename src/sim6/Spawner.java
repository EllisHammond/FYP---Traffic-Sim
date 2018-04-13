package sim6;

import sim6.Handler;
import sim6.SimInfo;



public class Spawner {
	
	private int spawnerCount = 0;
	
	private Handler handler;
	private SimInfo siminfo;
	
	public Spawner(Handler handler,SimInfo siminfo) {
		this.handler = handler;
		this.siminfo = siminfo;
		//Creates the road object
		handler.addObject(new Road(Simulation.WIDTH, Simulation.HEIGHT, ID.Roads));
		//Creates the traffic light object 
		handler.addObject(new TrafficLight(340, 250, ID.TrafficLight));
		handler.addObject(new TrafficLight(420, 290, ID.TrafficLight));
		handler.addObject(new TrafficLight(400, 240, ID.TrafficLight));
		handler.addObject(new TrafficLight(350, 325, ID.TrafficLight));
		handler.addObject(new QuadrantPosition(0, 0, ID.QuadrantPosition));

	}
	
	/**
	 * Creates a loop that spawns cars at a constant rate in a random direction
	 * The 4 car objects added represent the number of spawn points available
	 */
	public void tick() {
		spawnerCount++;
		
		
		if(spawnerCount >= 50) {
			spawnerCount = 0;
			siminfo.setVehicleCounter(siminfo.getVehicleCounter() + 4);
			handler.addObject(new Car(360, 640, ID.Car, handler)); // Direction heading South spawn
			handler.addObject(new Car(840, 300, ID.Car, handler ));	// Direction heading West spawn
			handler.addObject(new Car(400, -40, ID.Car, handler));	//Direction heading North spawn
			handler.addObject(new Car(-40, 260, ID.Car, handler));	//Direction heading East spawn
		}
		}
	}

