package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import core.Camera;
import core.MatIO;

/*
 * This class filters and renders an image from a camera
 */
public class ImageViewer extends JComponent {
	private Camera camera;
	
	/*
	 * Creates an image viewer that pulls frames from a Camera
	 */
	public ImageViewer(Camera camera){
		this.camera = camera;

		this.setPreferredSize(camera.getResolution());
	}
	
	public void paintComponent(Graphics g){
		BufferedImage image = MatIO.toImage(camera.getFrame());
		
		g.drawImage(image, 0, 0, null);
	}
	
}
