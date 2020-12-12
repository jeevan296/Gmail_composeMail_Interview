


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Before;

public class ComposeMail {
	
	
        public static void main(String[]args) throws InterruptedException, AWTException {
        	
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tjeevan\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
        	WebDriver driver = new ChromeDriver();
        	driver.get("https://www.google.co.in/gmail/");
        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        	System.out.println(driver.getCurrentUrl());
        	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("pm.cbre.cbre@gmail.com");
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[1]")).click();
        	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("CBRE@2020");
        	WebElement compose = driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']"));
        	compose.click();
        	Thread.sleep(2000);
        	
        	WebElement Receiptents = driver.findElement(By.xpath("//div[@id=':oa']"));
        	
        	Receiptents.sendKeys("snagajeevan@gmail.com");
        	
        	WebElement subject = driver.findElement(By.xpath("//input[@id=':zz']"));
        	subject.sendKeys("Samplesubject");
        	
        	WebElement emailbody = driver.findElement(By.xpath("//div[@id=':114']"));
        	emailbody.sendKeys("samplebody");
        	
        	
        	WebElement attachfileicon = driver.findElement(By.xpath("//div[@id=':11h']"));
        	
        	attachfileicon.click();
        	Thread.sleep(3000);
        	
        	File f = new File("C:\\Users\\Tjeevan\\Downloads\\Gmail_ComposeMail_TestCases");
        	
        	
        	String userDir=System.getProperty("user.dir");
			String fullFilePath= userDir+f;
			StringSelection ss = new StringSelection(fullFilePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			WebElement send = driver.findElement(By.xpath("//div[@id=':zp']"));
			send.click();
			Thread.sleep(5000);
			
			WebElement MessagesentValidation = driver.findElement(By.xpath("//span[@class='bAq']"));
			String ActualMessage= getText(MessagesentValidation);
			String ExpectedMessage = "Message sent.";
			Assert.assertEquals(ExpectedMessage,  ActualMessage);
			System.out.println("Validation passed");
			
			driver.close();
			
        
        }
        
        public static String getText(WebElement element) {

             WebDriverWait wait = null;
    			System.out.println(element.getTagName()+" element"+element.getText());
    			wait.until(ExpectedConditions.visibilityOf(element));
    		
    		return element.getText();

        	
        }
}
