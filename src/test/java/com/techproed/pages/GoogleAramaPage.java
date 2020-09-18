package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleAramaPage {

        public GoogleAramaPage () {

            PageFactory.initElements(Driver.getDriver(),this);


        }
        @FindBy ( name = "q")
        public WebElement aramaKutusu;


        // sayfdadaki butum linkleri almak icin tagName i a olan tüm webelementlwei bulmak icin
        @FindBy ( tagName = "a"     )
        public List<WebElement> tumLinkler;




}
