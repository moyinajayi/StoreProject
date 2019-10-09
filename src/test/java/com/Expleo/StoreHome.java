package com.Expleo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class StoreHome {

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
    public void testStoreHome() throws Exception {
        driver.get(baseUrl);
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        RegisterUserPageObject Newlogin = PageFactory.initElements(driver, RegisterUserPageObject.class);

        Newlogin.clickSignOn();
        Newlogin.enterEmail("momo2@gmail.com");
        Newlogin.setFirstname("lola");
        Newlogin.setLastname("Kemi");
        Newlogin.setGender();
        Newlogin.setPassword("mona123");
        Newlogin.setBirthday();
        Newlogin.setBirthmonth();
        Newlogin.setBirthyear();
        Newlogin.setNewsletter();
     //   Newlogin.enterFirstname("Moty");
       // Newlogin.enterlastname("Wona");
        Newlogin.setAddress("89, Currie Road");
        Newlogin.setCity("Alabama");
        Newlogin.setState();
        Newlogin.setZipcode("12345");
        Newlogin.setPhonenum(12344556);
        Newlogin.setAddressAlias("45, Stardon Street");
        Newlogin.setSignUpButton();
        Thread.sleep(1000);
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