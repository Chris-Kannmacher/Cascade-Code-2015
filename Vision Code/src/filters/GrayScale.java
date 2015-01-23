package filters;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/*
 * Converts a standard BGR image to grayscale
 */
public class GrayScale extends Colorspace {
	public GrayScale(){
		super(Imgproc.COLOR_BGR2GRAY); // should do a smart method other than assuming source color space is BGR, but it works for now
	}
}
