package com.sogeti.step_definitions;

import com.sogeti.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            System.out.println("Test failed! Check your ScreenShot");
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs((OutputType.BYTES));
            scenario.attach(screenshot, "image/png", "screenshot");
        }else {
            System.out.println("Test is completed!");
        }
        System.out.println("##### THE END #####");
        Driver.closeDriver();
    }

}
