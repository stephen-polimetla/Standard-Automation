# Standard-Automation
Sample projects demonstrating different testing frameworks.

## Gradle Selenium 3 sample (JUnit + TestNG)

I added a Gradle build and sample Selenium tests that demonstrate running Selenium 3 with both JUnit 4 and TestNG.

What I added
- `build.gradle` - Gradle configuration with Selenium 3 (`3.141.59`), JUnit 4 and TestNG dependencies, plus a `testNg` task.
- `settings.gradle` - project name.
- `src/test/java/com/example/selenium/JUnitSeleniumTest.java` - sample JUnit 4 test using Chrome (headless).
- `src/test/java/com/example/selenium/TestNGSeleniumTest.java` - sample TestNG test using Chrome (headless).

Prerequisites
- Java JDK (8+).
- Chrome and chromedriver on PATH, or set the `webdriver.chrome.driver` system property to point to your chromedriver binary.

Run tests (PowerShell)
```powershell
# Run JUnit tests (default 'test' task)
gradle clean test

# Run TestNG tests (task added as 'testNg')
gradle testNg

# Run full verification (both test tasks: JUnit + TestNG)
gradle build
```

Notes
- I did not add the Gradle wrapper. If you'd like I can add the wrapper files (`gradlew`, `gradlew.bat`, `gradle/wrapper/*`) so contributors don't need a local Gradle install.
- If you prefer JUnit 5 (Jupiter) instead of JUnit 4, I can switch the example and Gradle configuration.
