package demo.actiTimeGenericUtils;

import org.testng.annotations.Test;

public class test {

	@Test
	public void test1()
	{
		PropertyUtils pUtils = new PropertyUtils();
		System.out.println(pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH, ActiTimeConstants.MAINURL));
	}

}