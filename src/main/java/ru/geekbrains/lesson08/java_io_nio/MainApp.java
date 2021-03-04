package ru.geekbrains.lesson08.java_io_nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) {
        // Задание 1:
        Path fileWhereSearchTo = Paths.get("FileStorage/AggregatedData.txt");
        FileManager fileManager1 = new FileManager();
        fileManager1.searchFragment(fileWhereSearchTo, "Данные из файла");

        // Задание 2:
        File fileOfAggregation = new File("FileStorage/AggregatedData.txt");
        FileManager fileManager2 = new FileManager();
        fileManager2.combineFilesData(fileOfAggregation);
        fileManager2.printResultOfFilesAggregation(fileOfAggregation);

        // Задание 3:
        String folderForDeletion = "FolderForDeletion";
        File whereToDelete = new File("FileStorage");
        FileManager fileManager3 = new FileManager();
        fileManager3.deleteFolder(folderForDeletion, whereToDelete);
    }
}