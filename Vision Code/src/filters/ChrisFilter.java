package filters;

import java.awt.Graphics;

import org.opencv.core.Mat;

public class ChrisFilter implements Filter{
	
	private Mat dst = new Mat();
	Mat threshHold = new Mat();
	private Graphics g;
	
	@Override
	public Mat apply(Mat src) {		
		
		return src;
	}
}
