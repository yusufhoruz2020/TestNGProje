package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonNewPage {

    public AmazonNewPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id ="twotabsearchtextbox")
    public WebElement aramaKutusu;

    // <input type="submit" class="nav-input" value="Go" tabindex="20">
    @FindBy (xpath ="//input[@value='Go']")
    public WebElement aramaButonu;


}
