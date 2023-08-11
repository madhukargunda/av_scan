package com.cct.avscan.scanner;

import com.cct.avscan.exception.AntivirusException;

public interface AntivirusScanner {
	/**
	 * Scan a file for viruses.
	 *
	 * @param filePath The path to the file to be scanned.
	 * @return True if the file is clean (no viruses found), false if viruses are
	 *         detected.
	 * @throws AntivirusException If an error occurs during the scanning process.
	 */
	boolean scanFile(String filePath, String userType, String sessionId) throws AntivirusException;

	String login(String userName, String password) throws Exception;
}
