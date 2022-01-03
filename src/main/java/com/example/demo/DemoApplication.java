package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	@Autowired
	DemoRepository demoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		DemoEvent event = new DemoEvent();
		event.setUuid(UUID.randomUUID().toString());
		event.setTimestamp(Date.from(Instant.now().plusSeconds(3600)));
		demoRepository.save(event);

		demoRepository.findByTimestampAfter(new Date()).forEach(e -> System.out.println(e.getUuid()));
	}
}
