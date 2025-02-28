package ru.mihozhereb;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Handler;
import ru.mihozhereb.io.ConsoleWorker;

public final class Main {
    public static void main(final String... args) {
        new Main().run(args);
    }

    private void run(final String... args) {
        // set path to file that contains collection's items and load it
        String path = "default_path";
        if (args.length == 1) {
            path = args[0];
        }
        CollectionManager.getInstance().setPath(path);
        CollectionManager.getInstance().load();

        ConsoleWorker consoleWorker = new ConsoleWorker();

        while (consoleWorker.ready()) {
            consoleWorker.write(Handler.handle(consoleWorker.read()));
        }
    }
}
