package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.GWD;


@CucumberOptions
        (
                tags = "@SmokeTest",
                features = {"src/test/java/FeatureFiles/"},
                glue = {"stepDefinitions"},
                plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
                monochrome=true,
                dryRun = false
        )
public class IMDB_Runner extends AbstractTestNGCucumberTests {

        @BeforeClass(alwaysRun = true) // bazı java versiyon hataları için
        @Parameters("browser")
        public void beforeClass(String browser)
        {
                GWD.threadBrowserName.set(browser);
                //burada browser set edilecek
                // bu threade browsername set edildi.
        }
}
