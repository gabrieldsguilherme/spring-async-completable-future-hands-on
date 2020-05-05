package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Class2DTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService2 {
	
	@Async
	public CompletableFuture<Class2DTO> callExternalService() throws Exception {
		log.info("[2] Calling external service...");
		Thread.sleep(1000);
		log.info("[2] External service returns successfully!");
		
		return CompletableFuture.completedFuture(Class2DTO.builder()
				.id("321")
				.name("First Name")
				.build());
	}
	
	@Async
	public CompletableFuture<Class2DTO> callExternalServiceWithException() throws Exception {
		log.info("[2EX] Calling external service...");
		Thread.sleep(1000);
		log.info("[2EX] External service returns with exception!");
		
		throw new RuntimeException("Error on async service 2!");
	}

}
