package com.aviation.core.archiencrypt;

import java.io.IOException;

public class FileProcessor {

    public static void processFile(String sourceFilePath, String destFilePath, String key, boolean encryptFirst, boolean archiveFirst, String archiveFormat) throws Exception {
        boolean isZip = "zip".equalsIgnoreCase(archiveFormat);
        boolean isJar = "jar".equalsIgnoreCase(archiveFormat);

        if (archiveFirst) {
            if (encryptFirst) {
                // Архивирование -> Шифрование
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath, destFilePath + ".zip");
                    String encryptedData = Encryption.encrypt(readFileAsString(destFilePath + ".zip"), key);
                    writeFile(destFilePath, encryptedData);
                } else if (isJar) {
                    ArchiveUtils.archiveFileToJar(sourceFilePath, destFilePath + ".jar");
                    String encryptedData = Encryption.encrypt(readFileAsString(destFilePath + ".jar"), key);
                    writeFile(destFilePath, encryptedData);
                }
            } else {
                // Шифрование -> Архивирование
                String encryptedData = Encryption.encrypt(readFileAsString(sourceFilePath), key);
                writeFile(sourceFilePath + ".enc", encryptedData);
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath + ".enc", destFilePath + ".zip");
                } else if (isJar) {
                    ArchiveUtils.archiveFileToJar(sourceFilePath + ".enc", destFilePath + ".jar");
                }
            }
        } else {
            if (encryptFirst) {
                // Шифрование -> Архивирование
                String encryptedData = Encryption.encrypt(readFileAsString(sourceFilePath), key);
                writeFile(sourceFilePath + ".enc", encryptedData);
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath + ".enc", destFilePath + ".zip");
                } else if (isJar) {
                    ArchiveUtils.archiveFileToJar(sourceFilePath + ".enc", destFilePath + ".jar");
                }
            } else {
                // Архивирование -> Шифрование
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath, destFilePath + ".zip");
                    String encryptedData = Encryption.encrypt(readFileAsString(destFilePath + ".zip"), key);
                    writeFile(destFilePath, encryptedData);
                } else if (isJar) {
                    ArchiveUtils.archiveFileToJar(sourceFilePath, destFilePath + ".jar");
                    String encryptedData = Encryption.encrypt(readFileAsString(destFilePath + ".jar"), key);
                    writeFile(destFilePath, encryptedData);
                }
            }
        }
    }

    private static String readFileAsString(String filePath) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));
    }

    private static void writeFile(String filePath, String data) throws IOException {
        java.nio.file.Files.write(java.nio.file.Paths.get(filePath), data.getBytes());
    }
}

