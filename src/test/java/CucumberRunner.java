import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/ins.feature"},

        glue = {"steps"},plugin = {"util.AllureReporter"})


public class CucumberRunner {

}