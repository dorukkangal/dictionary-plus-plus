package com.doruk.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.doruk.gson.ExceptionExclusionStrategy;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.doruk" })
public class DispatcherConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(gsonHttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	@Bean
	public GsonHttpMessageConverter gsonHttpMessageConverter() {
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		converter.setGson(gson());
		return converter;
	}

	@Bean
	public Gson gson() {
		Gson gson = new GsonBuilder().setExclusionStrategies(exceptionExclusionStrategy()).create();
		return gson;
	}

	@Bean
	public ExclusionStrategy exceptionExclusionStrategy() {
		return new ExceptionExclusionStrategy();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
