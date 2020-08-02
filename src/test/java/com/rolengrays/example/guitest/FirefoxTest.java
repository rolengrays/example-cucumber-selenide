package com.rolengrays.example.guitest;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// https://javadoc.io/doc/io.cucumber/cucumber-junit/latest/io/cucumber/junit/CucumberOptions.html
// https://javadoc.io/doc/io.cucumber/cucumber-core/latest/io/cucumber/core/options/Constants.html
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/firefox/firefox-reports.html"},
        features = {"classpath:com/rolengrays/example/guitest/features"},
        glue = {"com.rolengrays.example.guitest.step", "com.rolengrays.example.guitest.hook"}
)
public class FirefoxTest extends AbstractTest {
  @BeforeClass
  public static void beforeTest() {
    Configuration.browser = Browsers.FIREFOX;
    addSystemPropertiesFromFile(WEBDRIVERMANAGER_PROPERTIES);
    loadSelenideConfigFromFile(Browsers.FIREFOX + ".properties");
    logger.info(String.format("%sでテストを開始します。", Browsers.FIREFOX));
  }
}
