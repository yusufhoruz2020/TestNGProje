package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {

    @Test
    public void girisTesti () {
        driver.get("http://facebook.com");

        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        // onceden bu sekilde email ve sifremizi yollayabilirdik, artik properties dosyasina yazip ordan alacagiz
        loginPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("fb_email"));
        loginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("fb_pass"));



    }

}
