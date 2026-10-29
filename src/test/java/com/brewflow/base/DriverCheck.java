
package com.brewflow.base;

public class DriverCheck {

    public static void main(String[] args) {

        Driver.initializeDriver();

        Driver.getDriver().get("https://coffee-cart.app/");

        System.out.println("Page title: "
                + Driver.getDriver().getTitle());

        Driver.quitDriver();
    }
}
