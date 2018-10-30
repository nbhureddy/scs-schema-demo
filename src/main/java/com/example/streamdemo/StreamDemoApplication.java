package com.example.streamdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@SpringBootApplication
@EnableSchemaRegistryClient
public class StreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamDemoApplication.class, args);
	}
}
