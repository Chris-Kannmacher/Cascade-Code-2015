package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import core.Camera;

/*
 * A JFrame that outputs the contents of a camera
 */
public class Window extends JFrame implements ActionListener {
	private Camera camera;
	private ImageViewer viewer;
	private Timer timer;
	
	/*
	 * By default, will open camera with default id of 0
	 */
	public Window(){
		this(new Camera());
	}
	
	/*
	 * Creates a Window with a specified Camera
	 */
	public Window(Camera camera){
		this.camera = camera;
		this.viewer = new ImageViewer(camera);
		this.timer = new Timer(0, (ActionListener) this);
		
		this.add(viewer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		timer.start();
	}

	/*
	 * This method is called as fast as possible by the timer and initiates repainting 
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		this.repaint();
	}
	
}
