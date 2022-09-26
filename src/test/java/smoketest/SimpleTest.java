package smoketest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest {
    private WebDriver driver = null;
    @BeforeMethod
    public void setUp(){

        WebDriverManager.firefoxdriver().setup();
   
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void login(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
@AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
