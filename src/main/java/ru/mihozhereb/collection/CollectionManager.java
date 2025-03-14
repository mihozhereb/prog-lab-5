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
    private static final TreeSet<MusicBand> COLLECTION = new TreeSet<>();
    private static String path;
    private static final LocalDateTime CREATION_DATE_TIME = LocalDateTime.now();

    private CollectionManager() {  }

    private static CollectionManager instance;

    /**
     * Return instance of {@code CollectionManager}
     *
     * @return CollectionManager instance
     */
    public static CollectionManager getInstance() {
        if (instance == null) {
            instance = new CollectionManager();
        }
        return instance;
    }

    /**
     * Return collection of {@code MusicBand}
     *
     * @return MusicBand's collection
     */
    public TreeSet<MusicBand> getCollection() {
        return COLLECTION;
    }

    /**
     * Load collection from file
     */
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

    /**
     * Save collection in file (json format)
     */
    public void save() {
        try (JsonWorker storage = new JsonWorker(path)) {
            if (storage.ready()) {
                storage.write(COLLECTION.toArray(new MusicBand[0]));
            } else {
                throw new RuntimeException("Collection's storage file is not ready");
            }
        }
    }

    /**
     * Set new path to back up file
     * @param newPath new path
     */
    public void setPath(String newPath) {
        path = newPath;
    }

    /**
     * Return date and time of init {@code CollectionManager}
     *
     * @return CREATION_DATE_TIME
     */
    public LocalDateTime getCreationDateTime() {
        return CREATION_DATE_TIME;
    }
}
