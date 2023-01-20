package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_1 {
	
	@Test(groups = "regression")
	public void sample1() {
		System.out.println(" -- Test Script 1 --");
	}
	
	@Test(groups = {"smoke","regression"} )
	public void sample2() {
		System.out.println(" -- Test Script 2 --");
	}
}
