package ad_GrayScale;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GrayScale {

	 BufferedImage  image;
	   int width;
	   int height;
	   public GrayScale() {
	      try {
	    	 System.out.println( "Getting img" );
	         File input = new File("images/digital_image_processing.jpg");
	         image = ImageIO.read(input);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	    	 System.out.println( "Crawling img" );
	         for(int i=0; i<height; i++){
	            for(int j=0; j<width; j++){
	               Color c = new Color(image.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               
	               int sum = red+green+blue;
	               Color newColor = new Color(sum, sum, sum);
	               image.setRGB(j,i,newColor.getRGB());
	 	    	   System.out.print( "." );
	             }
		    	 System.out.println( "" );
	         }
	    	 System.out.println( "" );
	    	 System.out.println( "Writing img" );
	         File ouptut = new File("images/grayscale.jpg");
	         ImageIO.write(image, "jpg", ouptut);
	      } catch (Exception e) {}
	   }
	   
	   
	   static public void main(String args[]) throws Exception 
	   {
	      GrayScale obj = new GrayScale();
	   }
}
