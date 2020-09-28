package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripHotelRoomCreateTest extends TestBase {
    public void giris(){
        driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }
    @Test
    public void test01(){
        // ConfigurationReader class'ına diyoruzki, .properties dosyasının içerisindeki
        // room_create_url (anahtarının) değerini al.
        //room_create_url = http://fhctrip-qa.com/admin/HotelroomAdmin/Create
        driver.get(ConfigurationReader.getProperty("room_create_url"));
        giris();
        FhcTripHotelRoomCreatePage page = new FhcTripHotelRoomCreatePage(driver);

        Select select = new Select(page.idHotelDropDown);
        select.selectByIndex(3);

        page.codeKutusu.sendKeys("13235");
    page.nameKutusu.sendKeys("RahatOtel");
    page.locationKutusu.sendKeys("Almanya");
    page.descKutusu.sendKeys("SonOda");


   Actions actions = new Actions(driver);
   actions.dragAndDrop(page.price500,page.priceKutusu).perform();

   Select select1 = new Select(page.idGroupRoomTypeDropDown);
   select1.selectByIndex(2);

   page.maxAdult.sendKeys("3");
   page.maxChild.sendKeys("5");
   page.saveButonu.click();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e){
        e.printStackTrace();
    }
        System.out.println(page.basariliYazisi.getText());

   boolean basarliMi = page.basariliYazisi.isDisplayed();
        Assert.assertTrue(basarliMi);







    }

}
