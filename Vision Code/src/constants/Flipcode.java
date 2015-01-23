package constants;

/*
 * Stores constants used by OpenCV to determine how to flip a mat when using the cv::flip function
 */
public enum Flipcode {
	X_AXIS(0),
	Y_AXIS(1),
	BOTH_AXES(-1);

	public int value;
	
	private Flipcode(int value){
		this.value = value;
	}
}