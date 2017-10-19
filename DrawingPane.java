package painterincomplete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPane extends JPanel{

	private Stamp selected;
	private ArrayList<Stamp> shapes;
	private Random rand;
	private JPanel jpanel;
	

	public DrawingPane() { //constructor
		jpanel = new JPanel();//start initializing the drawing pane
		shapes = new ArrayList<Stamp>(); //ArrayList of stamps (how to keep track of which is the current stamp)
		rand = new Random(); // random variable to be used for Color
		//attachment of mouse listeners
		Mouser mouser = new Mouser();
		addMouseListener(mouser); 
		addMouseMotionListener(mouser);
		

	}
	
	public boolean setSelected( Stamp toUse ){
		boolean rtn = false;
		if(toUse != null){
			this.selected = toUse;
			rtn = true;
		}
		return rtn;
	}
	
	public Stamp getSelected(){
		return selected;
	}
	
	/**
	 * calls render method for according shapes
	 */
	public void paintComponent(Graphics g){ 
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < shapes.size(); i++){ //call render to create the shape according to ArrayList<Stamp>
			
			shapes.get(i).render(g2);
		}
		
		if( selected != null ){ //if a shape is selected, then render the selected shape
			selected.render(g2);
		}
	}
	
	private class Mouser implements MouseListener, MouseMotionListener{

		private int anchorX, anchorY; //anchor integer variables 
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		/**
		 * determines new shape, rand. color, anchorX /anchorY, location, and size according to mouse pressed
		 */
		public void mousePressed(MouseEvent e) {
			Stamp current = getSelected();
			
			if( current == null ){
				return;
			}
	
			anchorX = e.getX(); //anchor for x coord
			anchorY = e.getY(); //anchor for y coord
			selected.setLocation(anchorX, anchorY); //anchors are set to where mouse pressed location
			selected.setSize(0,0);	
			Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); //randomizes color with 256 hex values
			selected.setColor(c); //sets color to random variable C
		
		}

		@Override
		/**
		 * method adds shapes to array list and sets new shape to current
		 * if current is null, then @return is nothing
		 */
		public void mouseReleased(MouseEvent e) {
			Stamp current = getSelected();
			if (current == null){
				return;
			}
			
			shapes.add(selected); 
			selected = selected.newStamp();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		/**
		 * draws shape in regards to which direction the mouse is dragged
		 */
		public void mouseDragged(MouseEvent e) { 
			Stamp selected = getSelected();
			if( selected == null ){ 
				return;
			}
			int realx;
			int realy;
			if (anchorX < e.getX()){ // if the anchor is less than the location of E, then set new anchor to int variable 
				realx = anchorX;
			}
			else{
				realx = e.getX(); // if its greater then int is equal to current mouse location
			}
			if (anchorY < e.getY()){
				realy = anchorY;
			}
			else{
				realy = e.getY();
			}
			selected.setLocation(realx, realy); // since the int variables have been reset accordingly, set them to location parameters
			selected.setSize(((e.getX())-anchorX), ((e.getY()-anchorY))); 
			repaint(); //calls JPanel method that starts paintComponent() method
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}
	
}
