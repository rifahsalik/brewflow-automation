
package com.brewflow.base;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver driver;

    protected void initializeBrowserReference() {
        driver = Driver.getDriver();
    }
}
