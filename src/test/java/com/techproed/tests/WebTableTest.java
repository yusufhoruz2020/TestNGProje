package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {
    /*
    http://fhctrip-qa.com/admin/HotelRoomAdmin
    ○ Username : manager2
    ○ Password : Man1ager2!
    */

    public void giris() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void tumSatirlar() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement satir : tumSatirlar) {
            System.out.println(satir.getText());
        }
    }

    @Test
    public void webTable() throws InterruptedException {
        giris();
        Thread.sleep(3000);

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        // Tüm başlıkları alabiliriz.
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar) {
            System.out.println(baslik.getText());
        }

    }

    @Test
    public void tumHucreler() throws InterruptedException {
        giris();
        Thread.sleep(3000);

        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement hucre : tumHucreler) {
            System.out.println(hucre.getText());
        }

    }

    @Test
    public void belirliBirSutun() throws InterruptedException {

            /*
            //tbody/tr/td[4] -> biurada 4. sutunu yazdiriyoruz
            // buradaki  4 sayisini degistirerek istedigimiz kolon'u sutunu yazdirabiliriz
             */
        giris();
        Thread.sleep(3000);
        List<WebElement> dorduncuSutun = driver.findElements(By.xpath("tbody/tr/td[4]"));
        for (WebElement veri : dorduncuSutun) {
            System.out.println(veri.getText());
        }

    }
    @Test
    public void calistir() {
        giris();
        hucreYazdir(3,5);
        hucreYazdir(5,6);
        hucreYazdir(2,4);
        hucreYazdir(9,2);

    }
    public void hucreYazdir ( int satir, int sutun){
        //tbody/tr/td[2]
        String xpathDegerim = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());
    }


}
