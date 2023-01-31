package ie.gmit.dip;



import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
//This class writes out the BufferedImage image to the outputfile, which the user specifies in the format FileName.png
public class ImageWriter {
	public void writeImage(BufferedImage image, String URL) throws IOException {
		File outputfile = new File(URL);
		ImageIO.write(image, "png", outputfile);
	}
	
	
	
}

