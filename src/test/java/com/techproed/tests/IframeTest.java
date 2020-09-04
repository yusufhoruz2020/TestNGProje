package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest1() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // index ile iframe e
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest2() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //id attribute kullanrarak da iframe e gecis yapabiliriz

        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

    }
    @Test
    public void iframeTest3() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        /*
        <iframe id="mce_0_ifr" src="javascript:&quot;&quot;" frameborder="0" allowtransparency="true"
        title="Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help"
        style="width: 100%; height: 100px; display: block;" cd_frame_id_="1f36f66b910b7f19fdff75dff54ffb6e"></iframe>
         */
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest4() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // index ile iframe e
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

        // switch.to() ile frame e gecis yaptik, daha sonra default content e gecis yapabiliyoruz
        driver.switchTo().defaultContent();

        WebElement selenium = driver.findElement(By.partialLinkText("Elemental Selenium"));
        selenium.click();
    }
}
