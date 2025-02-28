package ru.mihozhereb.collection.utils;

import java.io.IOException;

/**
 * ID generator class
 * <p>
 * Used singleton pattern
 */
public final class IdGenerator {
    private IdGenerator() throws IOException {  }

    /**
     * The only one instance of IdGenerator
     */
    private static IdGenerator instance;

    /**
     * Return instance of {@code IdGenerator}
     * @return IdGenerator instance
     */
    public static IdGenerator getInstance() throws IOException {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int getNewId() {
        // TODO
        return -1;
    }
}
