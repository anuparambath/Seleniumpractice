package Practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class practiceall {


    public static void main(String args[]) throws Exception{
        WebDriver drv = driverConfig();
        practiceall pract = new practiceall();
        pract.openUrl(drv);
       // pract.alertModal(drv);
       // pract.dropdown(drv);
       // pract.jquerydrop(drv);
       // pract.datepicker(drv);
       // pract.dataTable(drv);
        pract.xceldata(drv);



    }


    public static WebDriver driverConfig()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Practice\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public  void openUrl(WebDriver driver)throws Exception{
        driver.navigate().to("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        WebElement hometitle = driver.findElement(By.xpath("//a[text()='Selenium Easy']"));
        try {
            if (hometitle.isDisplayed()) {
                System.out.println("Home page  displayed ");
            }
        }
        catch(NoSuchElementException e){
            System.out.println("Home page not displayed "+ e.getMessage());
        }
        Thread.sleep(300);
    }


    public void alertModal(WebDriver driver) throws Exception{
//        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        WebElement alertbutton = driver.findElement(By.xpath("//a[text()='Alerts & Modals']"));

        alertbutton.click();
        WebElement javaalertbutton = driver.findElement(By.xpath("//a[text()='Alerts & Modals']//following::a[text()='Javascript Alerts']"));



        WebElement alertbox = driver.findElement(By.xpath("  //*[text()='Click the button to display an alert box:']//following::button[@class='btn btn-default']"));
//        js.executeScript("arguments[0].click;",javaalertbutton);
//        js.executeScript("arguments[0].click;",alertbox);
        javaalertbutton.click();
        alertbox.click();
        Thread.sleep(300);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void dropdown(WebDriver driver) throws Exception {

        WebElement inputform = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputform.click();
        WebElement droplist = driver.findElement(By.xpath("//a[text()='Input Forms']//following::a[text()='Select Dropdown List']"));
        droplist.click();

        WebElement dayselection = driver.findElement(By.id("select-demo"));

        WebElement multiselection = driver.findElement(By.id("multi-select"));
        Select value =new Select(dayselection);
        value.selectByVisibleText("Tuesday");
        Thread.sleep(300);
        Select multivalue =new Select(multiselection);
        multivalue.selectByValue("New York");
        multivalue.selectByIndex(1);

    }
    public void jquerydrop(WebDriver driver) throws Exception{
        WebElement inputform = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputform.click();
        WebElement jquery = driver.findElement(By.xpath("//a[text()='Input Forms']//following::a[text()='JQuery Select dropdown']"));
        jquery.click();
        Thread.sleep(3000);
        WebElement selectcountry = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single' and @aria-labelledby='select2-country-container']"));
        Actions act =new Actions(driver);
        act.moveToElement(selectcountry).click().perform();
        Thread.sleep(3000);
        WebElement country = driver.findElement(By.xpath("//li[text()='Bangladesh']"));
        act.moveToElement(country).click().perform();
        WebElement multicountry = driver.findElement(By.xpath("//li[@class='select2-search select2-search--inline']//child::input"));
        act.moveToElement(multicountry).click().perform();
        WebElement multiselect1 = driver.findElement(By.xpath("//li[text()='Arkansas']"));

        act.moveToElement(multiselect1).click().perform();
        act.moveToElement(multicountry).click().perform();
        WebElement multiselect2 = driver.findElement(By.xpath("//li[text()='Colorado']"));
        act.moveToElement(multiselect2).click().perform();
    }
    public void datepicker(WebDriver driver) throws Exception{
        WebElement datepicker = driver.findElement(By.xpath("//a[text()='Date pickers']"));
        datepicker.click();
        WebElement bootstrap = driver.findElement(By.xpath("//a[text()='Date pickers']//following::a[text()='Bootstrap Date Picker']"));
        bootstrap.click();
        Thread.sleep(3000);
        WebElement dtslt = driver.findElement(By.xpath("//*[@id='sandbox-container1']//child::input[@type='text']"));
        dtslt.click();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//        Date date = new Date();
//        String date1= dateFormat.format(date);
//
//        LocalDate.from(date.toInstant()).plusDays(1);
//        System.out.println(date1);
       // dtslt.sendKeys(date1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        String date1=dtf.format(now);
        LocalDate tmrw =now.plusDays(1);
        String date2= dtf.format(tmrw);
        dtslt.sendKeys(date1);
        WebElement strtdt = driver.findElement(By.xpath("//input[@placeholder='Start date']"));
        WebElement enddt = driver.findElement(By.xpath("//input[@placeholder='End date']"));
        strtdt.click();
        strtdt.clear();
        Thread.sleep(3000);
        strtdt.sendKeys(date1);
        Thread.sleep(3000);

        enddt.click();
        enddt.clear();
        enddt.sendKeys(date2);

    }

        public void dataTable(WebDriver driver) {
            WebElement Table = driver.findElement(By.xpath("//a[text()='Table']"));
            Table.click();
//            WebElement Tablepagi = driver.findElement(By.xpath("//a[text()='Table']//following::a[text()='Table Pagination']"));
//            Tablepagi.click();
//
//            WebElement heading = driver.findElement(By.xpath(" //*[@class='btn-primary']/tr[1]/th[2]"));
//            WebElement value1 = driver.findElement(By.xpath(" //*[@id=\"myTable\"]/tr[1]/td[2]"));
//
//
//           System.out.println(heading.getText());
//            System.out.println( value1.getText());

            WebElement Tablesearchi = driver.findElement(By.xpath("//a[text()='Table']//following::a[text()='Table Data Search']"));
            Tablesearchi.click();
            WebElement btable = driver.findElement(By.xpath(" //*[@id='task-table']"));

            //WebElement tablevalue = btable.findElement(By.xpath("  //*[@id='task-table']/tbody/tr[1]/td[3]"));

            List<WebElement> row = driver.findElements(By.xpath("//*[@id='task-table']/tbody/tr"));

            System.out.println(row.size());

            for (int i = 1; i < row.size(); i++) {

                WebElement name = driver.findElement(By.xpath("//*[@id='task-table']/tbody/tr[" + i + "]/td[3]"));
                WebElement namevalue = driver.findElement(By.xpath("//*[@id='task-table']/tbody/tr[" + i + "]"));
                String name1 = name.getText();
                if (name1.equals("Loblab Dan")) {

                    System.out.println(namevalue.getText());
                }

            }
        }

    public void xceldata(WebDriver driver) throws Exception {


        WebElement Tables = driver.findElement(By.xpath("//a[text()='Table']"));
        Tables.click();
        WebElement Tablesearching = driver.findElement(By.xpath("//a[text()='Table']//following::a[text()='Table Data Search']"));
        Tablesearching.click();

        File file = new File("C:\\Selenium\\Practice\\src\\Testdata\\Testdatasheet.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wkbk = new XSSFWorkbook(inputStream);
        Sheet sheetname = wkbk.getSheetAt(0);
//        Row row = sheetname.getRow(1);
       // Cell cell = row.getCell(0);
       // String vnamevalue = cell.getStringCellValue();
        //System.out.println(cell);
        WebElement search = driver.findElement(By.xpath(" //input[@id='task-table-filter']"));
        search.click();
       search.sendKeys("Loblab Dan");

       // search.sendKeys(vnamevalue);
        Thread.sleep(5000);

        List<WebElement> rowdata = driver.findElements(By.xpath("//*[@id='task-table']/tbody/tr"));
        int numb = rowdata.size();

        System.out.println(numb);

         for (int i = 1; i <=numb ; i++)
         {

        //   WebElement namevalue = driver.findElement(By.xpath("//*[@id='task-table']/tbody/tr[" + i + "]"));

        WebElement name = driver.findElement(By.xpath("//*[@id='task-table']/tbody/tr["+i+"]/td[4]"));


        String details = name.getText();
             System.out.println(i);
        try {
         if(name.isDisplayed()) {
             System.out.println(details);
          Row   row1 = sheetname.getRow(0);
           //  Row row1 = sheetname.createRow(i);
             Cell cell = row1.createCell(1);
             cell.setCellValue(details);
         }
        }
        catch(Exception e)
        {
            System.out.println("Exception Handeled"+ "Iteration number"+i);
        }
    }

            FileOutputStream out = new FileOutputStream(file);
            wkbk.write(out);







            }



}
