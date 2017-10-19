package painterincomplete;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends Stamp {
	//private double rad; //rad size
	//double pi = Math.PI; //creates variable with value of PI 
	private Ellipse2D shape;

	/**
	 * sets shape to new ellipse shape
	 */
	public Circle(){
		shape = new Ellipse2D.Float();
	}
	
	/**
	 * renders ellipse shape (including x,y, width, and height) and get color and fill
	 */
	@Override
	public void render(Graphics2D g) { //creates shape Circle to be called 
		shape.setFrame(getX(), getY(), this.getSize().width, this.getSize().height); //gets x, y location of mouse and the width and height
		g.setColor(getColor());
		g.fill(shape);
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * @return stamp of type circle
	 */
	public Stamp newStamp() {
		return new Circle();
		// TODO Auto-generated method stub
	}
	

}
