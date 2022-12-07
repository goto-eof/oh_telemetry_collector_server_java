package org.isf.telemetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:settings.properties")
@SpringBootApplication
public class OhTelemetryCollectorJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhTelemetryCollectorJavaApplication.class, args);
	}

}
