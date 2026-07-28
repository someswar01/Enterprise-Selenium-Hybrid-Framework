package utilities;

import config.ConfigReader;

import java.io.File;
import java.time.Duration;

public final class DownloadUtils {

    /**
     * Default download directory.
     */
    private static final String DOWNLOAD_PATH =
            ConfigReader.getDownloadPath();
    /**
     * Private constructor to prevent instantiation.
     */
    private DownloadUtils() {
        throw new UnsupportedOperationException(
                "DownloadUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Checks whether a file exists in the default download directory.
     *
     * @param fileName File name
     * @return true if file exists
     */
    public static boolean isFileDownloaded(String fileName) {

        File file = new File(DOWNLOAD_PATH, fileName);

        return file.exists();
    }

    /**
     * Waits until a file is downloaded.
     *
     * @param fileName File name
     * @param timeout Timeout in seconds
     * @return true if downloaded within timeout
     */
    public static boolean waitForDownload(String fileName, int timeout) {

        File file = new File(DOWNLOAD_PATH, fileName);

        long endTime = System.currentTimeMillis()
                + Duration.ofSeconds(timeout).toMillis();

        while (System.currentTimeMillis() < endTime) {

            if (file.exists()) {

                return true;
            }

            try {

                Thread.sleep(500);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                return false;
            }
        }

        return false;
    }

    /**
     * Deletes a downloaded file.
     *
     * @param fileName File name
     * @return true if deleted
     */
    public static boolean deleteFile(String fileName) {

        File file = new File(DOWNLOAD_PATH, fileName);

        return file.exists() && file.delete();
    }

    /**
     * Returns the size of a downloaded file.
     *
     * @param fileName File name
     * @return File size in bytes
     */
    public static long getFileSize(String fileName) {

        File file = new File(DOWNLOAD_PATH, fileName);

        return file.exists() ? file.length() : 0;
    }

    /**
     * Returns the default download directory.
     *
     * @return Download directory
     */
    public static String getDownloadDirectory() {

        return DOWNLOAD_PATH;
    }
}