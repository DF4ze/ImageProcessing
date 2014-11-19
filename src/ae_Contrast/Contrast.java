package ae_Contrast;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Contrast{
//	   static int width;
//	   static int height;
//	   static double alpha = 2;
//	   static double beta = 50;
	   
	   public static void main( String[] args )
	   {
	      try{
	    	  
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         System.out.println("Peparing Mat");
	         Mat source = Highgui.imread("images/grayscale.jpg",Highgui.CV_LOAD_IMAGE_GRAYSCALE);
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         
	         System.out.println("Proc Mat");
	         Imgproc.equalizeHist(source, destination);
	         
	         System.out.println("Writing Mat");
	         Highgui.imwrite("images/contrast.jpg", destination);
	         
	         
	         }catch (Exception e) {
	            System.out.println("error: " + e.getMessage());
	         }
	   }
	}