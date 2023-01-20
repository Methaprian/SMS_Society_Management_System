package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_2 {
	
	@Test(groups = {"smoke","regression"})
	public void sample3() {
		System.out.println(" -- Test Script 3 --");
	}
	
	@Test(groups = "regression")
	public void sample4() {
		System.out.println(" -- Test Script 4 --");
	}

}
