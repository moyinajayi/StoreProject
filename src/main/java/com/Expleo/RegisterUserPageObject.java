package com.Expleo;
//mport org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserPageObject {

    private WebDriver driver;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
    private WebElement SignOn;
    @FindBy(how = How.XPATH , using = "/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input")
            private WebElement emailIn;
    @FindBy(how = How.XPATH , using = "/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span")
    private WebElement submitEmail;
    @FindBy(how = How.ID, using = "id_gender2")
    private WebElement gender;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")
    private WebElement firstname;
    @FindBy(how = How.XPATH, using = "//*[@id=\"customer_lastname\"]")
    private WebElement lastname;
    @FindBy (how = How.XPATH, using =  "//*[@id=\"passwd\"]") //*[@id="customer_lastname"]
    private WebElement password;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select")
    private WebElement birthday;

    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[2]/div/select")
    private WebElement birthmonth;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select")
    private WebElement birthyear;

    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select")
            private WebElement newsletter;

    @FindBy(how = How.ID, using = "firstname")
    private WebElement fname;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement lname;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input")
    private WebElement address;
    @FindBy(how =How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input")
            private WebElement city;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select")
            private WebElement state;
    @FindBy (how = How.XPATH, using = "//*[@id=\"phone_mobile\"]")
        private WebElement mobileNum;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")
        private WebElement addressAlias;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span")
    private WebElement signUpButton;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input")
    private WebElement zipcode;

    public void clickSignOn(){
        SignOn.click();
    }
    public void enterEmail(String text){
        emailIn.clear();
        emailIn.sendKeys(text);
        submitEmail.click();
    }
    public void setGender(){ gender.click(); }
    public void setFirstname(String text){  firstname.sendKeys(text);}
    public void setLastname(String text){ lastname.sendKeys(text);}
    public void setPassword(String text){password.sendKeys(text);}
    public void setBirthday(){   birthday.click();   Select dropdown = new Select(birthday); dropdown.selectByIndex(1);}
    public void setBirthmonth(){ birthmonth.click();  Select dropdown2 = new Select(birthmonth);  dropdown2.selectByValue("1");}
    public void setBirthyear(){ birthyear.click();    Select dropdown3 = new Select(birthyear); dropdown3.selectByValue("1991"); }
    public void setNewsletter(){ newsletter.click();    }
   // public void enterFirstname( String text){     fname.sendKeys(text); }
   // public void enterlastname(String text){lname.sendKeys(text);}
    public void setAddress(String text){address.sendKeys(text);}
    public void setCity(String text){city.sendKeys(text);}
    public void setState(){  state.click();   Select dropdown = new Select(state); dropdown.selectByValue("1");}
    public void setZipcode(String text){
        zipcode.sendKeys(text);
    }

    public void setPhonenum(int text) {
        mobileNum.sendKeys(String.valueOf(text));
    }
    public void setAddressAlias(String text){
        addressAlias.clear();
        addressAlias.sendKeys(text);
    }
    public void setSignUpButton(){
        signUpButton.click();
    }
}
