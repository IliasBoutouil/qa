import org.example.config.Bootstrap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Bootstrap.class})
class ApplicationTest {
    @Autowired
    ApplicationContext context;

    @Test
    void contextTest()
    {
        Assertions.assertNotNull(context);
    }
}
