package ru.ifellow.struzhevsky.hw5;

import org.junit.platform.suite.api.ConfigurationParametersResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("ru.ifellow.struzhevsky.hw5")
@ConfigurationParametersResource("classpath:cucumber.properties")
public class RunCucumberTest {
}
