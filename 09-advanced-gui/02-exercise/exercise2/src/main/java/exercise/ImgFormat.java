package exercise;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImgFormat {

	public ImageIcon selectIcons(int i, int sizeImg, String color) {
		ImageIcon img = null;

		if (i > 8) {
			switch (i) {
				case 9:
					img = getImage(sizeImg, "asterisk", color);

					break;
				case 10:
					img = getImage(sizeImg, "0", color);

					break;

				case 11:
					img = getImage(sizeImg, "pad", color);

					break;
			}
		} else {
			img = getImage(sizeImg, String.format("%d", i + 1), color);
		}

		return img;
	}

	public ImageIcon[] generateIcons(int sizeImg) {

		ImageIcon[] icons = new ImageIcon[12];

		for (int i = 0; i < icons.length; i++) {
			if (i > 8) {
				switch (i) {
					case 9:
						icons[i] = getImage(sizeImg, "asterisk", "Grey");

						break;
					case 10:
						icons[i] = getImage(sizeImg, "0", "Grey");

						break;

					case 11:
						icons[i] = getImage(sizeImg, "pad", "Grey");

						break;
				}
			} else {
				icons[i] = getImage(sizeImg, String.format("%d", i + 1), "Grey");
			}
		}
		return icons;
	}

	// A method that returns an ImageIcon.
	public ImageIcon getImage(int sizeImg, String name, String color) {

		// Getting the image from the folder img.
		ImageIcon ico = new ImageIcon(Events.class.getResource("/img" + color + "/" + name + ".png"));

		// Getting the image from the ImageIcon.
		Image imageResize = ico.getImage();

		// Resizing the image.
		Image newImg = imageResize.getScaledInstance(sizeImg, sizeImg, java.awt.Image.SCALE_SMOOTH);

		// Creating a new ImageIcon from the resized image.
		ico = new ImageIcon(newImg);

		return ico;
	}

}
