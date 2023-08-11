package com.cct.avscan.scanner.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cct.avscan.exception.AntivirusException;
import com.cct.avscan.scanner.AntivirusScanner;
import com.cct.avscan.service.AntivirusService;

@Service
public class MATDAntivirusScanner implements AntivirusScanner {

	@Autowired
	private AntivirusService matdRestapi;

	@Override
	public boolean scanFile(String filePath, String userType, String sessionId) throws AntivirusException {
		// perform the scanning logic
		return true;
	}

	@Override
	public String login(String userName, String password) throws Exception {
		// TODO Auto-generated method stub
		return matdRestapi.login(userName, password);
	}

}
