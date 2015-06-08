public class CarDodgeMachine
{
   	public CarDodgeMachine()
	{}
   	
   	/*public bool isAnyObstacle(int carXs, int carY, int obsXLeft, int obsYTop, int distance)
   	{
   		if ((carX+200) >= obsX)
   	}*/
   	
   	public boolean isAnyObstacleHorizontal(Car car, Obstacle obstacle, int distance)
   	{
   		for(int i=distance; i>0; i-=2)
   		{
	   		if (((car.getXRight()+i) >= obstacle.getXLeft()) && ((car.getXRight()+i) <= obstacle.getXRight())) // artinya mobil dengan distance tertentu akan nabrak obstacle nya,
	   		{																												// dibikin 2 syarat gitu, untuk menghindari obstacle yang udah kelewat kena hitung ketabrak lagi
	   			if ((car.getYTop()<=obstacle.getYBottom() && car.getYTop()>=obstacle.getYTop()) || (car.getYBottom()<=obstacle.getYBottom() && car.getYBottom()>=obstacle.getYTop())) // cek koordinat Y nya
	   			{
	   				return true;
	   			}
	   			else	// ini untuk kondisi apabila koordinat x mobil kalau ditarik ke kanan memang nabrak sama obstacle nya, tapi koordinat y nya ga nabrak
	   			{}
	   		}
	   		else	// ini untuk kondisi apabila dicek ke kanan gt mobil nya, gada obstacle apa2
	   		{}
   		}
   		return false;
   	}
   	
   	public boolean isAnyObstacleVertical(Car car, Obstacle obstacle, int distance)
   	{
   		for(int i=distance; i>0; i-=2)
   		{																							
	   		if ((car.getYTop()-i<=obstacle.getYBottom() && car.getYTop()-i>=obstacle.getYTop()) || (car.getYBottom()+i<=obstacle.getYBottom() && car.getYBottom()+i>=obstacle.getYTop()))
	   		{
	   			return false;
	   		}
	   		else	// ini untuk kondisi apabila koordinat x mobil kalau ditarik ke kanan memang nabrak sama obstacle nya, tapi koordinat y nya ga nabrak
	   		{}
	   	}
   		return true;
   	}
   	
   	public boolean isAnyObstacleVerticalDown(Car car, Obstacle obstacle, int distance)
   	{
   		if((car.getXRight()>=obstacle.getXLeft() && car.getXRight()<=obstacle.getXRight()) || (car.getXLeft()>=obstacle.getXLeft() && car.getXLeft()<=obstacle.getXRight()))	// artinya mobil nya ada sejajar dengan obstacle
   		{
	   		for(int i=distance; i>0; i-=2)
	   		{																							
		   		if (car.getYBottom()+i<=obstacle.getYBottom() && car.getYBottom()+i>=obstacle.getYTop())
		   		{
		   			return true;
		   		}
		   		else	// ini untuk kondisi apabila koordinat x mobil kalau ditarik ke kanan memang nabrak sama obstacle nya, tapi koordinat y nya ga nabrak
		   		{
		   			return false;
		   		}
		   	}
   		}
   		else
   		{return true;}
   		return true;
   	}
}
