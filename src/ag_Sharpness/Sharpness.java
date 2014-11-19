package ag_Sharpness;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Sharpness {
  public static void main( String[] args )
   {
      try{
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         System.out.println("Peparing Mat");
         Mat source = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         double sigmax = 50;
         System.out.println("Proc Mat, GaussianBlur, sigmax="+sigmax);
         Imgproc.GaussianBlur(source, destination, new Size(0,0), sigmax);
         System.out.println("Proc Mat, AddWeighted");
         Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
         
         System.out.println("Peparing Mat");
         Highgui.imwrite("images/sharp.jpg", destination);
         
      }catch (Exception e) {
      }
   }

}
