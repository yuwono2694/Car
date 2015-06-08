import java.util.*;
import java.awt.*;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;
import java.util.Random;

//ini tugas yang diminta ko hudi.. Thank you..

public class Car
{
   	private int xLeft;
	private int xRight;
	private int yTop;
	private int yBottom;
	
	private int width;
	private int height;
	
	private int speed;
	private boolean turnRight;	// untuk menentukan secara acak apakah mobil akan belok kanan atau kiri waktu menghindari obstacle
		
	private ImageIcon redCar = new ImageIcon("car_red.png");
	private ImageIcon yellowCar = new ImageIcon("car_yellow.png");
	private ImageIcon greenCar = new ImageIcon("car_green.png");
	
	private JLabel carLabel = new JLabel(redCar);
	
	public Car()
	{
		this.xLeft = 0;
		this.xRight = 0;
		this.yTop = 0;
		this.yBottom = 0;
		this.width = 0;
		this.height = 0;
		this.speed = 0;
		generateTurn();
	}
		
	public Car(int xLeft, int yTop, int width, int height, int color)
	{
		this.xLeft = xLeft;
		this.xRight = xLeft+width;
		this.yTop = yTop;
		this.yBottom = yTop+height;
		this.width = width;
		this.height = height;
		
		carLabel.setOpaque(false);
		carLabel.setBackground(Color.BLACK);
		
		if (color == 1)
		{carLabel.setIcon(redCar);}
		else if (color == 2)
		{carLabel.setIcon(yellowCar);}
		else
		{carLabel.setIcon(greenCar);}
		
		this.speed = 2;
		generateTurn();
	}
	
	public int getXLeft()
	{
		return xLeft;
	}
	
	public void setXLeft(int xLeft)
	{
		this.xLeft = xLeft;
	}
	
	public int getXRight()
	{
		return (xLeft+width);
	}
	
	public int getYTop()
	{
		return yTop;
	}
	
	public void setYTop(int yTop)
	{
		this.yTop = yTop;
	}
	
	public int getYBottom()
	{
		return (yTop+height);
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public JLabel getCarLabel()
	{
		return carLabel;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public boolean isTurnRight()
	{
		return turnRight;
	}
	
	public void generateTurn()
	{
		Random rnd = new Random();
		int a = rnd.nextInt(2);
		
		if(a==1)
		{turnRight = true;}
		else
		{turnRight = false;}
	}
	
	public void setLabelBounds()
	{
		carLabel.setBounds(xLeft, yTop, width, height);
	}   
}
