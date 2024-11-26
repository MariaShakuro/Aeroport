package com.aviation.core.archiencrypt;

import java.io.*;
import java.util.jar.*;
import java.util.zip.*;

public class ArchiveUtils {

    // Метод для архивирования в ZIP
    public static void archiveFileToZip(String sourceFilePath, String zipFilePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(sourceFilePath)) {

            ZipEntry zipEntry = new ZipEntry(new File(sourceFilePath).getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }
    }

    // Метод для архивирования в JAR
    public static void archiveFileToJar(String sourceFilePath, String jarFilePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(jarFilePath);
             JarOutputStream jos = new JarOutputStream(fos);
             FileInputStream fis = new FileInputStream(sourceFilePath)) {

            JarEntry jarEntry = new JarEntry(new File(sourceFilePath).getName());
            jos.putNextEntry(jarEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                jos.write(buffer, 0, length);
            }
            jos.closeEntry();
        }
    }

    // Метод для разархивирования ZIP
    public static void extractZipFile(String zipFilePath, String destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File destFile = new File(destDir, zipEntry.getName());
                destFile.getParentFile().mkdirs();

                try (FileOutputStream fos = new FileOutputStream(destFile)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }
                zipEntry = zis.getNextEntry();
            }
        }
    }

    // Метод для разархивирования JAR
    public static void extractJarFile(String jarFilePath, String destDir) throws IOException {
        try (JarInputStream jis = new JarInputStream(new FileInputStream(jarFilePath))) {
            JarEntry jarEntry = jis.getNextJarEntry();
            while (jarEntry != null) {
                File destFile = new File(destDir, jarEntry.getName());
                destFile.getParentFile().mkdirs();

                try (FileOutputStream fos = new FileOutputStream(destFile)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = jis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }
                jarEntry = jis.getNextJarEntry();
            }
        }
    }
}

