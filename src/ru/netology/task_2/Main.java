package ru.netology.task_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String root = "/Users/darianos/Games/savegames";

        List<GameProgress> gameProgressList = new ArrayList<>();
        List<String> saveGamePathList = new ArrayList<>();
        GameSaver gameSaver = new GameSaver();

        gameProgressList.add(new GameProgress(10, 1, 11,1000));
        gameProgressList.add(new GameProgress(20, 2, 12,2000));
        gameProgressList.add(new GameProgress(30, 3, 13,3000));

        for (int i = 0; i < gameProgressList.size(); i++) {
            String savePath = String.format("%s/game_%d.dat", root, i+1);
            gameSaver.saveGame(gameProgressList.get(i), savePath);
            saveGamePathList.add(savePath);
        }

        gameSaver.zipFiles(root + "/savedGames.zip", saveGamePathList);
        gameSaver.deleteFiles(saveGamePathList);
    }

}
