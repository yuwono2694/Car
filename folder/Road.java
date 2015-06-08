import java.awt.*;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;
import java.util.TimerTask;
import java.util.Random;

public class Road extends JFrame
{
	private Container con = getContentPane();
	   
	private ImageIcon roadPic = new ImageIcon("Road.png");
	private JLabel road = new JLabel(roadPic);
	
	private ImageIcon obstacle1Pic = new ImageIcon("Obstacle 01.png");
	private ImageIcon obstacle2Pic = new ImageIcon("Obstacle 02.png");
	private JLabel[] obstacle1 = new JLabel[6];
	private Obstacle[] obstacleInfo = new Obstacle[5];
	
	private TrafficLight trafficLight;
	private Car[] car = new Car[6];
		
	private JPanel startPanel = new JPanel();
	
	private CarDodgeMachine carDodgeMachine = new CarDodgeMachine();
	
	Timer time = new Timer(20, new CarTimer());
	int tes = 0;
	
	public Road()
	{
		super("Road");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(null);
		
		startPanel.setSize(1200, 400); startPanel.setLayout(null); startPanel.setVisible(true); startPanel.setBounds(0, 0, 1200, 400);
		road.setBounds(0, 0, 1200, 400);
		
		Random rnd = new Random();
		
		car[0] = new Car(-100, (rnd.nextInt(220)+70), 81, 40, 1); car[0].setLabelBounds();
		car[1] = new Car(-400, (rnd.nextInt(220)+70), 81, 40, 2); car[1].setLabelBounds();
		car[2] = new Car(-700, (rnd.nextInt(220)+70), 81, 40, 3); car[2].setLabelBounds();
		car[3] = new Car(-1000, (rnd.nextInt(220)+70), 81, 40, 1); car[3].setLabelBounds();
		car[4] = new Car(-1300, (rnd.nextInt(220)+70), 81, 40, 2); car[4].setLabelBounds();
		car[5] = new Car(-1600, (rnd.nextInt(220)+70), 81, 40, 3); car[5].setLabelBounds();
		
		for(int i=0; i<6; ++i)
		{
			startPanel.add(car[i].getCarLabel());
		}
		
		for(int i=0; i<3; ++i)
		{
			obstacle1[i] = new JLabel(obstacle1Pic);
			obstacle1[i].setOpaque(false);
			obstacle1[i].setBackground(Color.BLACK);
		}
		
		for(int i=3; i<6; ++i)
		{
			obstacle1[i] = new JLabel(obstacle2Pic);
			obstacle1[i].setOpaque(false);
			obstacle1[i].setBackground(Color.BLACK);
		}
		
		obstacleInfo[0] = new Obstacle(1000, 250, 41, 51, obstacle1[0]); obstacleInfo[0].setLabelBounds();
		obstacleInfo[1] = new Obstacle(220, 100, 41, 51, obstacle1[1]); obstacleInfo[1].setLabelBounds();
		obstacleInfo[2] = new Obstacle(600, 220, 41, 51, obstacle1[2]); obstacleInfo[2].setLabelBounds();
		obstacleInfo[3] = new Obstacle(140, 270, 53, 61, obstacle1[3]); obstacleInfo[3].setLabelBounds();
		obstacleInfo[4] = new Obstacle(800, 140, 53, 61, obstacle1[4]); obstacleInfo[4].setLabelBounds();
		
		for(int i=0; i<5; ++i)
		{
			startPanel.add(obstacleInfo[i].getLabel());
			obstacle1[i].setVisible(true);
		}

		trafficLight = new TrafficLight(500, -5, 19, 67, false);
		trafficLight.setLabelBounds();
		startPanel.add(trafficLight.getLightLabel());
		
		startPanel.add(road);
		startPanel.setVisible(true);
		
		con.add(startPanel);
		
		//System.out.println(tes);
		time.start();
	}
	
	public class CarTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// MOBIL DIGESER DULU, SUPAYA MAJU SEMUANYA
			for(int i=0; i<6; ++i)
			{
				car[i].setXLeft(car[i].getXLeft()+car[i].getSpeed());
				
				if(car[i].getXLeft() >= 1700)	//supaya muter lagi mobilnya, nongol di sebelah kiri lagi
				{
					Random rnd = new Random();
					car[i].setXLeft(-100);
					car[i].setYTop(rnd.nextInt(220)+70);
					car[i].generateTurn();
				}
			}
			
			// MASING-MASING MOBIL DIPERIKSA APAKAH AKAN NABRAK OBSTACLE ATAU TIDAK
			for(int i=0; i<6; ++i)
			{
				for(int j=0; j<5; ++j)
				{
					if(carDodgeMachine.isAnyObstacleHorizontal(car[i], obstacleInfo[j], 90))
					{
						if(car[i].isTurnRight() == true)	//yang bawah gerak ke atas
						{
							car[i].setYTop(car[i].getYTop()+2);
							/*for(int k=0; k<5; ++k)
							{
								if(carDodgeMachine.isAnyObstacleVerticalDown(car[i], obstacleInfo[k], 50) == false)
								{
									car[i].setYTop(car[i].getYTop()+2);
								}
								else
								{System.out.println("masuk");}
							}*/
						}
						else
						{
							car[i].setYTop(car[i].getYTop()-2);
						}
						
						break;	//jadi kena yang paling deket aja obstacle nya, ga kena 2 kali
					}
					else
					{}
				}
			}
						
			for(int i=0; i<6; ++i)
			{
				car[i].setLabelBounds();
			}			
		}
	}
}

class RoadMain
{
	public static void main(String []args)
	{
		Road road = new Road();
		road.setSize(1220, 420);
		road.setVisible(true);
	}
}
