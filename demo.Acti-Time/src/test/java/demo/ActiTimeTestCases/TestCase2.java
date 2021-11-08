package demo.ActiTimeTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import demo.actiTimeGenericUtils.BaseClass;

public class TestCase2 extends BaseClass
{
	@Test
	public void sample()
	{
		System.out.println("Started");
		Assert.fail();
		System.out.println("ended");
	}
}
