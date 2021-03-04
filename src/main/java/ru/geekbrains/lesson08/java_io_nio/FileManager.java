package ru.geekbrains.lesson08.java_io_nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileManager {
    // Задание 1:
    public void searchFragment(Path whereToSearch, String whatToSearch) {
        try {
            List<String> lines = Files.readAllLines(whereToSearch, UTF_8);
            int count = 0;
            for (String s : lines) {
                if (s.contains(whatToSearch)) {
                    count++;
                }
            }
            System.out.println("Фрагмент \"" + whatToSearch + "\" встречается в файле \"" + whereToSearch.getFileName() + "\" " + count + " раз.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Задание 2:
    public void combineFilesData(File aggregatedData) {
        File directory = aggregatedData.getParentFile();
        //System.out.println(directory);
        File[] filesList = directory.listFiles();
        //System.out.println(Arrays.toString(filesList));
        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile() && !filesList[i].equals(aggregatedData)) {
                //System.out.println(filesList[i]);
                try (InputStreamReader in = new InputStreamReader(new FileInputStream(filesList[i]), "UTF-8")) {
                    int x;
                    while ((x = in.read()) != -1) {
                        //System.out.print((char)x);
                        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(aggregatedData, true))) {
                            out.write((char) x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printResultOfFilesAggregation(File aggregatedData) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(aggregatedData), "UTF-8")) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Задание 3:
    public void deleteFolder(String folderForDeletion, File whereToDelete) {
        File[] filesList = whereToDelete.listFiles();
        System.out.println(Arrays.toString(filesList));
        for (File file : filesList) {
            if (file.getName().equals(folderForDeletion)) {
                recursiveDelete(file);
            }
        }
    }

    public static void recursiveDelete(File fileForDeletion) {
        if (!fileForDeletion.exists())
            return;
        if (fileForDeletion.isDirectory()) {
            for (File f : fileForDeletion.listFiles()) {
                recursiveDelete(f);
            }
        }
        if (fileForDeletion.isFile()) {
            System.out.println("Произведено удаление файла: " + fileForDeletion.getAbsolutePath());
        } else {
            System.out.println("Произведено удаление папки: " + fileForDeletion.getAbsolutePath());
        }
        fileForDeletion.delete();
    }
}
