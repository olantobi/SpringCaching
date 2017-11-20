package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.myapp.config.CacheConfig;
import com.myapp.config.CacheKeyGenerator;
import com.myapp.controller.ContactController;
import com.myapp.exception.RestExceptionHandler;
import com.myapp.repository.ContactRepository;
import com.myapp.service.ContactService;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableCaching
@ComponentScan(basePackageClasses = { ContactRepository.class, ContactService.class, ContactController.class,CacheConfig.class,CacheKeyGenerator.class,
		RestExceptionHandler.class})
public class SpringDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoAppApplication.class, args);
		System.out.println("Fast Forward");
		System.out.println("Fast Forward2");
		System.out.println("Fast Forward3");
		System.out.println("Master Added");
		System.out.println("Iftekhar Added");
		System.out.println("Dev branch Added");
		
		System.out.println("Dev branch 1");
		
		System.out.println("Dev branch 2");
		
		System.out.println("Dev branch 3");
		
	}
}																																																					