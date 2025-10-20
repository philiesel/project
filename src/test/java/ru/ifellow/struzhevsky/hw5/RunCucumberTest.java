package ru.ifellow.struzhevsky.hw5;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("ru.ifellow.struzhevsky.hw5")
@ConfigurationParametersResource("classpath:cucumber.properties")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@tag")
public class RunCucumberTest {
}
