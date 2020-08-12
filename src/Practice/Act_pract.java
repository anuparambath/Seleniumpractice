package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Act_pract {
    public static void main(String args[]) throws Exception  {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Practice\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to("url");
        WebElement username = driver.findElement(By.name("j_username"));
        WebElement password = driver.findElement(By.xpath("//input[@name='j_password']"));
        WebElement login = driver.findElement(By.id("submit"));
        username.sendKeys("Qt");
        password.sendKeys("qt");
        login.click();
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.xpath("//*[@id ='storeModalLabel']"));
        //WebElement text = driver.findElement(By.xpath("//*[text()='QAT2407']"));
        Actions act =new Actions(driver);
        act.moveToElement(title).click().perform();
       // act.moveToElement(text).clickAndHold().perform();
        Thread.sleep(3000);
        act.dragAndDropBy(title,150,730);





    }
}
