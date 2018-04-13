package sim6;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

// Main class that holds the game loop and calls in what needs to be called in, in order for the simulation to run
import javax.swing.JFrame;


public class Simulation extends Canvas implements Runnable {
	public static final int WIDTH = 800, HEIGHT =  600;
	
	private Handler handler;
	private SimInfo siminfo;
	private Thread thread;
	private Spawner spawner;
	private boolean running = false;
	
	
	public Simulation() {
		
		handler = new Handler();
		siminfo = new SimInfo();
		spawner = new Spawner(handler, siminfo);
		
		new Display(WIDTH, HEIGHT, "Simulation", this);
		
		/**
		 * Creates a loop that spawns cars at a constant rate in a random direction
		 * The 4 car objects added represent the number of spawn points available
		 */
		
	}
		

	
	//This starts up the thread, although using a single thread is not really recommended it is a relatively simple program
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void run() {
		long lastTime = System.nanoTime(); 
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks; 
		double delta = 0; long timer = System.currentTimeMillis(); 
		int frames = 0; while(running) { long now = System.nanoTime();
		delta += (now - lastTime) / ns; 
		lastTime = now; while(delta >=1) { tick(); delta--; }
		if(running) render(); 
		frames++;
		
		if(System.currentTimeMillis() - timer > 1000) { timer += 1000; 
		System.out.println("FPS: "+ frames); 
		frames = 0; } } stop();
	}
	
	private void tick() {
		handler.tick();
		siminfo.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(150, 200, 125));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		siminfo.render(g);
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var > max) {
			return var =max;
		} else if(var < min) {
			return var = min;
		} else {
			return var;
		}
	}
	public static void main(String[] args) {
		new Simulation();
	}
}
