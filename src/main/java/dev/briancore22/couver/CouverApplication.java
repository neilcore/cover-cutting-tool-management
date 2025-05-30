package dev.briancore22.couver;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class CouverApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CouverApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@GetMapping
	public ResponseEntity<String> defaultResponse() {
		return ResponseEntity.ok("Couver API is running");
	}

}
