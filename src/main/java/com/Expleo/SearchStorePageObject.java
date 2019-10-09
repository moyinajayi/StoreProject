package com.Expleo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchStorePageObject{

   @FindBy(how = How.ID , using = "search_query_top")
    private WebElement search;

    public void setSearch(String text){
    //    search.clear();
        search.sendKeys(text);
        search.click();
    }


}
