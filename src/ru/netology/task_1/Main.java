package ru.netology.task_1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String root = "/Users/darianos/Games";

        FileCreator fileCreator = new FileCreator();
        fileCreator.createDirs(root, new String[]{"temp", "src", "res", "savegames", "src/main", "src/test", "res/drawables", "res/vectors", "res/icons"});
        fileCreator.createFiles(root, new String[]{"temp/temp.txt", "src/main/Main.java", "src/main/Utils.java"});

        try {
            FileWriter writer = new FileWriter(fileCreator.getFileByName("temp.txt"));
            writer.write(fileCreator.getLog());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

