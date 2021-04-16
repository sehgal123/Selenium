package sanitySuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGDemo {
	
	@BeforeSuite
	public void eSuite() {
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void eTest() {
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	public void eClass() {
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void eMethod() {
		System.out.println("@BeforeMethod");
	}
	
	@AfterSuite
	public void rSuite() {
		System.out.println("@@AfterSuite");
	}
	
	@AfterTest
	public void rTest() {
		System.out.println("@@AfterTest");
	}
	
	@AfterClass
	public void rClass() {
		System.out.println("@@AfterClass");
	}
	
	@AfterMethod
	public void rMethod() {
		System.out.println("@@AfterMethod");
	}
	
	@Test
	public void TC01() {
		System.out.println("TC01");
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02");
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03");
	}
}
