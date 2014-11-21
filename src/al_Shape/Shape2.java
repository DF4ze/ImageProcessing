package al_Shape;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class Shape2 {

	public static void main(String[] args) {
	      try{

	          System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	          
	          System.out.println("Getting Img");
	          Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
	          Mat destination = new Mat(source.rows(),source.cols(),source.type());

	          System.out.println("Img Proc");
		      Core.flip(source, destination, -1);

	          System.out.println("Img Write");
	          Highgui.imwrite("images/hsv2.jpg", destination);
	          
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      }
	}

}
