package dev.briancore22.couver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class CouverApplicationTests {

	@Test
	void contextLoads() {
	}

}
