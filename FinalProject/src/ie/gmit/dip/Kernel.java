package ie.gmit.dip;

//This is the enum which holds the effects to be utilized on the images
public enum Kernel {

	IDENTITY(new double[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }),

	EDGE_DETECTION_1(new double[][] { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } }),

	EDGE_DETECTION_2(new double[][] { { 1, 0, -1 }, { 0, 0, 0 }, { -1, 0, 1 } }),

	LAPLACIAN(new double[][] { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } }),

	SHARPEN(new double[][] { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } }),

	SOBEL_VERTICAL(new double[][] { { 1, 0, -1 }, { 2, 0, -2 }, { 1, 0, -1 } }),

	SOBEL_HORIZONTAL(new double[][] { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 }, });

	public final double[][] kernel;

	Kernel(double[][] kernel) { // A kernel representation of the object so that we can access it
		this.kernel = kernel;
	}

}
