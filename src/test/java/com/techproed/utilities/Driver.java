package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // eger bir classtaki constuctor in access modifieri private olursa o class tan nesne uretilemez,
    // buna "Singleton class" adi verilir.
    private Driver() {

    }

    // WebDriver nesnemizi, static olarak olusturduk,
    // cunku program baslar baslamaz hafizada yer almasini istiyoruz

    static WebDriver driver;

    /*
    Programin herhangi bir yerinden getDriver() methodu cagrilarak hafiza STATIC olarak olusturulmus
       Driver nesnesine erisebiliriz. yani yeniden WebDriver nesnesi olusturmak zorunda degiliz
        Driver.getDriver()
        */


    public static WebDriver getDriver() {

        //eger driver nesnesi hafizada bossa , olusturulmamissa yeniden olusturmana gerek yok
        // eger null ise yeniden olusturabilirsin

        if (driver == null) {
            //EGER CHROME KULLANMAK ISTIYORSAK
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.chromedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;


            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        return driver;
    }

    public static void closeDriver() {
        // Eğer driver nesnesi NULL değilse, yani hafızada varsa
        if (driver != null) {
            driver.quit();  // driver'ı kapat
            driver = null;  // driver'ı hafızadan temizle.
        }
    }


}


