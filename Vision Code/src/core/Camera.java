package core;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import filters.Filter;

/*
 * Represents a camera feed that can have filters applied.
 */
public class Camera {
	private VideoCapture capture;
	private ArrayList<Filter> filters;
	private Dimension resolution;
	
	/*
	 * By default, Camera opens feed from default video camera
	 */
	public Camera(){
		this(0);
	}
	
	public Camera(int id){
		capture = new VideoCapture(id);
		initalize();
		updateResolution();
	}
	
	/*
	 * Create Camera feed from url or path, usually from url though
	 */
	public Camera(String url){
		capture = new VideoCapture(url);
		initalize();
		updateResolution();
	}
	
	/*
	 * Performs extra initialization
	 */
	private void initalize() {
		this.filters = new ArrayList<Filter>();		
		this.resolution = new Dimension();
	}

	/*
	 * Reads in a frame from an image source and uses it to determine the resolution of the camera, 
	 * assuming each image frame has the same resolution
	 */
	public void updateResolution(){
		Mat mat = this.getFrame();
		
		this.resolution = new Dimension(mat.cols(), mat.rows());
	}
	
	/*
	 * Get's camera's resolution
	 */
	public Dimension getResolution() { return this.resolution; }
	
	/*
	 * Get's image frame from camera with filters applied
	 */
	public Mat getFrame(){
		Mat image = new Mat();
		capture.read(image);
		
		return this.applyFilters(image);
	}
	
	/*
	 * Add a filter that will be applied when image is read from capture source
	 */
	 public void addFilter(Filter... filterArgs){
		 for (Filter filter : filterArgs){
			 this.filters.add(filter);
		 }
	 }
	 
	 /*
	  * Apply filters as they are stored within the ArrayList
	  */
	 private Mat applyFilters(Mat image){
		 
		 for (Filter filter: filters){
			image = filter.apply(image);
		 } 
		 return image;
	 }
}
