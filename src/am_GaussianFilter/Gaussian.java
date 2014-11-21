package am_GaussianFilter;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Gaussian {
   public static void main( String[] args )
   {
	   try {
	      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	      
		   System.out.println("Getting Img");
	      Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
	      Mat destination = new Mat(source.rows(),source.cols(),source.type());
	      
		   System.out.println("Proc Img");
		   Size maSize = new Size(1,101);
	      Imgproc.GaussianBlur(source, destination, maSize, 0);
	      
		   System.out.println("Writing Img");
		   Highgui.imwrite("images/blur/Gaussian"+maSize.width+"x"+maSize.height+".jpg", destination);
	      
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}