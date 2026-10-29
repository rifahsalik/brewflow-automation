
package com.brewflow.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.brewflow.base.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static final Logger logger =
            LogManager.getLogger(Hooks.class);

    @Before
    public void openBrowser() {
        logger.info("Starting browser");
        Driver.initializeDriver();
    }

    @After
    public void closeBrowser(Scenario scenario) {

        WebDriver driver = Driver.getDriver();

        try {
            if (scenario.isFailed() && driver != null) {

                File screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                Path folder = Paths.get("screenshots");
                Files.createDirectories(folder);

                String fileName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9-_]", "_");

                Path destination = folder.resolve(fileName + ".png");

                Files.copy(
                        screenshot.toPath(),
                        destination,
                        StandardCopyOption.REPLACE_EXISTING
                );

                logger.error("Scenario failed: {}. Screenshot saved to {}",
                        scenario.getName(), destination);

                byte[] screenshotBytes =
                        Files.readAllBytes(destination);

                scenario.attach(
                        screenshotBytes,
                        "image/png",
                        "Failure Screenshot"
                );
            }

        } catch (IOException | RuntimeException e) {
            logger.error("Could not capture failure screenshot", e);

        } finally {
            Driver.quitDriver();
            logger.info("Browser closed");
        }
    }
}
