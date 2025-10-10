package hw4.io.cucumber;

import org.junit.platform.suite.api.ConfigurationParametersResource;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectPackages("hw4.io.cucumber")
@ConfigurationParametersResource("cucumber.properties")
public class RunCucumberTest {
}
