package com.uMind.uMind;

import com.uMind.uMind.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class UMindApplication {
	public static void main(String[] args) {
		SpringApplication.run(UMindApplication.class, args);
	}
}
