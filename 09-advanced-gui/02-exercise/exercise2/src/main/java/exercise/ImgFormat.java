package exercise;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImgFormat {

	/**
	 * It takes a BufferedImage, a color, and a size, and returns an ImageIcon
	 * 
	 * @param sizeImg the size of the image
	 * @return An array of ImageIcons.
	 */
	public ImageIcon[] generateIcons(int sizeImg) throws IOException {

		ImageIcon[] icons = new ImageIcon[12];
		BufferedImage buff;

		for (int i = 0; i < icons.length; i++) {

			buff = ImageIO.read(ImgFormat.class.getResource("/img/" + i + ".png"));
			icons[i] = buffToImage(buff, Color.LIGHT_GRAY, sizeImg);
		}
		return icons;
	}

	/**
	 * It takes an array of 12 images, and returns an array of 12 images, but with the color changed.
	 * 
	 * @param sizeImg the size of the image
	 * @param allColor The color that all the icons will be colored with, except for the one that is
	 * ignored.
	 * @param ignore the index of the icon you want to ignore
	 * @param ignoreColor The color that the icon will be colored with.
	 * @param icons The array of icons to be colorized.
	 * @return An array of ImageIcons.
	 */
	public ImageIcon[] colorizeIcons(int sizeImg, Color allColor, int ignore, Color ignoreColor, ImageIcon[] icons)
			throws IOException {

		ImageIcon[] newIcons = new ImageIcon[12];
		BufferedImage buff;

		for (int i = 0; i < newIcons.length; i++) {
			buff = ImageIO.read(ImgFormat.class.getResource("/img/" + i + ".png"));
			if (i != ignore) {
				newIcons[i] = buffToImage(buff, allColor, sizeImg);
			} else {
				newIcons[i] = buffToImage(buff, ignoreColor, sizeImg+10);
			}
		}
		return newIcons;

	}

	/**
	 * It takes an image, and returns a new image with the same dimensions, but with
	 * a different color
	 * 
	 * @param sizeImg the size of the image
	 * @param i       the number of the image to be loaded
	 * @param color   the color you want to change the image to
	 * @return An ImageIcon
	 */
	public ImageIcon colorizeIcon(int sizeImg, int i, Color color) throws IOException {
		ImageIcon ico;
		BufferedImage buff;
		buff = ImageIO.read(ImgFormat.class.getResource("/img/" + i + ".png"));
		ico = buffToImage(buff, color, sizeImg);
		return ico;
	}

	/**
	 * It takes a buffered image, a color, and a size, and returns an image icon of
	 * the buffered image
	 * dyed the color and resized to the size
	 * 
	 * @param buff    The buffered image to be dyed
	 * @param color   the color of the image
	 * @param sizeImg the size of the image
	 * @return The method is returning an ImageIcon.
	 */
	private ImageIcon buffToImage(BufferedImage buff, Color color, int sizeImg) {
		ImageIcon img = new ImageIcon(dye(buff, color, 308));
		img = resizeImg(sizeImg, img);
		return img;
	}

	/**
	 * It takes an image, a color, and an image size, and returns a new image with
	 * the color applied to it
	 * 
	 * @param image   The image to be dyed.
	 * @param color   The color you want to dye the image with.
	 * @param imgSize The size of the image to be generated.
	 * @return A BufferedImage
	 */
	private BufferedImage dye(BufferedImage image, Color color, int imgSize) {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage dyed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = dyed.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.setComposite(AlphaComposite.SrcAtop);
		g.setColor(color);
		g.fillRect(0, 0, w, h);
		g.dispose();
		return dyed;
	}

	/**
	 * It takes an ImageIcon and a size, and returns a new ImageIcon with the same
	 * image but with the new
	 * size
	 * 
	 * @param sizeImg The size of the image.
	 * @param ico     The ImageIcon that you want to resize.
	 * @return The ImageIcon is being returned.
	 */
	private ImageIcon resizeImg(int sizeImg, ImageIcon ico) {

		// Getting the image from the ImageIcon.
		Image imageResize = ico.getImage();

		// Resizing the image.
		Image newImg = imageResize.getScaledInstance(sizeImg, sizeImg, java.awt.Image.SCALE_SMOOTH);

		// Creating a new ImageIcon from the resized image.
		ico = new ImageIcon(newImg);

		return ico;
	}

}
