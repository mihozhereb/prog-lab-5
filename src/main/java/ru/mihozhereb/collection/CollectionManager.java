package ru.mihozhereb.collection;

import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.io.JsonWorker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.TreeSet;

/**
 * CollectionManager singleton class
 */
public final class CollectionManager {
    private static final TreeSet<MusicBand> collection = new TreeSet<MusicBand>();
    private static String path;

    private CollectionManager() {  }

    private static CollectionManager instance;

    public static CollectionManager getInstance() {
        if (instance == null) {
            instance = new CollectionManager();
        }
        return instance;
    }

    public TreeSet<MusicBand> getCollection() {
        return collection;
    }

    public void load() {
        JsonWorker storage = new JsonWorker(path);
        if (storage.ready()) {
            collection.addAll(List.of(storage.read()));
        } else {
            throw new RuntimeException("Collection's storage file is not ready");
        }
    }

    public void save() {
        JsonWorker storage = new JsonWorker(path);
        if (storage.ready()) {
            storage.write(collection.toArray(new MusicBand[0]));
        } else {
            throw new RuntimeException("Collection's storage file is not ready");
        }
    }

    public void setPath(String newPath) {
        path = newPath;
    }
}
