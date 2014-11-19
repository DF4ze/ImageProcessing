package aj_pyramide;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Pyramide {

	 public static void main( String[] args )
	   {
	      try{
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         System.out.println("Preparing Mat");
	         Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
	         Mat destination1 = new Mat(source.rows()*2, source.cols()*2,source.type());
	         
	         System.out.println("Proc Mat");
	         destination1 = source;
	         Imgproc.pyrUp(source, destination1, new Size(source.cols()*2, source.rows()*2));
	         System.out.println("Write pyrUp");
	         Highgui.imwrite("images/pyrUp.jpg", destination1);
	         
	         System.out.println("\nPreparing Mat");
	         source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
	         Mat destination = new Mat(source.rows()/2,source.cols()/2, source.type());
	         
	         System.out.println("Proc Mat");
	         destination = source;
	         Imgproc.pyrDown(source, destination, new Size(source.cols()/2, source.rows()/2));
	         System.out.println("Write pyrDown");
	         Highgui.imwrite("images/pyrDown.jpg", destination);
	         
         }catch (Exception e) {
            System.out.println("error: " + e.getMessage());
         }
	   }
}
