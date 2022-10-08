package com.cloudcomputing.CloudComputing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan({ "com.cloudcomputing"})
@EntityScan(basePackages= {"com.cloudcomputing.CloudComputing"})
public class CloudComputingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudComputingApplication.class, args);
		
	}

}
