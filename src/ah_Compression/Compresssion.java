package ah_Compression;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

class Compresssion {

   public static void main(String[] args) throws IOException {
	  
	  float quality = 0.075f;
	  
	  System.out.println("Peparing Image Input");
      File input = new File("images/digital_image_processing.jpg");
      BufferedImage image = ImageIO.read(input);

	  System.out.println("Peparing Image Output");
      File compressedImageFile = new File("images/quality/compress_q"+quality+".jpg");
      OutputStream os =new FileOutputStream(compressedImageFile);

	  System.out.println("Getting Iterator");
      Iterator<ImageWriter>writers =ImageIO.getImageWritersByFormatName("jpg");
      ImageWriter writer = (ImageWriter) writers.next();

	  System.out.println("Peparing OutputStream");
      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      writer.setOutput(ios);

	  System.out.println("Writing, quality="+quality);
      ImageWriteParam param = writer.getDefaultWriteParam();
      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(quality);
      writer.write(null, new IIOImage(image, null, null), param);
      os.close();
      ios.close();
      writer.dispose();
   }
}