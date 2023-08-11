package com.cct.avscan.runnner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cct.avscan.exception.AntivirusException;
import com.cct.avscan.service.impl.MATDScanner;

@Component
public class AVScanCommandLineRunner implements CommandLineRunner {

	@Autowired
	MATDScanner scanner;

	@Override
	public void run(String... args) throws Exception {

		try {
			boolean isClean = scanner.scanFile("");
			if (isClean) {
				System.out.println("File is clean.");
			} else {
				System.out.println("Viruses found in the file.");
			}
		} catch (AntivirusException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
