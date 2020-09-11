package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {
    @Test
    public void test01 () {
        giris();
        FhcTripHotelCreatePage fhcTripHotelCreatePage = new FhcTripHotelCreatePage(driver);
        fhcTripHotelCreatePage.kodKutusu.sendKeys("4545");
        fhcTripHotelCreatePage.adresKutusu.sendKeys("Son Sokak");
        fhcTripHotelCreatePage.emailKutusu.sendKeys("asdfg@yopmail.com");
        fhcTripHotelCreatePage.telefonKutusu.sendKeys("123464654654");
        fhcTripHotelCreatePage.nameKutusu.sendKeys("Tester2020");

        Select select = new Select(fhcTripHotelCreatePage.selectKutusu);
        select.selectByIndex(2);

        fhcTripHotelCreatePage.saveButonu.click();

    }
    public void giris() {
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

}
