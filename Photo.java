package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Photo
{
	private BufferedImage image;
	private String path;
	public Photo(String path) throws IOException
	{
		this.path = path;
		image = ImageIO.read(new File(this.path));
	}
}