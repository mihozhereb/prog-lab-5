package ru.mihozhereb.io;

public interface IOWorker<T> extends AutoCloseable {
    void write(T row);

    T read();

    Boolean ready();

    void close();
}
