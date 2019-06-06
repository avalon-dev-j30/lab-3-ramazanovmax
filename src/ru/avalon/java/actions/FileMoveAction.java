package ru.avalon.java.actions;

import java.io.File;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {

    private File from;
    private File to;

    public FileMoveAction(String from, String to) {
        this.from = new File(from);
        this.to = new File(to);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        if(from.exists()){
            if (from.renameTo(to)) {
                System.out.printf("Файл %s успешно перемещён!", from.toString());
            } else {
                System.out.printf("Файл %s неудалось переместить.", from.toString());
            }
        }else{
            System.out.printf("Файл %s не найден", from.toString());
        }
    }

}
