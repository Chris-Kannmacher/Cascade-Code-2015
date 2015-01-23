package core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

public class MatIO {
	
	/*
	 * Converts a Mat containing color values to a BufferedImage that can be drawn or saved
	 */
	public static BufferedImage toImage(Mat source){
		MatOfByte bytes = new MatOfByte();
		
		Imgcodecs.imencode(".bmp", source, bytes);
		
		byte[] imageArray = bytes.toArray();
		BufferedImage image = null;
		
		try {
			InputStream inStream = new ByteArrayInputStream(imageArray);
			image = ImageIO.read(inStream);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return image;
	}
}
	