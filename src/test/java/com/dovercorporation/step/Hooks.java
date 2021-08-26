package com.dovercorporation.step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends DriverBase {


    @Before
    public void onSetup(){
        //System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
