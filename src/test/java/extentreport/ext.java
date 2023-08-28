package extentreport;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ext {
	ExtentReports extent;
	WebDriver wd;
	ExtentTest Logger;
	
	@BeforeTest
	public void test() throws InterruptedException{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/sruthi.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"src/test/java/extent-confg.xml"));
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		wd.manage().window().maximize();
		
	}
	@Test
	public void Tes1() throws InterruptedException{
		Logger=extent.startTest("Moolya");
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Logger.log(LogStatus.PASS,"web page is open");
		Thread.sleep(3000);
		
		
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		Logger.log(LogStatus.PASS,"web page is open");
		wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		Logger.log(LogStatus.PASS,"web page is open");
		wd.findElement(By.xpath("//*[@type='submit']")).click();
		Logger.log(LogStatus.PASS,"web page is open");
		String str=wd.getTitle();
		Logger.log(LogStatus.PASS,str);
		Assert.assertEquals("OrangeHRM", str);
		Logger.log(LogStatus.PASS,"Assert Passed");
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']")).click();
		Logger.log(LogStatus.PASS,"logout floder clicked");
		 //Thread.sleep(3000);
		 wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
		 Logger.log(LogStatus.PASS,"return to the page");
	}
	
	@AfterTest
	public void aftertest() {
		wd.close();
		extent.endTest(Logger);
		extent.close();
		extent.flush();
	}
}
