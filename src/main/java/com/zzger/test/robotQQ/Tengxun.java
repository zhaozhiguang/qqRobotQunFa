package com.zzger.test.robotQQ;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tengxun {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.bin", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
	System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTengxun() throws Exception {
    driver.get("https://docs.qq.com/desktop/");
    WebDriver login = driver.switchTo().frame(0);
    login.findElement(By.id("switcher_plogin")).click();
    login.findElement(By.id("u")).clear();
    login.findElement(By.id("u")).sendKeys("1422615221");
    login.findElement(By.id("p")).clear();
    login.findElement(By.id("p")).sendKeys("");
    login.findElement(By.id("login_button")).click();
    //WebDriver main = driver.switchTo().frame("relative=parent");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='查看'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='复制链接'])[1]/following::li[1]")).click();
    driver.findElement(By.cssSelector("div.qq.auth-icon-title")).click();
    driver.findElement(By.cssSelector("span.groupname")).click();
    driver.findElement(By.cssSelector("div.user-unit-name-inner-container.user-unit-inline-block")).click();
    driver.findElement(By.cssSelector("button.selector_finish")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
