package practice_package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.asserts.Assertion.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {
	
	@Test
	public void sample1() {
		System.out.println("Test_1");
		System.out.println("Test_2");
		assertEquals("Hello", "Hello", "TEST PASS");
		assertNotEquals("Hello", "Hello","TEST FAIL");
		System.out.println("Test_3");
		System.out.println("Test_4");
	}
	
	@Test
	public void sample2() {
		System.out.println("Test_5");
		System.out.println("Test_6");
		String a="";
		//assertNull(a);
		assertNotNull(a);
		System.out.println("Test_7");
		System.out.println("Test_8");
	}
	
	@Test
	public void sample3() {
		System.out.println("Test_9");
		System.out.println("Test_10");
		String a="a";
		String b="b";
		//assertSame(a, a);
		assertNotSame(a, b);
		System.out.println("Test_11");
		System.out.println("Test_12");
	}
	
	@Test
	public void sample4() {
		System.out.println("Test_13");
		System.out.println("Test_14");
		SoftAssert sa=new SoftAssert();
		//sa.assertEquals(false, false);
		sa.assertNotEquals(false, false);
		System.out.println("Test_15");
		sa.assertAll();
		System.out.println("Test_16");
		
	}
}
