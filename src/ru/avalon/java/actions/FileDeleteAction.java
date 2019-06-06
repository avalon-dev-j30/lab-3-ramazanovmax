package ru.avalon.java.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileDeleteAction implements Action {

    private Path file;

    public FileDeleteAction(String file) {
        this.file = Paths.get(file);
    }

    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileDeleteAction
         */

        try {
            if (!Files.exists(file)) {
                System.out.printf("Файл %s не найден", file.getFileName().toString());
            } else {
                Files.delete(file);
                System.out.printf("Файл %s удален", file.getFileName().toString());
            }
        } catch (IOException e) {
            System.out.printf("Файл %s не был удален!", file.getFileName().toString());
            e.printStackTrace(System.err);
        }
    }
}