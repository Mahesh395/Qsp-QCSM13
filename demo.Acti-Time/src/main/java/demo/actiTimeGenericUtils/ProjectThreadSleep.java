package demo.actiTimeGenericUtils;

public class ProjectThreadSleep
{
	public static void sleepInseconds(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
