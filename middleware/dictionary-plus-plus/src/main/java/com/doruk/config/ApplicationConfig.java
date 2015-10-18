package com.doruk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.doruk.service.DictionaryService;
import com.doruk.service.TurengService;
import com.doruk.service.ZarganService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.doruk" })
public class ApplicationConfig {

	@Bean
	public ApplicationBeanAware applicationBeanAware() {
		return new ApplicationBeanAware();
	}

	@Bean
	public DictionaryService tureng() {
		return new TurengService();
	}
	
	@Bean
	public DictionaryService zargan() {
		return new ZarganService();
	}
}
