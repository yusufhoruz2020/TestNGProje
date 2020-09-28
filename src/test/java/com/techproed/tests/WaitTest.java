package com.techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlywait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();

        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
        /*
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("...")));
        */
    }
    @Test
    public void explicitWait () {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        // Explicitly Wait kullanmak icn  WebdriverWait class'indan nesne uretmek zorundayiz
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();

        WebElement itsgone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(itsgone.getText());





    }
}
