package ru.netology.task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameSaver {

    public void saveGame(GameProgress gameProgress, String saveGamePath) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(saveGamePath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String zipPath, List<String> saveGamePathList) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (int i = 1; i <= saveGamePathList.size(); i++) {
                try (FileInputStream fileInputStream = new FileInputStream(saveGamePathList.get(i - 1))) {
                    ZipEntry zipEntry = new ZipEntry("packed_" + i);
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] buffer = new byte[(fileInputStream.available())];
                    fileInputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFiles(List<String> saveGamePathList) {
        for (String saveGamePath : saveGamePathList) {
            File saveGameFile = new File(saveGamePath);
            saveGameFile.delete();
        }
    }

}
