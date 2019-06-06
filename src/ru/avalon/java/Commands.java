package ru.avalon.java;

/**
 * Обрабатываемые приложением команды.
 */
public enum Commands {
    move("Переименование/Перемещение"),
    copy("Копирование"),
    delete("Удаление"),
    list("Список файлов в разделе"),
    exit("Выход"),
    help("Отображение доступных комманд"),;
    /*
     * TODO №8 К текущему списку команд, добавьте ещё две команды
     */
    private final String name;
    Commands(String s) {

        name = s;
    }
    public String getValue() {//метод для получения значения
        return name;
    }


    public static String getCommands(){
        String s = "Доступные комманды:\n";
        for(Commands c : Commands.values()) {
            s += c + " - " + c.getValue() + "\n";
        }
        return s;
    }

}
