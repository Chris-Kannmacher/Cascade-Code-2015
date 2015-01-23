package filters;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/*
 * Converts from one colorspace to another
 */
public class Colorspace implements Filter {
	private int colorCode;
	
	public Colorspace(int colorCode){
		this.colorCode = colorCode;
	}
	
	public Mat apply(Mat source){
		Mat result = new Mat();
		
		Imgproc.cvtColor(source, result, colorCode);
		
		return result;
	}
}
