package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();
        // sayfada eger Alert varsa o alerte gecis yapmamiz lazim.
        // mesaji ekrana yazdirdik
        String alertMesaji =driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        // ok butonuna tiklamak icin asagidaki methodu kullaniriz
        driver.switchTo().alert().accept();
    }
    @Test
    public void jsConfitmTest (){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirmButtoon = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButtoon.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        driver.switchTo().alert().dismiss();
    }
    @Test
    public void jsPromtTest () {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement promtButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promtButton.click();
        String promtMesaji =driver.switchTo().alert().getText();
        System.out.println(promtMesaji);

        driver.switchTo().alert().sendKeys("Merhaba Selenium");
        driver.switchTo().alert().accept();
    }


}
