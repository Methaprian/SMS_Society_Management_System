package practice_package;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

	@DataProvider
	public Object[][] data() {
		Object[][] objArr = new Object[3][3];

		//Data
		objArr[0][0]=1;
		objArr[0][1]="SKM";
		objArr[0][2]="BTR";
		
		objArr[1][0]=2;
		objArr[1][1]="Deepthi";
		objArr[1][2]="BTR";
		
		objArr[2][0]=3;
		objArr[2][1]="Anup";
		objArr[2][2]="BTM";

		return objArr;
	}

}
