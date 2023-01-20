package practice_package;

import org.testng.annotations.Test;

public class DataProviderReadClassTest extends DataProviderTest{

	
	@Test(dataProvider = "data")
	public void dataReadMethod(int id, String name, String branch) {
		System.out.println(id+"  "+name+"  "+branch);
	}
}
