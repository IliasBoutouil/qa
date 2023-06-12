import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefiniton"
)
@RunWith(Cucumber.class)
public class CucumberTest {
}
