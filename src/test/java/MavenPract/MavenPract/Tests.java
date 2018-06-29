package MavenPract.MavenPract;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends Hris {
	
	@Test
	public void Test001() {
		TestInitiator();	
		String expectedUrl = "https://hris.qainfotech.com/login.php"; 
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
	
	@Test
	public void Test002() throws InterruptedException {
		WrongPasswordLoginDetails();
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert-error")).getText().contains("Invalid Login"));
	}
	
	@Test
	public void Test003() throws InterruptedException {
		LoginWithBlankPassword();
		Assert.assertTrue(driver.findElement(By.id("txtPassword")).getAttribute("style").contains("red"));
	}
	
	@Test
	public void Test004() {
		LoginDetails();
		String expectedUrl = "https://hris.qainfotech.com:8086/time/timesheet"; 
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
	
	@Test
	public void Test005() throws InterruptedException {
		ClickOnACcount();
		String expectedUrl = "https://hris.qainfotech.com/login.php"; 
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}

}
