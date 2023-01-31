package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DisplayImage {
	public static JFrame f = new JFrame();

	public static void showImage(String name) {

		try {

			BufferedImage displayImg = ImageIO.read(new File(name));

			JLabel label = new JLabel((Icon) new ImageIcon(displayImg));

			f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			f.getContentPane().add(label);

			f.pack();

			f.setLocationRelativeTo(null);

			f.setVisible(true);

		} catch (IOException e) {

		}
	}
}