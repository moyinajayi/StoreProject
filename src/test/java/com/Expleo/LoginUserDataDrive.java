package com.Expleo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import jxl.*;
import jxl.write.*;
import java.io.File;
import java.io.FileInputStream;


public class LoginUserDataDrive {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe" );
        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testStoreLogin() throws Exception {
        driver.get(baseUrl);
        System.out.println(driver.getTitle());
        //RegisterUserPageObject Newlogin = PageFactory.initElements(driver, RegisterUserPageObject.class);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);

        Workbook wbIn = Workbook.getWorkbook(new File("C:\\Users\\Moyin Ajayi\\Documents\\DataDriveReg.xls"));
     //   FileInputStream fi = new FileInputStream("C:\\Users\\Moyin Ajayi\\Documents\\DataDriveReg.xls");
       // Workbook w = Workbook.getWorkbook(fi);
        //Sheet s = w.getSheet("Sheet1");
        WritableWorkbook wbOut = Workbook.createWorkbook(new File("C:\\Users\\Moyin Ajayi\\Documents\\DataDriveRes.xls"), wbIn);
        WritableSheet s = wbOut.getSheet("Sheet1");

        for (int i =1; i<=s.getRows(); i++){
            //driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).clear();
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).sendKeys((s.getWritableCell("A" +i)).getContents());
          //  driver.findElement(By.xpath("//*[@id=\"passwd\"]")).clear();
            driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys((s.getWritableCell("B"+i)).getContents());
            driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

            s.addCell(new Label(2, i-1, "Executed"));
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
            Thread.sleep(500);

        } wbOut.write();
        wbOut.close();




        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");

    }


    @After
    public void tearDown() throws Exception {
        // driver.quit();
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
