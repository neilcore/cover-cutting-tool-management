package dev.briancore22.couver;

import org.springframework.boot.SpringApplication;

public class TestCouverApplication {

	public static void main(String[] args) {
		SpringApplication.from(CouverApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
