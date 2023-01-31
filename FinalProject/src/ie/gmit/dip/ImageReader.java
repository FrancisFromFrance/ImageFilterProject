package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
//This class lets us read in a BufferedImage, and input the name of the file
public class ImageReader {

	BufferedImage img;
	byte[] array1;

	public BufferedImage readImage(String name) throws IOException {

		BufferedImage img = ImageIO.read(new File(name));

		return img;
	}
}
