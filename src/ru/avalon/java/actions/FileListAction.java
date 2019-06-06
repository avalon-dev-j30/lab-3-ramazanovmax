package ru.avalon.java.actions;

import java.io.File;

public class FileListAction implements Action  {

    private File file;
    public FileListAction(String from) {
        this.file = new File(from);
    }

    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileListAction
         */
        if(file.exists()){
            for (File fileEntry : file.listFiles()) {
                if (fileEntry.isDirectory()) {
                    System.out.println("/"+fileEntry.getName());
                } else {
                    System.out.println(fileEntry.getName());
                }
            }
        }else{
            System.out.printf("папка %s не найдена", file.toString());
        }
    }
}
