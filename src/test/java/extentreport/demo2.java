package extentreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo2 {
	WebDriver wd;
	@BeforeTest
	public void bt1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		wd.manage().window().maximize();		
}

@Test
public void Tes1(){
	
	wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	wd.findElement(By.xpath("//*[@type='submit']")).click();
}


}
