package tests;

import java.io.PrintStream;

//import javafx.print.PrintSides;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class MaskOperation {

	public MaskOperation() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args) {
//        System.out.println("Welcome to OpenCV " + Core.VERSION);
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat m  = Mat.eye(4, 4, CvType.CV_8UC1);
//        System.out.println("m = " + m.dump());
    	

    	// !!!!!!!!!!!!!! Ligne obligatoire !!!!!!!!!!!!!!!!!
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	
    	PrintStream o = System.out;
    	
    	Mat mSrc, mDest, mKern;
    	String sFileNameSrc =  "images/digital_image_processing.jpg";
    	String sFileNameDest = "images/traits.jpg";
    	
    	o.println("Ouverture du fichier");
    	mSrc = Highgui.imread( sFileNameSrc, Highgui.CV_LOAD_IMAGE_GRAYSCALE );
    	mDest = new Mat( mSrc.rows(), mSrc.cols(), mSrc.type());
    	
// ============================= C++   
//    	Mat kern = (Mat<char>(3,3) <<  0, -1,  0,
//                -1,  5, -1,
//                 0, -1,  0);
// ===============================================
    	
    	o.println("Création de la matrice Kernel");
    	mKern  = new Mat( 3, 3, CvType.CV_32F){
    		{
//                put(0,0,0);
//                put(0,1,-2.1);
//                put(0,2,0);
//
//                put(1,0,-2.1);
//                put(1,1, 10);
//                put(1,2,-2.1);
//
//                put(2,0,0);
//                put(2,1,-2.1);
//                put(2,2,0);
                put(0,0,0);
                put(0,1,-5);
                put(0,2,0);
                
                put(1,0,-5);
                put(1,1,21.5);
                put(1,2,-5);
                
                put(2,0,0);
                put(2,1,-5);
                put(2,2,0);
    		}
    	};
   	
 /*   	mKern  = new Mat( 3, 3, CvType.CV_8UC1){
    		{
                put(125,125,125);
                put(125,125,125);
                put(125,125,125);
    		}
    	};
 */   	
    	o.println("Application du filtre, depth : "+mSrc.depth());
    	Imgproc.filter2D(mSrc, mDest, -1, mKern);
    	
    	o.println("Export");
    	Highgui.imwrite( sFileNameDest, mDest );
    }
}
