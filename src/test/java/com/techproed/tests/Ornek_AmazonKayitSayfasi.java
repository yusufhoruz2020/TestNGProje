package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase { // Day 14 , 6 Eylül 2020 Pazar
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement element = driver.findElement(By.partialLinkText("Start here"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.partialLinkText("Start here.")).click();

       //Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));

        // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));

        Assert.assertEquals("Amazon Registration",driver.getTitle());

    }
    @Test
    public void account() {
        driver.get("http://amazon.com");
        driver.findElement(By.partialLinkText("Start here")).click();
        driver.findElement(By.id("ap_customer_name")).sendKeys("tester2020");
        driver.findElement(By.id("ap_email")).sendKeys("qaywsxedc@yopmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("123456789,");
        driver.findElement(By.id("ap_password_check")).sendKeys("123456789,"+ Keys.ENTER);
    }





}
