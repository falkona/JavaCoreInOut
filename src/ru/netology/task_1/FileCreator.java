package ru.netology.task_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCreator {

    private List<File> fileList;
    private StringBuilder logger;

    public FileCreator() {
        this.fileList = new ArrayList<>();
        this.logger = new StringBuilder();
    }

    public String getLog() {
        return logger.toString();
    }

    public void createDirs(String parent, String[] childrenDirsPath) {
        for (String child : childrenDirsPath) {
            File newDir = new File(parent, child);
            if (newDir.mkdir()) {
                logger.append(String.format("Папка %s создана успешно в каталоге %s", child, parent)).append("\n");
                fileList.add(newDir);
            } else {
                logger.append(String.format("Не удалось создать папку %s в каталоге %s", child, parent)).append("\n");
            }
        }
    }

    public void createFiles(String parent, String[] childrenFilesPath) {
        for (String child : childrenFilesPath) {
            try {
                File childFile = new File(parent, child);
                if (childFile.createNewFile()) {
                    logger.append(String.format("Файл %s создан успешно в каталоге %s", child, parent)).append("\n");
                    fileList.add(childFile);
                }
            } catch (IOException e) {
                logger.append(String.format("Ошибка при создании файла %s: %s", child, e.getMessage())).append("\n");
            }
        }
    }

    public File getFileByName(String name) {
        return fileList.stream().filter(file -> file.getName().equals(name)).findFirst().get();
    }

}
