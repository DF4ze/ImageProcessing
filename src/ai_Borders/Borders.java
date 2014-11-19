package ai_Borders;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Borders{
   public static void main( String[] args )
   {
      try{
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
   	  	 System.out.println("Peparing Mat");
         Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());

   	  	 System.out.println("Init Arguz");
         int top, bottom, left, right;
 
         /// Initialize arguments for the filter
         top = (int) (0.05*source.rows()); 
         bottom = (int) (0.05*source.rows());
         left = (int) (0.05*source.cols()); 
         right = (int) (0.05*source.cols());

   	  	 System.out.println("Proc Mat");
         destination = source;
         int borderStyle = Imgproc.BORDER_WRAP;
         Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, borderStyle);
   	  	 
         System.out.println("Writing Mat");
         Highgui.imwrite("images/borders/border_"+borderStyle+".jpg", destination);
         
     }catch (Exception e) {
        System.out.println("error: " + e.getMessage());
     }
   }
}