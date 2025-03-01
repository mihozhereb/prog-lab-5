package ru.mihozhereb;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Handler;
import ru.mihozhereb.io.ConsoleWorker;

public final class Main {
    public static void main(final String... args) {
        new Main().run(args);
    }

    private void run(final String... args) {
        // set storagePath to file that contains collection's items and load it
        // TODO поменять путь
        String storagePath = "C:\\Users\\pro\\Downloads\\test123.json";
        if (args.length == 1) {
            storagePath = args[0];
        }
        CollectionManager.getInstance().setPath(storagePath);
        CollectionManager.getInstance().load();

        try (ConsoleWorker consoleWorker = new ConsoleWorker()) {
            String line;
            while ((line = consoleWorker.read()) != null) {
                consoleWorker.write(Handler.handle(line));
            }
        }
    }
}
// TODO добавить команды, сделать работу со скриптом из файла, закончить коменты под javadoc
