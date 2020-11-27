package com.love.backend;

import com.love.backend.Repositories.LogRepository;
import com.love.backend.Services.ILoveService;
import com.love.backend.Services.LoveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoveBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveBackendApplication.class, args);
	}

	@Autowired
	public LogRepository logRepository;

	@Bean
	public ILoveService loveService() {
		return new LoveService(logRepository);
	}

}
