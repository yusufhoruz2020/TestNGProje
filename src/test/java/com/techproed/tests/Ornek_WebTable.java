package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

        // 1. "http://fhctrip-qa.com/admin/HotelRoomAdmin" bu adrese gidiniz.
        // 2. Tbody'nin içerisinde kaç satır var, satır sayısını ekrana yazdırınız.
        //    tbody/tr -> findElements
        // 3. Üçüncü satırdaki verileri ekrana yazdırınız.
        //    tbody/tr[3]
public class Ornek_WebTable extends TestBase {
    public void giris() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }


    @Test
    public void test() throws InterruptedException {
        giris();
        Thread.sleep(3000);

        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Tabloda" + tumSatirlar.size()+ "adet satir vardir");

        //tbody/tr[3] yazarsak... ucuncu satirdaki verileri ekrana yazdirabiliriz.
        WebElement ucuncuSatir = driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(ucuncuSatir.getText());
    }
}
