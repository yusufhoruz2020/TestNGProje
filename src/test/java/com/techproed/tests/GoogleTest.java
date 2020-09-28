package com.techproed.tests;

import com.techproed.pages.GooglePage;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void aramaTesti () {
        driver.get("http://google.com");

        //GooglePage class indan bir tane nesne olusturduk ve parametre olarak su an kullanidigimiz driveri gönderdik
        GooglePage googlePage = new GooglePage(driver);

        googlePage.aramaKutusu.sendKeys("Selamlar..");



    }
}
