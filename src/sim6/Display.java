package sim6;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display extends Canvas {
		
	public Display(int width, int height, String title, Simulation simulation) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension (width, height));
		frame.setMinimumSize(new Dimension (width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // Will create problems if true
		frame.setLocationRelativeTo(null);	//Sets application to center 
		frame.add(simulation); //adds the simulation class and adds to the frame
		frame.setVisible(true); //Sets the frame to visible
		simulation.start();	// starts the application
	}
	
	
}
