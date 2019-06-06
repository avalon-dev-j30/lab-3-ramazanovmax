package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    private Path from;
    private Path to;

    public FileCopyAction(String from, String to) {
        this.from = Paths.get(from);
        this.to = Paths.get(to);
    }
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */

        try {
            if (!Files.exists(from)) {
                System.out.printf("Файл %s не найден", from.getFileName().toString());
            }else{
                if (!Files.exists(to)) {
                        Files.createDirectory(to);
                }
                Files.copy(from, to, REPLACE_EXISTING);
                System.out.printf("Файл %s cкопирован в %s \n>",
                        from.getFileName().toString(),
                        to.getFileName().toString());
            }
        } catch (IOException e) {
            System.out.printf("Ошибка копирования: %n%s%n>",
                    e.getMessage());

        }
    }
}
