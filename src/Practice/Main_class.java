package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Main_class {



    public static void main(String args[])   {

        try {
            WebDriver drv = driverConfig();
            Main_class mainclass = new Main_class();
            mainclass.Login(drv);
            mainclass.ReqDetails(drv);
        } catch (Exception e)
        {
            System.out.println("The error is "+e.getMessage());
        }

    }

    public static WebDriver driverConfig()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Practice\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //implicit wait////
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
    }

    public void Login(WebDriver driver) throws Exception
    {
        driver.navigate().to("https://www.gml.com");
        WebElement username = driver.findElement(By.name("j_username"));
        WebElement password = driver.findElement(By.xpath("//input[@name='j_password']"));
        WebElement login = driver.findElement(By.id("submit"));
        username.sendKeys("Qt");
        password.sendKeys("Qt");
        login.click();
        WebElement logintext = driver.findElement(By.xpath("//*[text()='Retail Staffing Request' and @id='brand']"));
        try {
            if (logintext.isDisplayed()) {
                System.out.println("Login successfull");
            }
        }
        catch(NoSuchElementException e){
            System.out.println("Login not successfull "+ e.getMessage());
        }
        Thread.sleep(3000);
    }

    public void ReqDetails(WebDriver driver) throws Exception
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.xpath("//input[@id ='titleText']"));
        WebElement phonenumber = driver.findElement(By.xpath("//input[@id ='requestorPhnNum']"));
        WebElement strnumber = driver.findElement(By.xpath("//input[@id ='strNum']"));
        WebElement position = driver.findElement(By.xpath(" //input[@id='nofP']"));
        WebElement ft =driver.findElement(By.xpath("//input[@id='ftPosn']"));
        WebElement candtype =driver.findElement(By.xpath("//input[@id='candTypExt']"));
        WebElement schpref =driver.findElement(By.xpath("//input[@id='schdPrefYes']"));
        WebElement days =driver.findElement(By.xpath("//input[@id='schdPref0']"));
        WebElement slots =driver.findElement(By.xpath("//input[@id='schdPref4']"));

        //explicit wait//
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(title));
        title.click();
        js.executeScript("arguments[0].click();",title);
        title.sendKeys("Cashier");
        phonenumber.click();
        phonenumber.sendKeys("5896325698");
        js.executeScript("arguments[0].click();", candtype);
        strnumber.click();
        strnumber.sendKeys("0114");
        Thread.sleep(7000);

        WebElement dept = driver.findElement(By.xpath("//*[@id='deptNumSelectBoxItArrowContainer']"));
        dept.click();
        Thread.sleep(7000);
        System.out.println("Wait is over");
        position.click();
        position.sendKeys("1");
        ft.click();
        js.executeScript("arguments[0].click();", candtype);
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        schpref.click();
        days.click();
        slots.click();
        Thread.sleep(3000);
        WebElement submitbutton = driver.findElement(By.xpath("//input[@id='submitRequestBtn']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitbutton);
        submitbutton.click();
        WebElement warning = driver.findElement(By.xpath("//button[@onclick='retailStaffingRequest.submitOkClicked()']"));


        warning.click();


    //     driver.switchTo().alert().accept();
























        /////////////////////////////////////////js send keys//////////////
        // js.executeScript("arguments[0].value='Cashier';", title);
        // String titlename = "Cashier";
        // js.executeScript("arguments[0].value=arguments[1];", title,titlename);

        /////////////////////////////////////js scroll//////////////
        // till the bottom of page  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // scroll down js.executeScript("window.scrollBy(0,150)");
        // scroll up js.executeScript("window.scrollBy(0,-150)");
        // scroll horizontal  js.executeScript("window.scrollBy(150,0)");
        // scroll by element view     js.executeScript("arguments[0].scrollIntoView(true);", element);

        //////////////////// dept num////////////////////////////

        // driver.findElement(By.xpath("//*[@id='deptNumSelectBoxItArrowContainer']")).click();
        // Thread.sleep(5000);
        // driver.findElement(By.xpath("//*[@id='deptNumSelectBoxItArrowContainer']")).sendKeys("010 - GREETERS");
        // itembox.click();
        // itembox.sendKeys("010 - GREETERS");
        // dept.selectByIndex(2);

        ////////////////////////robot class/////////////////////////////
        // Robot robot =new Robot();
        // robot.keyPress(KeyEvent.VK_Q);
        // robot.keyRelease(KeyEvent.VK_Q);
        // robot.keyPress(KeyEvent.VK_A);
        // robot.keyRelease(KeyEvent.VK_A);
        // robot.keyPress(KeyEvent.VK_T);
        // robot.keyRelease(KeyEvent.VK_T);
        // robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        // robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        // robot.mouseMove(40,200);  it wll move 40,200 from the point where mouse is pointed to

        ////////////////////Act_pract////////////////////////////////////////////////////
        // Act_pract actions =new Act_pract(driver);
        // WebElement username= driver.findElement(By.name("j_username"));
        // WebElement password = driver.findElement(By.xpath("(//input)[7]"));
        // WebElement submit =driver.findElement(By.xpath("//button[@id='submit']"));
        // actions.sendKeys(username,"qat2407").build().perform();
        // actions.click(password).perform();
        // actions.sendKeys(password,"qa02test").perform();
        // Action act = (Action) actions.moveToElement(password).click().sendKeys("qa02test").build();
        // act.perform();
        //  actions.moveToElement(submit);
        // actions.click().perform();

    }

}
