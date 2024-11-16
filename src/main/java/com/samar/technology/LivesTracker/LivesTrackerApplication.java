package com.samar.technology.LivesTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableJpaRepositories(basePackages = "com.samar.technology.LivesTracker.repository")
@SpringBootApplication
@ComponentScan(basePackages = {"com.samar.technology.LivesTracker.beanController","com.samar.technology.LivesTracker.beanService","com.samar.technology.LivesTracker.config"
,"com.samar.technology.LivesTracker.controller","com.samar.technology.LivesTracker.service","com.samar.technology.LivesTracker.Dao.CommonDao","com.samar.technology.LivesTracker.controller.BlogController","com.samar.technology.LivesTracker"
,"com.samar.technology.LivesGTracker.service.FamilyService","com.samar.technology.LivesTracker.controller.FamilyController","com.samar.technology.LivesTracker.repository"})
@ImportResource("classpath:application-context.xml")
public class LivesTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivesTrackerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
		return restTemplate;
	}


}
