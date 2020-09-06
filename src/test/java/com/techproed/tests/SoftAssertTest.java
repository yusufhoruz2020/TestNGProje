package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

    /*
    Assert.assertTrue
    Assert.assertFalse
    Assert.assertEquals

    SoftAssert kullaniminin Hard Assert kullanimindan farklari:
    1. SoftAssert 'de eger test basarasizsa, kalan kisim da calisiyor
    2. SoftAssert classindan nesne olusturmak zorundayiz.
    3. SoftAssert te birden fazla dogrulama yapilabilir
    Assert -> Hardassert icin kullanilir. ( Assert.assertTrue() )
    Verify -> SoftAssert icin kullanilir. ( Soft.assertTrue () )
     */






public class SoftAssertTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);
        softAssert.assertAll(); // yukarıdaki yaptığımız tüm doğrulamalar
        // başarılı ise testimiz başarılı, değilse
        // testimiz başarısız.
        // HardAssert gibi
    }
    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert= new SoftAssert();
        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e){
           e.printStackTrace();
        }
        softAssert.assertTrue(driver.getTitle().equals("Deneme"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        WebElement passwordKutusu = driver.findElement(By.id("session_password"));
        passwordKutusu.sendKeys("Test1234!");

        softAssert.assertTrue(driver.getTitle().equals("Address book"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement signin = driver.findElement(By.name("commit"));
        signin.click();

        WebElement signOut = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunurMu = signOut.isDisplayed();
        //Assert.assertTrue(gorunurMu);

        softAssert.assertAll(); // kesinlikle olmali



    }



}
