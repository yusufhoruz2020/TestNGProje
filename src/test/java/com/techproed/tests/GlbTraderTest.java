package com.techproed.tests;

import com.techproed.pages.GlbTraderPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {

    @Test
    public void glbAramaTesti () {
        /*




         */

        extentTest = extentReports.createTest("GlbTrader Arama ", "Glb'de 'camera' aramasi yapildi.");
        extentTest.info("sayfa adresine git");
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_search"));
        extentTest.info("Webelementleri kullanabilmek icin nesne olustur.");
        GlbTraderPage glbTraderPage = new GlbTraderPage();
        extentTest.info("kategorilerden secim yaptik");
        Select select = new  Select(glbTraderPage.kategoriler);
        select.selectByIndex(6);
        extentTest.info("'camera' aramasi yap.");
        glbTraderPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("glb_kelime")+ Keys.ENTER);

        String urunIsmi = glbTraderPage.sonuclarListe.get(1).getText();

        glbTraderPage.sonuclarListe.get(1).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.info("Sayfa başlığını aldık.");
        String sayfaBasligi = Driver.getDriver().getTitle();
        extentTest.info("Assert işlemi yapalım.");
        Assert.assertEquals(urunIsmi , sayfaBasligi);
        extentTest.pass("Testimiz PASSED !");


    }

}
