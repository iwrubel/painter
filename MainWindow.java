package painterincomplete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

	private DrawingPane drawing;
	
	/**
	 * Setup the main Window
	 * @param title The title of the window
	 */
	public MainWindow( String title ) {
		super( title );
	
		JPanel toolbar = setupToolbar();
		drawing = new DrawingPane();	

		setLayout( new BorderLayout() );
		add( toolbar, BorderLayout.WEST);
		add( drawing, BorderLayout.CENTER);
		
	}
	
	public JPanel setupToolbar() {
		JPanel toolbar = new JPanel();
		toolbar.setLayout( new BoxLayout(toolbar, BoxLayout.Y_AXIS));
		
		// The stamps to use for the buttons
		/*
		
		 */
		Stamp[] stamps = {new Square(), new Circle(), new Triangle()};
	
		toolbar.add(Box.createGlue());
		for( Stamp s : stamps ){
			Tool t = new Tool( s );
			t.setPreferredSize(new Dimension(60,60));
			t.addActionListener( new BtnListener() );
			toolbar.add( t );
		}
		toolbar.add(Box.createGlue());
		return toolbar;		
	}
	
	public class BtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Tool t = (Tool) e.getSource();		
			drawing.setSelected(t.getStamp().newStamp());
		}
	}
	
}
