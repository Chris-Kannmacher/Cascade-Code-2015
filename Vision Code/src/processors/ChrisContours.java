package processors;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class ChrisContours implements Processor{

	private Mat hierarchy = new Mat();
	private List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
	
	@Override
	public Mat process(Mat source, Graphics g) {
		
		Imgproc.findContours(source, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
		Imgproc.drawContours(source, contours, -1, new Scalar(0, 255, 0));
		
		return source;
	}
	
}
