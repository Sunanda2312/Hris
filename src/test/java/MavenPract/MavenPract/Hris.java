package MavenPract.MavenPract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Hris {
	
	WebDriver driver;
	
	public Hris(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunanda1\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void TestInitiator() {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\sunanda1\\Downloads\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.manage().window().maximize();
	}
	
	public void WrongPasswordLoginDetails() throws InterruptedException {
		panel();
		driver.findElement(By.id("txtUserName")).sendKeys("sunanda1");
		driver.findElement(By.id("txtPassword")).sendKeys("12345");
		driver.findElement(By.cssSelector("input.btn.pull-left")).click();
		panel();
		Thread.sleep(1000);
	}
	
	public void LoginWithBlankPassword() throws InterruptedException {
		panel();
		driver.findElement(By.id("txtUserName")).sendKeys("sunanda1");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input.btn.pull-left")).click();
		Thread.sleep(1000);
	}
	
	public void LoginDetails() {
		panel();
		clearForm();
		driver.findElement(By.id("txtUserName")).sendKeys("sunanda1");
		driver.findElement(By.id("txtPassword")).sendKeys("Sunanda@321#");
		driver.findElement(By.cssSelector("input.btn.pull-left")).click();
		System.out.println(driver.getCurrentUrl());
	}
	
	public void ClickOnACcount() throws InterruptedException {
		driver.findElement(By.cssSelector("a.profile-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href=\"https://hris.qainfotech.com:8086/user/logoff\"]>span")).click();
		Thread.sleep(500);
		panel();
		String expectedUrl = "https://hris.qainfotech.com/login.php"; 
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
	
	public void panel() {
		driver.findElement(By.cssSelector("div>ul>li>a.active>span")).click();
	}
	
	public void clearForm() {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtPassword")).clear();
	}
		
}
