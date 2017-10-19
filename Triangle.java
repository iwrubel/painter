package painterincomplete;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends Stamp {
	private Polygon shape;
	
    /**
     * sets shape to new polygonal object
     */
	public Triangle(){
    	shape = new Polygon();
    }
	

	@Override
	/**
	 * creates shape triangle to be called (includes color, x/y arrays, dimensions, width, and height)
	 */
	public void render(Graphics2D g) {
		int x = (int)getX();
		int y = (int)getY();
		Dimension d = super.getSize(); // gets dimensions of shape
		int width = (int)d.getSize().width; //sets width to the dimensional width
		int height = (int)d.getSize().height; //sets height to the dimensional height
		if (invertedY()){ // checks if Y is less than 0, then swap the coordinates of the Y array
			int[] Ycoord = {y, y + height, y};
			int[] Xcoord = {x, x + (width / 2), x + width};
			g.setColor(getColor());
			g.fillPolygon(Xcoord, Ycoord, 3);
		}
		else{ //checks if Y is greater than 0, then keep the Y coordinates in the array
			int[] Ycoord = {y + height, y, y + height};
			int[] Xcoord = {x, x + (width / 2), x + width};
			g.setColor(getColor());
			g.fillPolygon(Xcoord, Ycoord, 3);
		}
		 
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/**
	 * @return returns stamp of type triangle
	 */
	public Stamp newStamp() { 
		return new Triangle();
		// TODO Auto-generated method stub
	}
}
