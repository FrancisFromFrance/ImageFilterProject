package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	private static double[][] kernel;
	private static BufferedImage image;

	public Menu() {

	}

	// Switch case 1, which image to use. This displays the image either bridge or
	// allows the user to input their own image choice
	private static void chooseImage(int choice, Scanner sc) throws IOException {
		ImageReader imagereader = new ImageReader();
		switch (choice) {
		
		case 1://Case 1 allows the user to input their own image, they must include the extension
			System.out.println("Enter the name of the image you want to display:");
			String imageName = sc.next();
			DisplayImage.showImage(imageName);
			System.out.println("Do you want to use this image Y/N??");
			if (sc.next().equalsIgnoreCase("Y")) {
			   image = imagereader.readImage(imageName);
			 DisplayImage.f.setVisible(false);
			}
			break;

		case 2:

			DisplayImage.showImage("bridge-rgb.png");
			System.out.println("Do you want to use this image Y/N??");
			if (sc.next().equalsIgnoreCase("Y")) {
				image = imagereader.readImage("bridge-rgb.png");// Pass through the Buffered Image 'GMIT'
				DisplayImage.f.setVisible(false);
				}
			break;
		case 3:
			System.out.println("No image choosen, back to main menu");
		}
		
	}//End of chooseImage method

	//Switch case 2, which filter to use. This takes the image from the enum, and passes the kernel object from the enum so that we can access the filters
	private static void chooseFilter(int choice) { 
		switch (choice) { 
		case 1:
			kernel = Kernel.IDENTITY.kernel;
			break;

		case 2:
			kernel = Kernel.EDGE_DETECTION_1.kernel;
			break;

		case 3:
			kernel = Kernel.EDGE_DETECTION_2.kernel;
			break;

		case 4:
			kernel = Kernel.LAPLACIAN.kernel;
			break;

		case 5:
			kernel = Kernel.SHARPEN.kernel;
			break;

		case 6:
			kernel = Kernel.SOBEL_HORIZONTAL.kernel;
			break;

		case 7:
			kernel = Kernel.SOBEL_VERTICAL.kernel;
			break;

		}
	}
	//This is 
	public void start() throws IOException {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);

		Scanner sc = new Scanner(System.in);
		boolean mainLoop = true;

		int choice;
		while (mainLoop) {
			System.out.println("1) Choose Image"); // Ask user to specify the file to process.

			System.out.println("2) Select a Filter"); // List the set of filters avalaible in the class Kernel.java
			System.out.println("3) Save image");

			System.out.println("4) Quit"); // Terminate the program
			System.out.println("\nSelect Option [1-4]>");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Case 1 allows the user to choose an image
				System.out.println("1) Enter your own image");
				System.out.println("2) Bridge");
				System.out.println("3) Go back");
				choice = sc.nextInt();
				chooseImage(choice, sc);
				break;

			case 2:
				// Case 2 allows the user to choose a filter
				System.out.println("1) IDENTITY");

				System.out.println("2) EDGE_DETECTION_1");

				System.out.println("3) EDGE_DETECTION_2");

				System.out.println("4) LAPLACIAN");

				System.out.println("5) SHARPEN");

				System.out.println("6) SOBEL_HORIZONTAL");

				System.out.println("7) SOBEL_VERTICAL");

				System.out.println("\nSelect Option [1-7]>");
				choice = sc.nextInt();
				chooseFilter(choice); // This calls the method so that when you choose 1-7 it chooses the filter
				Filter f = new Filter(image, kernel);
				image = f.imageFilter();
				break;

			case 3:
				// Case 3 allows the used to input a output location to save the file
				System.out.println("1)Choose file location -->");

				String nameChoice = sc.next();
				ImageWriter iw = new ImageWriter();
				iw.writeImage(image, nameChoice);
				break;

			case 4:
				// Case 4 exits the program
				System.out.println("Exiting program...");
				mainLoop = false;
				break;
				
				//Default case says that it is invalid and lets you choose again
			default:
				System.out.print(ConsoleColour.RED_BRIGHT);
				System.out.println("This is not a valid menu option! Please choose again");
				choice = sc.nextInt();
				break;

			}// end of switch

			System.out.println(ConsoleColour.RESET);
		} // end of loop
		sc.close(); // close the scanner

	}

}
