package sim6;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

		LinkedList<Objects> object = new LinkedList<Objects>();
		
		public void tick() {
			//Iterates through the objects
			for(int i = 0; i < object.size(); i ++) {
				Objects tempObject = object.get(i);
				
				tempObject.tick();
			}
		}
		
		public void render(Graphics g) {
			for(int i = 0; i < object.size(); i++) {
				Objects tempObject = object. get(i);
				
				tempObject.render(g);
			}
		}
		
		public void addObject(Objects object) {
			this.object.add(object);
		}
		
		public void removeObject(Objects object) {
			this.object.remove(object);
		}
}
