package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;

public class Paint extends JFrame
{
	public double fullTime;
	private int m = 300000;
	private Color[] colors = {Color.WHITE, Color.BLUE, Color.RED};
	
	public Paint()
	{
		 setSize(300, 300);
	     setLocation(0, 0);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     setTitle("Third test");
	     setVisible(true);
	}
	
	@Override
    public void paint(Graphics g)
	{
        Graphics2D g2 = (Graphics2D) g;
        int xPoints[] = {0, 0, 0, 0};
		int yPoints[] = {0, 0, 0, 0};
		int j = 0;
		long startTime = 0, endTime = 0;
		startTime = System.nanoTime();
        for (int i = 0; i < m; i++)
        {
        	xPoints[0] += i;
			xPoints[1] += (2 * i);
			xPoints[2] += i;
			yPoints[2] += i;
			yPoints[3] += i;
			
			if(j == 3)
			{
				j = 0;
			}
			g2.setPaint(colors[j]);
			Polygon polygon = new Polygon(xPoints, yPoints, 4);
			g2.fillPolygon(polygon);
			j++;
        }
        endTime = System.nanoTime();
        fullTime = (endTime - startTime) / 1000000000.0;
        setVisible(false);
    }
}
