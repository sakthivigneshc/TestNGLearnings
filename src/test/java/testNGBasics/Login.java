package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test(dataProvider = "getData", dataProviderClass = DataUtils.class )
	public void login(String data[]) {
		System.err.println("Email: "+data[0]);
		System.err.println("Pass: "+data[1]);
		
		
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize(); // 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// two element
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement username =  driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(data[0]); 
		
		WebElement password =  driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(data[1]);
		
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		btn.click();
		
		try {
		    WebElement error = driver.findElement(
		        By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']/p")
		    );

		    // If found -> invalid login
		    String errorMsg = error.getText();
		    Assert.assertEquals(errorMsg, "Invalid credentials");
		    System.out.println("Login Failed: " + errorMsg);

		} catch (NoSuchElementException e) {

		    // If error not found -> valid login
		    WebElement dashboard = driver.findElement(
		        By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
		    );
		    Assert.assertEquals(dashboard.getText(), "Dashboard");
		    System.out.println("Login Successful");
		}
	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close(); 
	}

}