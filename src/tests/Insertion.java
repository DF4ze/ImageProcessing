package tests;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class Insertion {
	   public static void main( String[] args ) throws IOException {
		   
		   System.out.println("Getting largeImg");
		   Mat source1 = Highgui.imread("images/digital_image_processing.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
		  
		   System.out.println("Getting smallImg");
		   File input = new File("images/pyrDown.jpg");
		   BufferedImage image = ImageIO.read(input);	
		   byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		   
		   System.out.println("Put 2 in 1");
		   source1.put(15, 150, data);
		   
		   Highgui.imwrite("images/insertion.jpg", source1);
	   }
}
