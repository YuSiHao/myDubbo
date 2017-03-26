package com.ysh.dubbox.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
//@RestController
public class ProvideApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProvideApplication.class, args);
	}
	
}
