# Contributing & Usage

This document contains full usage instructions, troubleshooting, and CI tips for the Standard-Automation project.

## What this project provides

- Standard Java project layout: `src/main/java`, `src/test/java`.
- `build.gradle` configured with:
  - Selenium 4.x (Selenium Manager enabled)
  - JUnit Jupiter (JUnit 5)
  - TestNG
  - Logback (SLF4J binding)
  - Java toolchain targeting Java 23
- Sample tests:
  - `src/test/java/com/example/selenium/JUnitSeleniumTest.java` — JUnit 5
  - `src/test/java/com/example/selenium/TestNGSeleniumTest.java` — TestNG
- Custom Gradle `testNg` task to run TestNG tests separately
- Gradle wrapper (`gradlew`, `gradlew.bat`, `gradle/wrapper/*`)

## Recent improvements

- Upgraded to Selenium 4.x so Selenium Manager can auto-resolve browser drivers at runtime (reduces manual chromedriver management).
- Converted JUnit sample to JUnit 5 and ensured the JUnit Platform launcher & engine are available at test runtime.
- Added a dedicated `testNg` Gradle task wired to the test source set so TestNG tests are executed reliably.
- Added Logback and `logback.xml` so SLF4J has a proper runtime binding and logs are formatted.
- Added the Gradle wrapper for reproducible builds.

## Prerequisites

- Java JDK 23 (or adjust the Gradle toolchain in `build.gradle` to match an installed JDK).
- Chrome or a Chromium-based browser installed.
- Network access during the first run so Selenium Manager can download the matching driver.

Optional alternatives:
- If you prefer to manage drivers manually, install `chromedriver` and add it to `PATH`, or set the `webdriver.chrome.driver` system property.
- Alternatively, you can use `WebDriverManager` (third-party) if you want explicit driver management.

## How to run tests (PowerShell)

Use the Gradle wrapper (recommended):

```powershell
# Run JUnit (JUnit 5) tests
.\gradlew.bat clean test

# Run TestNG tests
.\gradlew.bat testNg

# Run full verification (both JUnit + TestNG)
.\gradlew.bat build
```

If you have Gradle installed globally, you can replace `./gradlew.bat` with `gradle`.

## Reports and results

- JUnit results: `build/test-results/test` and `build/reports/tests/test`.
- TestNG results: `build/test-results/testNg` and `build/reports/tests/testNg`.

## Chrome flags & CI tips

- The sample tests use headless Chrome flags for CI compatibility. For example: `--headless=new`, `--no-sandbox`, `--disable-dev-shm-usage`.
- In containerized CI environments, `--disable-dev-shm-usage` and `--no-sandbox` often help avoid crashes.
- Selenium Manager requires network access to download drivers. In air-gapped CI, pre-provision the driver or cache the driver.

## Logging

- The project includes Logback (`logback-classic`) and a default `logback.xml` in `src/main/resources` so SLF4J logs are captured and formatted. If you only want logging for tests, move `logback.xml` to `src/test/resources`.

## Troubleshooting

- "Could not start Gradle Test Executor: Failed to load JUnit Platform" — ensure `junit-jupiter-engine` and `junit-platform-launcher` are present on the test runtime classpath (this build config includes them).
- "The path to the driver executable must be set" — either rely on Selenium Manager (Selenium 4.x) or install `chromedriver` on PATH, set `webdriver.chrome.driver`, or use WebDriverManager.
- SLF4J `StaticLoggerBinder` warnings — resolved by including Logback.

## CI / Automation suggestions

- Use the Gradle wrapper in CI to ensure consistent Gradle version: `./gradlew build`.
- Ensure the CI runner has JDK 23 or adjust the `java.toolchain` setting in `build.gradle`.
- If your CI environment is air-gapped, pre-install the matching driver or cache the driver — Selenium Manager requires network access the first time to download a driver.

## Files of interest

- `build.gradle` — Gradle configuration
- `settings.gradle` — project name
- `gradlew`, `gradlew.bat`, `gradle/wrapper/*` — Gradle wrapper
- `src/test/java/com/example/selenium/JUnitSeleniumTest.java`
- `src/test/java/com/example/selenium/TestNGSeleniumTest.java`
- `src/main/resources/logback.xml`

## Contributing

If you add new tests or change dependency versions, please run both `./gradlew test` and `./gradlew testNg` locally (or via CI) to ensure both build paths remain valid.

If you want help adding WebDriverManager, improving CI, or making Chrome flags configurable via environment variables, open an issue or a PR and I can help.
