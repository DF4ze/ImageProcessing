package ak_Threshold;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Threshold {
   public static void main( String[] args )
   {
      try{

         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         System.out.println("Getting Img");
         Mat source = Highgui.imread("images/traits.jpg", Highgui.CV_LOAD_IMAGE_GRAYSCALE);
//         Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_GRAYSCALE);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());

         destination = source;
         double thresh = 150;
         double maxval = 255;
         
         System.out.println("Img Proc");
         Imgproc.threshold(source,destination,thresh,maxval,Imgproc.THRESH_BINARY);
         
         System.out.println("Img Write");
         Highgui.imwrite("images/threshold/traits2.jpg", destination);
//         Highgui.imwrite("images/threshold/GrayThreshTrunc_t"+thresh+"_m"+maxval+".jpg", destination);
         
     }catch (Exception e) {
        System.out.println("error: " + e.getMessage());
     }
   }
}