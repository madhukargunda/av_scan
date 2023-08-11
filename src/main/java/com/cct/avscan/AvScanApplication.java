package com.cct.avscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cct.avscan.scanner.AntivirusScanner;

@SpringBootApplication
public class AvScanApplication implements CommandLineRunner {

	@Value("${}")
	private String userName;

	@Value("${}")
	private String password;

	@Autowired
	private AntivirusScanner matdScanner;

	public static void main(String[] args) {
		SpringApplication.run(AvScanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1.Login into MATD with the user name and password
		String sessionId = matdScanner.login("username", "password");

		// 2.Perform the matd scanning
		matdScanner.scanFile(null, null, sessionId);
	}
}
