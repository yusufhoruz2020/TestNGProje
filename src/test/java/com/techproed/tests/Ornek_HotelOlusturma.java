package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    public void giris(){
        /*
        http://www.fhctrip-qa.com/admin/HotelAdmin/Create
        a. Username : manager2
        b. Password : Man1ager2!
         */
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void hotelCreate(){
        driver.findElement(By.id("Code")).sendKeys("892020");
        driver.findElement(By.id("Name")).sendKeys("TechPro");
        driver.findElement(By.id("Address")).sendKeys("Almanya");
        driver.findElement(By.id("Phone")).sendKeys("012364584545");
        driver.findElement(By.id("Email")).sendKeys("asdfg@yopmail.com");

        WebElement dropDown = driver.findElement(By.id("IDGroup"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        driver.findElement(By.id("btnSubmit")).submit();

        //WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());

    }

}
