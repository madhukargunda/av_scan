package com.cct.avscan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cct.avscan.service.AntivirusService;

@Service
public class MATDRestAPIAntivirusService implements AntivirusService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String login(String username, String password) {

		// Step 1: Make the first API request
		ResponseEntity<?> firstResponse = restTemplate.getForEntity("https://api.example.com/first", Class.class);
		firstResponse.getBody();
		return "";
	}

	@Override
	public String submitFileForScan(String filePath) {
		// Step 2: Use the first API request and call the second api
		ResponseEntity<?> secondResponse = restTemplate.getForEntity("https://api.example.com/second/", Class.class);
		secondResponse.getBody();
		return null;
	}

	@Override
	public String getScanStatus(String scanId) {
		// Step 3: consuming the long polling API
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
		return null;
	}

	@Override
	public String getScanResult(String scanId) {
		// Step 2: Use the first API request and call the second api
		ResponseEntity<?> fourthResponse = restTemplate.getForEntity("https://api.example.com/second/", Class.class);
		fourthResponse.getBody();

		return null;
	}

}
