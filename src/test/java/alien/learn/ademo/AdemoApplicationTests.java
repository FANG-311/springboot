package alien.learn.ademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = { "serve" })
@SpringBootTest
class AdemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
