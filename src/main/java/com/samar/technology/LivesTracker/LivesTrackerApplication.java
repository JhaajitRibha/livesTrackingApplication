package com.samar.technology.LivesTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.samar.technology.LivesTracker.beanController","com.samar.technology.LivesTracker.beanService","com.samar.technology.LivesTracker.config"
,"com.samar.technology.LivesTracker.controller","com.samar.technology.LivesTracker.service","com.samar.technology.LivesTracker.Dao.CommonDao","com.samar.technology.LivesTracker.controller.BlogController"})
@ImportResource("classpath:application-context.xml")
public class LivesTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivesTrackerApplication.class, args);
	}

}
