package ru.mihozhereb.io;

public interface IOWorker<T> {
    void write(T row);

    T read();

    Boolean ready();

    void close();
}
