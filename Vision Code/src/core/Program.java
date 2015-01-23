package core;

import org.opencv.core.Core;

import constants.Flipcode;
import filters.Canny;
import filters.ChrisFilter;
import filters.Mirror;
import gui.Window;

public class Program {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	/*
	 * Tiny method, BIG FUUUNNN!!!
	 */
	
	public static void main(String[] args) {
		
		Camera camera = new Camera(0);
		Camera camera2 = new Camera(0);
		
		camera.addFilter(new Mirror(Flipcode.Y_AXIS), new Canny(1, 2));
		camera2.addFilter(new Mirror(Flipcode.Y_AXIS));
		
		Window window = new Window(camera);
		Window window2 = new Window(camera2);
	}
}