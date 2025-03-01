package ru.mihozhereb.collection.utils;

import ru.mihozhereb.io.FileWorker;

/**
 * ID generator class
 * <p>
 * Used singleton pattern
 */
public final class IdGenerator {
    private IdGenerator() {  }

    /**
     * The only one instance of IdGenerator
     */
    private static IdGenerator instance;

    /**
     * Return instance of {@code IdGenerator}
     * @return IdGenerator instance
     */
    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int getNewId() {
        // TODO поменять путь
        String path = "src/main/java/ru/mihozhereb/collection/utils/ID_LOG";
        int previousId;
        try (FileWorker fileWorker = new FileWorker(path, true)) {
            previousId = Integer.parseInt(fileWorker.read());
        } catch (NumberFormatException e) {
            return -1;
        }
        try (FileWorker fileWorker = new FileWorker(path, false)) {
            fileWorker.write(String.valueOf(previousId + 1));
            return previousId + 1;
        }
    }
}
