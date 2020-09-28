package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.testng.annotations.Test;

public class JSExecuterTest {

    @Test
    public void amazonArama () throws InterruptedException {
        Driver.getDriver().get("http://amazon.com");


        // JS ile bir web sayfasinin basligini alabiliyoruz
        String baslik = JSExecutor.getTitleByJS();
        System.out.println(baslik);

        AmazonNewPage amazonNewPage = new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("samsung");

        // JS ile bir Webelemente bu sekilde tiklayabiliyoruz
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);

        // JS ile bir websayfasinin en altina gidebiliyoruz

        Thread.sleep(3000);
        JSExecutor.scrollDownByJS();

        //


    }
}
