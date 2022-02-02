package com.qabaufest.automatizacion;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import java.util.concurrent.TimeUnit;
public class CompraLaptopTest {
  private WebDriver driver;
 // private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver1/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }
  @After
  public void tearDown() {
   driver.quit();
  }
  @Test
  public void compraLaptop() throws InterruptedException {
    driver.get("https://www.demoblaze.com/index.html");
    driver.findElement(By.id("signin2")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("sign-username")).click();
    driver.findElement(By.id("sign-username")).sendKeys("TESTVJ");
   driver.findElement(By.id("sign-password")).click();
    driver.findElement(By.id("sign-password")).sendKeys("testvj");
    driver.findElement(By.cssSelector("#signInModal .btn-primary")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertTrue(alert.getText().contains("This user already exist."));
        alert.accept();
      } catch (Exception e) {
        //exception handling
   }
    
    driver.findElement(By.cssSelector("#signInModal .btn-secondary")).click();
    driver.findElement(By.id("login2")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    driver.findElement(By.id("loginusername")).click();
    driver.findElement(By.id("loginusername")).sendKeys("TESTVJ");
    driver.findElement(By.id("loginpassword")).click();
    driver.findElement(By.id("loginpassword")).sendKeys("testvj");
    driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
    System.out.println("User Login");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     WebDriverWait wait = new  WebDriverWait (driver, 30);
     wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Laptops")));
    Thread.sleep(1000);
    driver.findElement(By.linkText("Laptops")).click();
    driver.findElement(By.linkText("Sony vaio i5")).click();
    driver.findElement(By.linkText("Add to cart")).click();
    try {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertTrue(alert.getText().contains("Product added."));
        alert.accept();
      
    } catch (Exception e) {
        //exception handling
   }
    
     driver.findElement(By.id("cartur")).click();
     driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
     String innerText = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
     System.out.println(innerText);
     driver.findElement(By.linkText("Delete")).click();
    driver.findElement(By.id("logout2")).click();
    
  }
}
