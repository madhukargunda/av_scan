package com.cct.avscan.service;

public interface AntivirusService {
    /**
     * Log in to the antivirus service.
     *
     * @param username The username for authentication.
     * @param password The password for authentication.
     * @return True if the login is successful, false otherwise.
     */
    boolean login(String username, String password);

    /**
     * Submit a file for scanning.
     *
     * @param filePath The path to the file to be scanned.
     * @return A unique scan ID for tracking the scan.
     */
    String submitFileForScan(String filePath);

    /**
     * Get the scan status for a given scan ID.
     *
     * @param scanId The unique scan ID.
     * @return The current status of the scan (e.g., "in_progress", "completed").
     */
    String getScanStatus(String scanId);

    /**
     * Get the result of the antivirus scan for a given scan ID.
     *
     * @param scanId The unique scan ID.
     * @return The result of the scan (e.g., "clean", "infected").
     */
    String getScanResult(String scanId);
}
