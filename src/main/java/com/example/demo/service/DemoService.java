package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Class1DTO;
import com.example.demo.dto.Class2DTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {
	
	private final AsyncService1 service1;
	
	private final AsyncService2 service2;
	
	public void execute() throws Exception {
		CompletableFuture<Class1DTO> futureClass1 = service1.callExternalService()
				.exceptionally(e -> {
					log.error("[exceptionally1] Throw Exception");
					throw new RuntimeException(e);
				}).thenApplyAsync(c1 -> {
					log.info("[thenApplyAsync1] Validate client response");
					return c1;
				}).whenComplete((c1, e) -> {
					if (e == null) {
						log.info("[whenComplete1] Execution completed successfully");
					}
				});
		
		CompletableFuture<Class2DTO> futureClass2 = service2.callExternalServiceWithException()
				.exceptionally(e -> {
					log.error("[exceptionally2] Throw Exception");
					throw new RuntimeException(e);
				}).thenApplyAsync(c2 -> {
					log.info("[thenApplyAsync2] Validate client response");
					return c2;
				}).whenComplete((c2, e) -> {
					if (e == null) {
						log.info("[whenComplete2] Execution completed successfully");
					}
				});
		
		Class1DTO class1dto = futureClass1.join();
		Class2DTO class2dto = futureClass2.join();
		
		log.info("Class1: {}", class1dto);
		log.info("Class2: {}", class2dto);
	}

}
