package ru.avalon.java.actions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Абстрактное представление о действии, как функциональном
 * элементе приложения.
 * <p>
 * Действие является потоковым объектом, что позволяет
 * исполнять несколько действий параллельно и не блокировать
 * основной поток исполнения.
 */
public interface Action extends Runnable, AutoCloseable {
    ExecutorService service = Executors.newCachedThreadPool();
    /**
     * Запускает потоковый объект на исполнение в отдельном
     * потоке исполнения.
     */
    default void start() {
        /*
         * TODO №1 Реализуйте метод start интерфейса Action.
         */
        service.execute(this);
    }

    /**
     * {@inheritDoc}
     */
    default void close() {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        try {
            service.shutdown();
        } catch (Exception e) {
            System.out.printf("An error has occured. Error : %n%s", e.getMessage());
            service.shutdownNow();
        }

    }
    
}
