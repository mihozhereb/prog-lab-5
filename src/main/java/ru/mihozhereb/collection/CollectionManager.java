package ru.mihozhereb.collection;

import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.io.JsonWorker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeSet;

/**
 * CollectionManager singleton class
 */
public final class CollectionManager {
    private static final TreeSet<MusicBand> COLLECTION = new TreeSet<MusicBand>();
    private static String path;
    private static final LocalDateTime creationDateTime = LocalDateTime.now();

    private CollectionManager() {  }

    private static CollectionManager instance;

    public static CollectionManager getInstance() {
        if (instance == null) {
            instance = new CollectionManager();
        }
        return instance;
    }

    public TreeSet<MusicBand> getCollection() {
        return COLLECTION;
    }

    public void load() {
        try (JsonWorker storage = new JsonWorker(path)) {
            if (storage.ready()) {
                MusicBand[] storageInner = storage.read();
                if (storageInner != null) {
                    COLLECTION.addAll(List.of(storageInner));
                }
            } else {
                throw new RuntimeException("Collection's storage file is not ready");
            }
        }
    }

    public void save() {
        try (JsonWorker storage = new JsonWorker(path)) {
            if (storage.ready()) {
                storage.write(COLLECTION.toArray(new MusicBand[0]));
            } else {
                throw new RuntimeException("Collection's storage file is not ready");
            }
        }
    }

    public void setPath(String newPath) {
        path = newPath;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}
