package processors;

import java.awt.Graphics;

import org.opencv.core.Mat;

/*
 * A Processor is a class that does not filter an image, but instead takes a filtered image and 
 * derrives useful information out of it.  It can draw areas of note and other things on the window
 * that controls it, and uses a [INSERT PROCESSOR INTERFACE HERE] class to send useful data values
 * to a special panel in a Window.
 * 
 * It also is given a [INSERT ROBOT COMMUNICATION CLASS HERE] to send data to the robot
 */
public interface Processor {

	public Mat process(Mat source, Graphics g);
}
