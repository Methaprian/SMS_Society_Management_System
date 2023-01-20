package practice_package;

import org.testng.annotations.Test;

public class SampleTestNGTest_4 {

	@Test(groups = "regression")
	public void sample7() {
		System.out.println(" -- Test Script 7 --");
	}
	
	@Test(groups = "smoke")
	public void sample8() {
		System.out.println(" -- Test Script 8 --");
	}
}
