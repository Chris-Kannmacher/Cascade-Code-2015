package filters;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import constants.Flipcode;

/*
 * Horizontally and / or vertically mirrors an image, perfect for front facing webcams
 */
public class Mirror implements Filter {
	private int flipCode;
	
	/*
	 * Can mirror over either the x, y, or both axes
	 */
	public Mirror(Flipcode code){
		this.flipCode = code.value;
	}
	
	public Mat apply(Mat source){
		Mat result = new Mat();
		
		Core.flip(source, result, flipCode);
		return result;
	}
}
