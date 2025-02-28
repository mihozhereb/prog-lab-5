package ru.mihozhereb.io;

public interface StringIOWorker extends IOWorker<String> {
    default void writeLn(String row) {
        write(row + System.lineSeparator());
    }
}
