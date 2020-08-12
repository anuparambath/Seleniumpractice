package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class pageloading {

    public static void main(String args[]) throws Exception {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").toString().equals("complete");
        String MainWindow = driver.getWindowHandle();
        System.out.println("The Main window is"+MainWindow);
        driver.findElement(By.xpath(" //*[text()='Forms']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //*[text()='Interview Availability Form ']")).click();
        Thread.sleep(3000);
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
//        for(String s : s1)
//        {
//            System.out.println(s);
//            driver.switchTo().window(s);
//            Thread.sleep(3000);
//        }



        while (i1.hasNext()) {
            String MWindow = i1.next();
            String ChildWindow = i1.next();
            System.out.println("The Child window is"+ChildWindow);
            driver.switchTo().window(ChildWindow);
            Thread.sleep(3000);
            System.out.println("first");
       }
        WebElement str = driver.findElement(By.xpath("//input[@id='storeNo']"));
        str.sendKeys("0410");

        }

    }

