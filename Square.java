package painterincomplete;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class Square extends Stamp{
	private Rectangle shape;
	
	/**
	 * sets shape to new rectangular object
	 */
	public Square(){
		shape = new Rectangle();
	}
	
	@Override
	/**
	 * renders shape and collects: x, y, size, dimensions, location, and color
	 * @param Graphics2d g reference to a graphics2D object
	 */
	public void render(Graphics2D g) { //creates shape square to be called 
		float x = getX(); //gets x location of where mouse clicks
		float y = getY(); //gets y location of where mouse clicks
		Dimension d = super.getSize(); //gets dimensions
		shape.setSize(d); 
		shape.setLocation(Math.round(x), Math.round(y)); 
		g.setColor(getColor());//sets the color to getColor() which is a randomly assigned hex color
		g.fill(shape); 
		
	}

	@Override
	/**
	 * @return stamp of type square
	 */
	public Stamp newStamp() { 
		return new Square(); 
		// TODO Auto-generated method stub
	}

}
