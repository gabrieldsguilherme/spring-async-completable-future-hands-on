package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DemoRunner implements CommandLineRunner {
	
	private final DemoService demoService;

	@Override
	public void run(String... args) throws Exception {
		demoService.execute();
	}

}
