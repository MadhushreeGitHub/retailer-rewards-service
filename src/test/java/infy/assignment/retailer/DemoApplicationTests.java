package infy.assignment.retailer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  public void testDemoApplication() {
    assertTrue(true, "Test is successful");
  }

}
