
package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//This class will handle the filtering aspect of the project
public class Filter {

	private static BufferedImage inputImg;

	private static double[][] kernel;

	public Filter(BufferedImage inputImg, double[][] kernel) {
		this.inputImg = inputImg;
		this.kernel = kernel;
	}

	// it is important to note that i and j are the position of the pixel in the
	// image being filtered
	// whereas row and col are position of pixel in the kernel being filtered
	public BufferedImage imageFilter() throws IOException {
		BufferedImage outputImg = inputImg;
		for (int i = 0; i < inputImg.getWidth(); i++) { // go pixel for pixel through the image

			for (int j = 0; j < inputImg.getHeight(); j++) {
				int pixel = inputImg.getRGB(i, j);
				outputImg.setRGB(i, j, apply(pixel, i, j));

			}
		} // end of loop
		return outputImg;
	}//end of imageFilter method

	public static int apply(int pixel, int i, int j) {

		float red = 0;
		float green = 0;
		float blue = 0;

		int outputRed;
		int outputGreen;
		int outputBlue;

		// looping into the filtering matrix
		for (int row = 0; row < kernel.length; row++) {
			for (int col = 0; col < kernel[row].length; col++) {

				// Get pixel values, imgX, imgY which helps to filter the pixels on the edges,
				// and make sure there's no exceptions
				int imgX = (i - kernel.length / 2 + row + inputImg.getWidth()) % inputImg.getWidth();
				int imgY = (j - kernel[row].length / 2 + col + inputImg.getHeight()) % inputImg.getHeight();
				int RGB = inputImg.getRGB(imgX, imgY); // Get RGB at new coordiantes X,Y

				// split long RGB number into 3 parts, seperating the red blue and green values
				int inputR = (RGB >> 16) & 0xff; // Red Value
				int inputG = (RGB >> 8) & 0xff; // Green Value
				int inputB = (RGB) & 0xff; // Blue Value

				// assign values to red, green and blue with the kernel values
				red += (inputR * kernel[row][col]);
				green += (inputG * kernel[row][col]);
				blue += (inputB * kernel[row][col]);
			}
		} // end of loop

		
		// normailize the values
		outputRed = Math.min(Math.max((int) (red), 0), 255);
		outputGreen = Math.min(Math.max((int) (green), 0), 255);
		outputBlue = Math.min(Math.max((int) (blue), 0), 255);
		
		
		//Use those values to set the color, then get the  values and output them
		Color color = new Color(outputRed, outputGreen, outputBlue);
		
		int rgb = color.getRGB();

		return rgb;
		
	}//end of apply method

}// end of class
