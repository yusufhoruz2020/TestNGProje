package com.techproed.tests;

import com.techproed.pages.FhcTripLoginNewPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideTest1 {

    @Test
    public void loginTest (String kullanici, String sifre) {
        Driver.getDriver().get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginNewPage loginNewPage = new FhcTripLoginNewPage();
        loginNewPage.userName.sendKeys("manager2");
        loginNewPage.password.sendKeys("Man1ager2!");
        loginNewPage.login.click();


    }

    @DataProvider ( name = "bilgiler")
    public Object [] [] getBilgiler () {
        Object [][] array = new Object[3][2];
        array[0][0] = "manage";
        array[0][1] = "sifre";

        array[1][0] = "manager2";
        array[1][1] = "sifre";

        array[2][0] = "manage2";
        array[2][1] = "Man1ager2!";

        return array;

    }


}

