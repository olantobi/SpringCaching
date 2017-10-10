package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.myapp.config.CacheConfig;
import com.myapp.config.CacheKeyGenerator;
import com.myapp.controller.ContactController;
import com.myapp.repository.ContactRepository;
import com.myapp.service.ContactService;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackageClasses = { ContactRepository.class, ContactService.class, ContactController.class,CacheConfig.class,CacheKeyGenerator.class})
public class SpringDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoAppApplication.class, args);
	}
}