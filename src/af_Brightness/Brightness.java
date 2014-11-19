package af_Brightness;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class Brightness {

	 static int width;
     static int height;
     static double alpha = 3;
     static double beta = 50;
     
     public static void main( String[] args ) {
        
	 try{
           System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	       
           System.out.println("Peparing Mat");
           Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
           Mat destination=new Mat(source.rows(), source.cols(), source.type());
	       
           System.out.println("Processing Mat : alpha="+alpha+" beta="+beta);
           source.convertTo(destination, -1, alpha, beta);
           
	       System.out.println("Writing Mat");
	       Highgui.imwrite("images/brightness/brightWithAlpha"+alpha+"Beta"+beta+".jpg", destination);
	       
      }catch (Exception e) {
         System.out.println("error: " + e.getMessage());
      }
  }

}
