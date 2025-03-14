package ru.mihozhereb;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Handler;
import ru.mihozhereb.io.ConsoleWorker;

public final class Main {
    private static final String DEFAULT_STORAGE_PATH = "storage.json";

    public static void main(final String... args) {
        new Main().run(args);
    }

    private void run(final String... args) {
        // set storagePath to file that contains collection's items and load it
        String storagePath = DEFAULT_STORAGE_PATH;
        if (args.length == 1) {
            storagePath = args[0];
        }
        CollectionManager.getInstance().setPath(storagePath);
        CollectionManager.getInstance().load();

        try (ConsoleWorker consoleWorker = new ConsoleWorker()) {
            consoleWorker.writeLn("Welcome!");
            String line;
            while ((line = consoleWorker.read()) != null) {
                consoleWorker.write(Handler.handle(line));
            }
        }
    }
}
