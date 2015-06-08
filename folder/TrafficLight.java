import java.util.*;
import java.awt.*;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class TrafficLight
{
	private ImageIcon redLight = new ImageIcon("red_lights.png");
	private ImageIcon yellowLight = new ImageIcon("yellow_lights.png");
	private ImageIcon greenLight = new ImageIcon("green_lights.png");
	
	private JLabel lightLabel = new JLabel(greenLight);
	
	private int xLeft;
	private int yTop;
	private int width;
	private int height;
	
	private boolean red = false;
	
	public TrafficLight(int xLeft, int yTop, int width, int height, boolean red)
	{
	    this.xLeft = xLeft;
		this.yTop = yTop;
		this.width = width;
		this.height = height;
		this.red = red;

		lightLabel.setOpaque(false);
		lightLabel.setBackground(Color.BLACK);
	}
	
	public int getXLeft()
	{
		return xLeft;
	}
	
	public int getYTop()
	{
		return yTop;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public JLabel getLightLabel()
	{
		return lightLabel;
	}
	
	public boolean isRed()
	{
		return red;
	}
	
	public void changeGreen()
	{
		lightLabel.setIcon(greenLight);
	}
	
	public void changeRed()
	{
		lightLabel.setIcon(redLight);
	}
	
	public void setLabelBounds()
	{
		lightLabel.setBounds(xLeft, yTop, width, height);
	}
}
