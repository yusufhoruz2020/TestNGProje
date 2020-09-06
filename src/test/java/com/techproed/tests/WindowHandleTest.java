package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.getWindowHandle();
        String sayfaHandle = driver.getWindowHandle();
        System.out.println("birinici sayfa :" +sayfaHandle);
        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> tumPencereler =driver.getWindowHandles();

       // for (String handle: tumPencereler) {
        //    System.out.println(handle);
        //}
        //



        Object[] array = (Object[])tumPencereler.toArray();

        String ikinciSayfaHandle = array[array.length - 1].toString();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ikinciSayfaHandle);

        driver.switchTo().window(sayfaHandle);





    }


}
