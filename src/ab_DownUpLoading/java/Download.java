package ab_DownUpLoading.java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Download {

	public Download() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		try {
			String fileName = "digital_image_processing.jpg";
			String website = "http://tutorialspoint.com/java_dip/images/"+ fileName;
			System.out.println("Downloading File From: " + website);
			URL url = new URL(website);
			InputStream inputStream = url.openStream();
			OutputStream outputStream = new FileOutputStream("images/"+fileName);
			byte[] buffer = new byte[2048];
			int length = 0;
			while ((length = inputStream.read(buffer)) != -1) {
				System.out.println("Buffer Read of length: " + length);
				outputStream.write(buffer, 0, length);
			}
			inputStream.close();
			outputStream.close();
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
