package com.cct.avscan.service.impl;

import org.springframework.stereotype.Service;

import com.cct.avscan.exception.AntivirusException;
import com.cct.avscan.service.AntivirusScanner;

@Service
public class MATDScanner implements AntivirusScanner {

	@Override
	public boolean scanFile(String filePath) throws AntivirusException {
		return false;
	}

}
