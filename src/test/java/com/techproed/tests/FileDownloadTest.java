package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);
    }
    @Test
    public void dosyaUpload() { // bilgisayardan websayfasina dosya yukleme
        //C:\Users\Sibi\Desktop
        driver.get("http://the-internet.herokuapp.com/upload");
       WebElement dosyaSec = driver.findElement(By.id("file-upload"));

       // yuklemek istedigimiz dosyanin , path (dosya yolunu) ekleyelim

        dosyaSec.sendKeys("C:/Users/Sibi/Desktop/logo.png");
        driver.findElement(By.id("file-submit")).click();

        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }
    @Test
    public void dosyaDownload () throws InterruptedException {




        driver.get("http://the-internet.herokuapp.com/download");

        WebElement amsterdam = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdam.click();
        Thread.sleep(3000);

        boolean varMi  = Files.exists(Paths.get("C:\\Users\\Sibi\\Downloads\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }




}
