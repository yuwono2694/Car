import java.util.*;
import java.awt.*;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class Obstacle
{
	private int xLeft;
	private int xRight;
	private int yTop;
	private int yBottom;
	
	private int width;
	private int height;
	
	private ImageIcon pic;
	private JLabel label;

	public Obstacle()
	{
		this.xLeft = 0;
		this.xRight = 0;
		this.yTop = 0;
		this.yBottom = 0;
		this.width = 0;
		this.height = 0;
	}
	
	public Obstacle(int xLeft, int yTop, int width, int height, JLabel label)
	{
		this.xLeft = xLeft;
		this.xRight = xLeft+width;
		this.yTop = yTop;
		this.yBottom = yTop+height;
		this.width = width;
		this.height = height;
		this.label = label;
	}
	
	public int getXLeft()
	{
		return xLeft;
	}
	
	public int getXRight()
	{
		return xRight;
	}
	
	public int getYTop()
	{
		return yTop;
	}
	
	public int getYBottom()
	{
		return yBottom;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public void setLabelBounds()
	{
		label.setBounds(xLeft, yTop, width, height);
	}
}
