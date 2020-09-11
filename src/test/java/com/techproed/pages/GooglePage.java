package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {

    // bos bir tane driver degiskeni olusturduk

    WebDriver driver;
   public GooglePage (WebDriver driver) {
    //parametre olarak gelen driver nesenesini, bu class'ta olusturdugumuz
       //  driver nesnesine esitledik. bu sekilde yeniden bos bir olusturmek yerine ,
       // zaten halihazirda var olan kullandigimiz driveri bu nesney esitlemis olduk

       this.driver = driver;


       // birazdan bulacagimiz webelementleri hazir hale getirdik
       PageFactory.initElements(driver,this);
   }
    @FindBy (name = "q")
    public WebElement aramaKutusu;  //findElement

   @FindBy (xpath = "//tbody/tr")
    public List<WebElement> liste ; // findelements ('s' harfine dikkat

}
