package com.pb.web.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {

    public static WebDriver driver;

    public ChromeOptions options;

    public BrowserDriver(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public void close(){
        this.driver.close();
    }
}
