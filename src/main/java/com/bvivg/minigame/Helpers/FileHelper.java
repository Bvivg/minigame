package com.bvivg.minigame.Helpers;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

public class FileHelper {

    private final String directory;
    private String fileName;
    private File file;

    private FileHelper(String directory) {
        this.directory = directory;
        this.fileName = null;
        this.file = null;
    }

    public static FileHelper path(String directory) {
        return new FileHelper(directory);
    }

    public FileHelper save(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File must not be empty");
        }

        Path dirPath = Paths.get(directory);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        this.fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = dirPath.resolve(fileName);

        try {
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new IOException("Error saving the file: " + e.getMessage(), e);
        }

        return this;
    }

    public String path() {
        if (fileName != null && !fileName.isEmpty()) {
            return directory + File.separator + fileName;
        }
        return directory;
    }

    public File get() {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            file = files[0];
        } else {
            file = null;
        }
        return file;
    }

    public void delete() {
        if (file != null && file.exists()) {
            if (!file.delete()) {
                throw new RuntimeException("Failed to delete the file: " + file.getAbsolutePath());
            }
        } else {
            throw new RuntimeException("File not found or already deleted.");
        }
    }

    public void update(MultipartFile newFile) throws IOException {
        if (this.file != null) {
            this.delete();
        }
        this.save(newFile);
    }
}
