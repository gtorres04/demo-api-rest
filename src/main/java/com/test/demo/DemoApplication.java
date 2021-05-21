package com.test.demo;

import com.test.demo.domain.annotation.DomainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class}))
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

}
