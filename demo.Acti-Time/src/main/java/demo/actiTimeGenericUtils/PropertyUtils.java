package demo.actiTimeGenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils
{
	public String getPropertyData(String filepath, String Key)
	{
		FileInputStream file;
		Properties properties = new Properties();
		try {
			file = new FileInputStream(filepath);
			properties.load(file);
			//String Value = properties.getProperty("Key");
			} 
		catch (Exception e)
		{
			System.out.println("Exception");
		}
		return properties.getProperty(Key);
	}
}
