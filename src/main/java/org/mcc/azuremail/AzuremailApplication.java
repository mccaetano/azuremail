package org.mcc.azuremail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class AzuremailApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzuremailApplication.class, args);
	}

}
