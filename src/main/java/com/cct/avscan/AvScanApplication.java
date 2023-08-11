package com.cct.avscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AvScanApplication implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	

	public static void main(String[] args) {
		SpringApplication.run(AvScanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Step 1: Make the first API request
		ResponseEntity<?> firstResponse = restTemplate.getForEntity("https://api.example.com/first", Class.class);
		firstResponse.getBody();

		// Step 2: Use the first API request and call the second api
		ResponseEntity<?> secondResponse = restTemplate.getForEntity("https://api.example.com/second/", Class.class);
		secondResponse.getBody();
	
		//Step 3: consuming the long polling API		
		while (true) {
			ResponseEntity<String> response = restTemplate.getForEntity("", String.class);
			String responseData = response.getBody();
			System.out.println("Received response: " + responseData);

			// Add a delay to control the frequency of requests
			try {
				Thread.sleep(5000); // Wait for 5 seconds before the next request
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
		
		// Step 4: Consuming the AV Scan status API 
		// Step 2: Use the first API request and call the second api
		ResponseEntity<?> fourthResponse = restTemplate.getForEntity("https://api.example.com/second/", Class.class);
		fourthResponse.getBody();		

	}
}
