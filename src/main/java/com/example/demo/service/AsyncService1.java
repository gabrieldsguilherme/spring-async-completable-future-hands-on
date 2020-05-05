package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Class1DTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService1 {
	
	@Async
	public CompletableFuture<Class1DTO> callExternalService() throws Exception {
		log.info("[1] Calling external service...");
		Thread.sleep(2000);
		log.info("[1] External service returns successfully!");

		return CompletableFuture.completedFuture(Class1DTO.builder()
				.id("123")
				.document("12312312312")
				.build());
	}

}
