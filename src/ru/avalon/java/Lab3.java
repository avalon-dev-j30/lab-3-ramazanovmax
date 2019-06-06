package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileDeleteAction;
import ru.avalon.java.actions.FileListAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.console.ConsoleUI;

import java.io.*;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    private BufferedReader cmdReader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Введите help для получения списка комманд");
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        String n1, n2;
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                System.out.print("Имя файла: >");
                n1 = cmdReader.readLine();
                System.out.print("Копировать в: >");
                n2 = cmdReader.readLine();

                new FileCopyAction(n1, n2).start();
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                System.out.print("Имя файла: ");
                n1 = cmdReader.readLine();
                System.out.print("to: ");
                n2 = cmdReader.readLine();
                new FileMoveAction(n1, n2).start();
                break;
            case delete:
                /*
                 * TODO №7 Обработайте команду delete
                 */
                System.out.print("Имя удаляемого: ");
                n1 = cmdReader.readLine();
                new FileDeleteAction(n1).start();
                break;
            case exit:
                close();
                System.exit(0);
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
            case list:
                System.out.print("Введите название раздела или нажмите enter:");
                n1 = cmdReader.readLine();
                if(n1.length() == 0)n1 = ".";

                new FileListAction(n1).start();
                break;
            case help:
                    System.out.println(Commands.getCommands());
                break;
        }
    }
    
}
