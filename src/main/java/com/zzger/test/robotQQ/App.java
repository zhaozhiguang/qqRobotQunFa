package com.zzger.test.robotQQ;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	private static WebDriver driver;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	  
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.bin", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
    	System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
    	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://docs.qq.com/desktop/");
        WebDriver login = driver.switchTo().frame(0);
        login.findElement(By.id("switcher_plogin")).click();
        login.findElement(By.id("u")).clear();
        login.findElement(By.id("u")).sendKeys("1422615221");
        login.findElement(By.id("p")).clear();
        login.findElement(By.id("p")).sendKeys("zhaozhiguang1997");
        login.findElement(By.id("login_button")).click();
        //WebDriver main = driver.switchTo().frame("relative=parent");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='查看'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='复制链接'])[1]/following::li[1]")).click();
        driver.findElement(By.cssSelector("div.qq.auth-icon-title")).click();
        driver.findElement(By.cssSelector("span.groupname")).click();
        driver.findElement(By.cssSelector("div.user-unit-name-inner-container.user-unit-inline-block")).click();
        driver.findElement(By.cssSelector("button.selector_finish")).click();
        
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }
}
