# BrewFlow Automation Framework

## Project Overview
BrewFlow is a web UI automation framework for testing the Coffee Cart application using Selenium WebDriver, Cucumber BDD, TestNG, and Maven.

## Technology Stack
- Java
- Selenium WebDriver
- Selenium Grid
- Cucumber BDD (Gherkin)
- TestNG
- Maven
- Log4j 2
- Allure Reports

## Framework Features
- Page Object Model (POM)
- Cucumber feature files and step definitions
- Explicit waits and assertions
- Thread-safe WebDriver management
- Selenium Grid remote browser execution
- Parallel scenario execution
- Log4j logging
- Failure screenshot capture and Cucumber scenario attachments
- Allure HTML reporting

## Application Under Test
https://coffee-cart.app/

## Prerequisites
- Java JDK
- Maven
- Google Chrome
- Selenium Server 4.51.0 for Grid execution

## Running the Tests
1. Start Selenium Grid in a terminal:
   `java -jar selenium-server-4.51.0.jar standalone`
2. Open a second terminal in the project directory.
3. Run:
   `mvn clean test`

## Generating the Allure Report
Run:
`mvn io.qameta.allure:allure-maven:2.15.0:report`

Open the generated report using:
`".allure\allure-2.30.0\bin\allure.bat" open target\allure-report`

## Project Structure
- `src/test/java/com/brewflow/base` — WebDriver setup
- `src/test/java/com/brewflow/pages` — Page Object classes
- `src/test/java/com/brewflow/stepdefinitions` — Cucumber step definitions
- `src/test/java/com/brewflow/hooks` — Browser hooks and failure screenshots
- `src/test/java/com/brewflow/runners` — Cucumber TestNG runner
- `src/test/resources/features` — Gherkin feature files
- `allure-results` — Raw Allure test results
- `target/allure-report` — Generated HTML report
- `logs` — Application logs

## Notes
Selenium Grid must be running before executing tests with the current remote WebDriver configuration. Failure screenshots are captured when a scenario fails, provided the browser session is still available.
